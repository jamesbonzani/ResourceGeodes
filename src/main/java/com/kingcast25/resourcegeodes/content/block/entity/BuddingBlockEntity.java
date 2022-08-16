package com.kingcast25.resourcegeodes.content.block.entity;

import com.kingcast25.resourcegeodes.config.ResourceGeodesCommonConfigs;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import com.kingcast25.resourcegeodes.content.block.custom.BaseClusterBlock;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.Nullable;


public class BuddingBlockEntity extends BlockEntity {

    public String geodeName;

    public int growthTier = 0;
    public static int baseRate = ResourceGeodesCommonConfigs.BASE_GROWTH_RATE.get();
    public static int tierRate = ResourceGeodesCommonConfigs.TIER_GROWTH_RATE.get();




    public BuddingBlockEntity(BlockPos p_155229_, BlockState state) {
        super(ModBlockEntities.BUDDING_BLOCK_ENTITY.get(), p_155229_, state);
        geodeName = BaseBuddingBlock.getGeodeName(state.getBlock());

    }

    public static <T> void tick(Level level, BlockPos pos, BlockState state, T blockEntity){

        if(!level.isClientSide){
            if (level.random.nextInt(baseRate) == 0) {
                //ResourceGeodes.logInfo(((BuddingBlockEntity) blockEntity).geodeName + " blockEntity has tier of: " + ((BuddingBlockEntity) blockEntity).getGrowthTier());
                if (level.random.nextInt(tierRate * (tierRate - ((BuddingBlockEntity) blockEntity).getGrowthTier()) + 1) == 0) {
                    GeodeType geodeType = ModBlocks.geodes.get(((BaseBuddingBlock) state.getBlock()).getGeodeName(state.getBlock()));
                    Direction direction = Direction.values()[level.random.nextInt(Direction.values().length)];
                    BlockPos blockpos = pos.relative(direction);
                    BlockState blockstate = level.getBlockState(blockpos);
                    Block block = null;

                    if (canClusterGrowAtState(blockstate)) {
                        if (geodeType != null) {
                            block = geodeType.clusters.get(0).get();
                        }
                    } else if (blockstate.getBlock() instanceof BaseClusterBlock && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {

                        String fullName = blockstate.getBlock().getRegistryName().getPath();
                        //ResourceGeodes.logInfo(fullName);
                        String[] parts = fullName.split("_");

                        switch (parts[0]) {
                            case "small":
                                block = geodeType.clusters.get(1).get();
                                break;
                            case "medium":
                                block = geodeType.clusters.get(2).get();
                                break;
                            case "large":
                                block = geodeType.clusters.get(3).get();

                        }


                    }
                    if (block != null) {
                        BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                        level.setBlockAndUpdate(blockpos, blockstate1);
                    }
                }
            }
        }
    }
    public static boolean canClusterGrowAtState(BlockState p_152735_) {
        return p_152735_.isAir() || p_152735_.is(Blocks.WATER) && p_152735_.getFluidState().getAmount() == 8;
    }


    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
       tag.putInt("growthTier", this.getGrowthTier());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.setGrowthTier(tag.getInt("growthTier"));
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("growthTier", this.getGrowthTier());
        return tag;
    }


    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void setName(String name){
        this.geodeName = name;
    }




    public void setGrowthTier(int x){
        this.growthTier = x;
    }


    public int getGrowthTier() {
        return this.growthTier;
    }



}

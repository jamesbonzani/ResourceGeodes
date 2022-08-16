package com.kingcast25.resourcegeodes.content.block.custom;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.entity.BuddingBlockEntity;
import com.kingcast25.resourcegeodes.content.block.entity.ModBlockEntities;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import com.kingcast25.resourcegeodes.content.item.custom.CatalystItem;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.core.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class BaseBuddingBlock extends BaseEntityBlock {


  //  private static final Direction[] DIRECTIONS = Direction.values();







    public BaseBuddingBlock(Properties p_152726_) {
        super(p_152726_);

    }

    public PushReaction getPistonPushReaction(BlockState p_152733_) {
        return PushReaction.DESTROY;
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (!level.isClientSide) {
            if (player.getItemInHand(hand).getItem() instanceof CatalystItem) {
                int tier = Integer.parseInt(player.getItemInHand(hand).getItem().getRegistryName().toString().split("_")[1]);
                BlockEntity be = level.getBlockEntity(pos);
                if (be instanceof BuddingBlockEntity) {
                    if (tier > ((BuddingBlockEntity) be).getGrowthTier()) {
                        player.getItemInHand(hand).hurtAndBreak(1, player, (p) -> {
                            p.broadcastBreakEvent(hand);
                        });
                        ((BuddingBlockEntity) be).setGrowthTier(tier);
                        level.sendBlockUpdated(pos, state, state, 2);
                        level.playSound(player, pos, SoundEvents.AMETHYST_CLUSTER_HIT, SoundSource.BLOCKS, 2.0F, 0.5F + level.random.nextFloat() * 1.2F);
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.PASS;
    }







    @Override
    public void randomTick(BlockState p_152728_, ServerLevel p_152729_, BlockPos p_152730_, Random p_152731_) {
        /*if (p_152731_.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[p_152731_.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = p_152730_.relative(direction);
            BlockState blockstate = p_152729_.getBlockState(blockpos);
            Block block = null;
            GeodeType thisGeode = ModBlocks.geodes.get(getGeodeName(p_152728_.getBlock()));
            if (canClusterGrowAtState(blockstate)) {
                if(thisGeode != null) {
                    block = thisGeode.clusters[0].get();
                }
            } else if (blockstate.getBlock() instanceof BaseClusterBlock && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                int clusterSize = blockstate.getValue(BaseClusterBlock.SIZE);
                ResourceGeodes.logInfo("Trying to grow cluster of size: "+clusterSize);
                 if (clusterSize < 4) {
                     if(thisGeode != null) {
                         block = thisGeode.clusters[clusterSize].get();
                     }
                 }
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                p_152729_.setBlockAndUpdate(blockpos, blockstate1);
            }

        }

         */
    }



    public static String capitalize(String s){
        return s.substring(0,1).toUpperCase(Locale.ROOT)+s.substring(1);
    }


    public static String getGeodeName(Block block){
        String fullName = block.getRegistryName().toString();
        String[] parts = fullName.split("_");
        if (parts.length > 1){
            //ResourceGeodes.logInfo(parts[1]);
            return parts[1];
        }
        return "";
    }







    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        BuddingBlockEntity be = new BuddingBlockEntity(pos, state);
        be.setName(getGeodeName(state.getBlock()));
        return be;
    }


    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> type) {
        return type == ModBlockEntities.BUDDING_BLOCK_ENTITY.get() ? BuddingBlockEntity::tick : null;
    }
}


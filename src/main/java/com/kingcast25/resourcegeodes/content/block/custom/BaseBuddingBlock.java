package com.kingcast25.resourcegeodes.content.block.custom;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import org.apache.logging.log4j.core.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBuddingBlock extends BuddingAmethystBlock {

    

    private static final Direction[] DIRECTIONS = Direction.values();







    public BaseBuddingBlock(Properties p_152726_, int color) {
        super(p_152726_);

    }

    public PushReaction getPistonPushReaction(BlockState p_152733_) {
        return PushReaction.DESTROY;
    }


    @Override
    public void randomTick(BlockState p_152728_, ServerLevel p_152729_, BlockPos p_152730_, Random p_152731_) {
        if (p_152731_.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[p_152731_.nextInt(DIRECTIONS.length)];
            BlockPos blockpos = p_152730_.relative(direction);
            BlockState blockstate = p_152729_.getBlockState(blockpos);
            Block block = null;
            GeodeType thisGeode = ModBlocks.geodes.get(getGeodeName(p_152728_.getBlock()));
            if (canClusterGrowAtState(blockstate)) {
                if(thisGeode != null) {
                    block = thisGeode.clusters.get(0).get();
                }
            } else if (blockstate.getBlock() instanceof BaseClusterBlock && blockstate.getValue(AmethystClusterBlock.FACING) == direction) {
                int clusterSize = blockstate.getValue(BaseClusterBlock.SIZE);
                ResourceGeodes.logInfo("Trying to grow cluster of size: "+clusterSize);
                 if (clusterSize < 4) {
                     if(thisGeode != null) {
                         block = thisGeode.clusters.get(clusterSize).get();
                     }
                 }
            }

            if (block != null) {
                BlockState blockstate1 = block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction).setValue(AmethystClusterBlock.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
                p_152729_.setBlockAndUpdate(blockpos, blockstate1);
            }

        }
    }


    public static String getGeodeName(Block block){
        String fullName = block.getRegistryName().toString();
        String[] parts = fullName.split("_");
        if (parts.length > 1){
            ResourceGeodes.logInfo(parts[1]);
            return parts[1];
        }
        return "";
    }



    public static boolean canClusterGrowAtState(BlockState p_152735_) {
        return p_152735_.isAir() || p_152735_.is(Blocks.WATER) && p_152735_.getFluidState().getAmount() == 8;
    }



}


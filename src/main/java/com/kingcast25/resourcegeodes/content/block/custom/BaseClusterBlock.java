package com.kingcast25.resourcegeodes.content.block.custom;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BaseClusterBlock extends AmethystClusterBlock {

    public static final IntegerProperty SIZE = IntegerProperty.create("size", 0, 4);



    public BaseClusterBlock(int a, int b, Properties properties, int color, int size) {
        super(a, b, properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(SIZE, size));


    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(SIZE);
    }




}







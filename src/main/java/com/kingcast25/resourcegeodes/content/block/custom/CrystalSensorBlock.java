package com.kingcast25.resourcegeodes.content.block.custom;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CrystalSensorBlock extends DirectionalBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;

    public CrystalSensorBlock(Properties p_49795_) {
        super(p_49795_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.SOUTH).setValue(POWERED, Boolean.valueOf(false)));
    }



    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55125_) {
        p_55125_.add(FACING, POWERED);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos1, Block bl, BlockPos pos2, boolean b) {
        //ResourceGeodes.logInfo(pos1.toString()+" detected a change at "+pos2.toString());
        //ResourceGeodes.logInfo(pos1.relative(state.getValue(FACING)).toString());
        if(pos1.relative(state.getValue(FACING)).equals(pos2)){
            //ResourceGeodes.logInfo("facing");
            Block block = level.getBlockState(pos2).getBlock();
            //ResourceGeodes.logInfo(level.getBlockState(pos2).getBlock().getRegistryName().toString());
            if (checkFullCluster(block)){
                ResourceGeodes.logInfo("Powering");
                BlockState state1 = state.setValue(POWERED, true);
                level.setBlockAndUpdate(pos1, state1);
            }
            else {
                BlockState state2 = state.setValue(POWERED, false);
                level.setBlockAndUpdate(pos1, state2);
            }
        }
    }


    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        if (direction != null){
            return direction.equals(level.getBlockState(pos).getValue(FACING));
        }
        return false;
    }

    public BlockState rotate(BlockState p_55115_, Rotation p_55116_) {
        return p_55115_.setValue(FACING, p_55116_.rotate(p_55115_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_55112_, Mirror p_55113_) {
        return p_55112_.rotate(p_55113_.getRotation(p_55112_.getValue(FACING)));
    }

    @Override
    public int getSignal(BlockState state, BlockGetter getter, BlockPos p_60485_, Direction p_60486_) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    public boolean isSignalSource(BlockState p_55138_) {
        return this.stateDefinition.any().getValue(POWERED);
    }


    public BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Direction lookDir = ctx.getPlayer().isShiftKeyDown() ? ctx.getNearestLookingDirection().getOpposite().getOpposite() :  ctx.getNearestLookingDirection().getOpposite();
        boolean powered = checkFullCluster(ctx.getLevel().getBlockState(ctx.getClickedPos().relative(lookDir)).getBlock());
        return this.defaultBlockState().setValue(FACING, lookDir).setValue(POWERED, powered);

    }


    public boolean checkFullCluster(Block block){
        String fullName = block.getRegistryName().getPath();
        String[] parts = fullName.split("_");
        ResourceGeodes.logInfo(parts[0]);
        return parts[0].equals("full");
    }



}

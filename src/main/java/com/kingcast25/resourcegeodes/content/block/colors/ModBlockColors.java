package com.kingcast25.resourcegeodes.content.block.colors;

import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import com.kingcast25.resourcegeodes.content.block.custom.BaseClusterBlock;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;


public class ModBlockColors {


    public static BlockColor blockColor = (blockState, blockAndTintGetter, blockPos, x) -> 0;

    public static List<Block> blocks = new ArrayList<Block>();





    public static synchronized void registerBlockColors(final ColorHandlerEvent.Block event) {
       Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
       while (geodeIt.hasNext()){
           GeodeType currGeode = geodeIt.next();


           event.getBlockColors().register((unknown, lightReader, pos, unknown2) -> currGeode.getColor(),
                  currGeode.SMALL.get(),currGeode.MEDIUM.get(),currGeode.LARGE.get(),currGeode.FULL.get(),currGeode.BUDDING.get() );
        }
    }


    public static synchronized void onItemColorsInit(BlockColors blockColors, ItemColors itemColors) {
        // Use the Block's colour handler from BlockItem
        ItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(state, null, null, tintIndex);
        };

        Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
        while (geodeIt.hasNext()) {
            GeodeType currGeode = geodeIt.next();
            itemColors.register(itemBlockColourHandler,   currGeode.SMALL.get(),currGeode.MEDIUM.get(),currGeode.LARGE.get(),currGeode.FULL.get(),currGeode.BUDDING.get() );

        }

    }





}

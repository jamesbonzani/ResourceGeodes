package com.kingcast25.resourcegeodes.client.event;

import com.ibm.icu.impl.coll.CollationRoot;
import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.colors.ModBlockColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventsHandler {

    @SubscribeEvent
    public static void onColorHandlerEvent$Block(ColorHandlerEvent.Block event) {
        ResourceGeodes.logInfo("Registering Block Colors");
        ModBlockColors.registerBlockColors(event);
    }

    @SubscribeEvent
    public static void onColorHandlerEvent$Item(ColorHandlerEvent.Item event) {
        ResourceGeodes.logInfo("Registering Item Colors");
      ModBlockColors.onItemColorsInit(event.getBlockColors(), event.getItemColors());
    }
}

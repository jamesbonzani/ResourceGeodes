package com.kingcast25.resourcegeodes.client.event;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.client.render.BuddingBlockBER;
import com.kingcast25.resourcegeodes.content.block.colors.ModBlockColors;
import com.kingcast25.resourcegeodes.content.block.entity.ModBlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ResourceGeodes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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


    @SubscribeEvent
    public static void register(final EntityRenderersEvent.RegisterRenderers event){

        ResourceGeodes.logInfo("Registering BERs");
        event.registerBlockEntityRenderer(ModBlockEntities.BUDDING_BLOCK_ENTITY.get(), BuddingBlockBER::new);
    }


}

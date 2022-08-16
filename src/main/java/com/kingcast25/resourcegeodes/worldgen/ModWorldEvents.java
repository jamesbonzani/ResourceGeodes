package com.kingcast25.resourcegeodes.worldgen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.worldgen.gen.ModGeodeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ResourceGeodes.MOD_ID)
public class ModWorldEvents {


    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event){
        ModGeodeGeneration.generateGeodes(event);
    }



}

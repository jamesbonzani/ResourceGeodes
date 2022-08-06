package com.kingcast25.resourcegeodes.datagen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = ResourceGeodes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) throws IOException {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        ResourceGeodes.logInfo("Generating Data Files");
        generator.addProvider(new ModLootTableProvider(generator));
        generator.addProvider(new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(new ModBlockStateProvider(generator, existingFileHelper));
        generator.addProvider(new ModLanguageProvider(generator, "en_us"));
        generator.addProvider(new ModTagProvider(generator,existingFileHelper));

        generator.run();
    }


}

package com.kingcast25.resourcegeodes.worldgen.gen;

import com.kingcast25.resourcegeodes.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.List;

public class ModGeodeGeneration {
    public static void generateGeodes(final BiomeLoadingEvent event){

        List<Holder<PlacedFeature>> base = event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES);


        base.add(ModPlacedFeatures.IRON_GEODE_PLACED);
        base.add(ModPlacedFeatures.COPPER_GEODE_PLACED);
        base.add(ModPlacedFeatures.COAL_GEODE_PLACED);
        base.add(ModPlacedFeatures.REDSTONE_GEODE_PLACED);
        base.add(ModPlacedFeatures.GOLD_GEODE_PLACED);
        base.add(ModPlacedFeatures.LAPIS_GEODE_PLACED);
        base.add(ModPlacedFeatures.DIAMOND_GEODE_PLACED);

        if (event.getCategory() == Biome.BiomeCategory.MOUNTAIN) {
            base.add(ModPlacedFeatures.EMERALD_GEODE_PLACED);
        }

    }
}

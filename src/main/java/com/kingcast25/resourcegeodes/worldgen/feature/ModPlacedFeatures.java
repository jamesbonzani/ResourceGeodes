package com.kingcast25.resourcegeodes.worldgen.feature;

import com.kingcast25.resourcegeodes.config.ResourceGeodesCommonConfigs;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;

public class ModPlacedFeatures {

    public static int LowTierRate = ResourceGeodesCommonConfigs.TIER_ONE_PER_CHUNK.get();
    public static int MidTierRate = ResourceGeodesCommonConfigs.TIER_TWO_PER_CHUNK.get();
    public static int HighTierRate = ResourceGeodesCommonConfigs.TIER_THREE_PER_CHUNK.get();

    public static int TIER_1_MIN_Y = ResourceGeodesCommonConfigs.TIER_ONE_MIN_Y.get();
    public static int TIER_1_MAX_Y = ResourceGeodesCommonConfigs.TIER_ONE_MAX_Y.get();
    public static int TIER_2_MIN_Y = ResourceGeodesCommonConfigs.TIER_TWO_MIN_Y.get();
    public static int TIER_2_MAX_Y = ResourceGeodesCommonConfigs.TIER_TWO_MAX_Y.get();
    public static int TIER_3_MIN_Y = ResourceGeodesCommonConfigs.TIER_THREE_MIN_Y.get();
    public static int TIER_3_MAX_Y = ResourceGeodesCommonConfigs.TIER_THREE_MAX_Y.get();


    //Low tier

    public static final Holder<PlacedFeature> IRON_GEODE_PLACED = PlacementUtils.register("iron_geode_placed",
            ModConfiguredFeatures.IRON_GEODE, RarityFilter.onAverageOnceEvery(LowTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_1_MIN_Y),
                    VerticalAnchor.absolute(TIER_1_MAX_Y)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> COPPER_GEODE_PLACED = PlacementUtils.register("copper_geode_placed",
            ModConfiguredFeatures.COPPER_GEODE, RarityFilter.onAverageOnceEvery(LowTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_1_MIN_Y),
                    VerticalAnchor.absolute(TIER_1_MAX_Y)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> COAL_GEODE_PLACED = PlacementUtils.register("coal_geode_placed",
            ModConfiguredFeatures.COAL_GEODE, RarityFilter.onAverageOnceEvery(LowTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_1_MIN_Y),
                    VerticalAnchor.absolute(TIER_1_MAX_Y)), BiomeFilter.biome());






    //Medium tier

    public static final Holder<PlacedFeature> GOLD_GEODE_PLACED = PlacementUtils.register("gold_geode_placed",
            ModConfiguredFeatures.GOLD_GEODE, RarityFilter.onAverageOnceEvery(MidTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_2_MIN_Y),
                    VerticalAnchor.absolute(TIER_2_MAX_Y)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> LAPIS_GEODE_PLACED = PlacementUtils.register("lapis_geode_placed",
            ModConfiguredFeatures.LAPIS_GEODE, RarityFilter.onAverageOnceEvery(MidTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_2_MIN_Y),
                    VerticalAnchor.absolute(TIER_2_MAX_Y)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> REDSTONE_GEODE_PLACED = PlacementUtils.register("redstone_geode_placed",
            ModConfiguredFeatures.REDSTONE_GEODE, RarityFilter.onAverageOnceEvery(MidTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_2_MIN_Y),
                    VerticalAnchor.absolute(TIER_2_MAX_Y)), BiomeFilter.biome());




    //High tier
    public static final Holder<PlacedFeature> DIAMOND_GEODE_PLACED = PlacementUtils.register("diamond_geode_placed",
            ModConfiguredFeatures.DIAMOND_GEODE, RarityFilter.onAverageOnceEvery(HighTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_3_MIN_Y),
                    VerticalAnchor.absolute(TIER_3_MAX_Y)), BiomeFilter.biome());

    public static final Holder<PlacedFeature> EMERALD_GEODE_PLACED = PlacementUtils.register("emerald_geode_placed",
            ModConfiguredFeatures.EMERALD_GEODE, RarityFilter.onAverageOnceEvery(HighTierRate),
            InSquarePlacement.spread(), HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(TIER_3_MIN_Y),
                    VerticalAnchor.absolute(TIER_3_MAX_Y)), BiomeFilter.biome());

}

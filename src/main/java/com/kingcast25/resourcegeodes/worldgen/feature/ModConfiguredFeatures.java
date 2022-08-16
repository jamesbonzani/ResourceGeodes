package com.kingcast25.resourcegeodes.worldgen.feature;

import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {

    public static GeodeLayerSettings SETTINGS = new GeodeLayerSettings(1D, 1D, 1D, 1D);


    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> IRON_GEODE =
        FeatureUtils.register("iron_geode", Feature.GEODE,
                new GeodeConfiguration(
                        new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                BlockStateProvider.simple(Blocks.COBBLESTONE),
                                BlockStateProvider.simple(ModBlocks.geodes.get("iron").BUDDING.get()),
                                BlockStateProvider.simple(Blocks.CALCITE),
                                BlockStateProvider.simple(Blocks.TUFF),
                                List.of(ModBlocks.geodes.get("iron").SMALL.get().defaultBlockState(),
                                        ModBlocks.geodes.get("iron").MEDIUM.get().defaultBlockState(),
                                        ModBlocks.geodes.get("iron").LARGE.get().defaultBlockState(),
                                        ModBlocks.geodes.get("iron").FULL.get().defaultBlockState()),
                                BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                        SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                        ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                        -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> COPPER_GEODE =
            FeatureUtils.register("copper_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("copper").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("copper").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("copper").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("copper").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("copper").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> COAL_GEODE =
            FeatureUtils.register("coal_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("coal").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("coal").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("coal").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("coal").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("coal").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> REDSTONE_GEODE =
            FeatureUtils.register("redstone_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("redstone").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("redstone").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("redstone").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("redstone").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("redstone").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> LAPIS_GEODE =
            FeatureUtils.register("lapis_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("lapis").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("lapis").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("lapis").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("lapis").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("lapis").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> GOLD_GEODE =
            FeatureUtils.register("gold_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("gold").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("gold").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("gold").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("gold").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("gold").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> DIAMOND_GEODE =
            FeatureUtils.register("diamond_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("diamond").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("diamond").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("diamond").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("diamond").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("diamond").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    public static final Holder<ConfiguredFeature<GeodeConfiguration, ?>> EMERALD_GEODE =
            FeatureUtils.register("emerald_geode", Feature.GEODE,
                    new GeodeConfiguration(
                            new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                                    BlockStateProvider.simple(Blocks.COBBLESTONE),
                                    BlockStateProvider.simple(ModBlocks.geodes.get("emerald").BUDDING.get()),
                                    BlockStateProvider.simple(Blocks.CALCITE),
                                    BlockStateProvider.simple(Blocks.TUFF),
                                    List.of(ModBlocks.geodes.get("emerald").SMALL.get().defaultBlockState(),
                                            ModBlocks.geodes.get("emerald").MEDIUM.get().defaultBlockState(),
                                            ModBlocks.geodes.get("emerald").LARGE.get().defaultBlockState(),
                                            ModBlocks.geodes.get("emerald").FULL.get().defaultBlockState()),
                                    BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS),
                            SETTINGS, new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D, true,
                            ConstantInt.of(3), ConstantInt.of(2), ConstantInt.of(1),
                            -16, 16, 0.05D, 1));

    }










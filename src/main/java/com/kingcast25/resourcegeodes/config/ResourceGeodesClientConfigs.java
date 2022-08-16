package com.kingcast25.resourcegeodes.config;

import net.minecraftforge.common.ForgeConfigSpec;
import org.jline.utils.Colors;

import java.awt.*;

public class ResourceGeodesClientConfigs {


    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue RENDER_TIER;
    public static final ForgeConfigSpec.ConfigValue<Float> CYCLE_SPEED;

    public static final ForgeConfigSpec.IntValue TIER_1_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_2_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_3_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_4_COLOR;


    static {

        BUILDER.push("Tier Rendering Configs");
        RENDER_TIER = BUILDER.comment("Should Block Outline be Rendered on Upgraded Tiers?").define("Render Tier Outlines", true);
        CYCLE_SPEED = BUILDER.comment("How Fast Should Colors Cycle on Tier 5?")
                .defineInRange("Cycle Speed", Float.valueOf("0.005F"), Float.valueOf("0.0001F"), Float.valueOf("1.0F"), Float.class);
        TIER_1_COLOR = BUILDER.comment("Color for Tier 1 Outline").defineInRange("Tier 1 Color", Color.orange.getRGB(),Color.black.getRGB(), Color.white.getRGB());
        TIER_2_COLOR = BUILDER.comment("Color for Tier 2 Outline").defineInRange("Tier 2 Color", Color.green.getRGB(),Color.black.getRGB(), Color.white.getRGB());
        TIER_3_COLOR = BUILDER.comment("Color for Tier 3 Outline").defineInRange("Tier 3 Color", Color.yellow.getRGB(),Color.black.getRGB(), Color.white.getRGB());
        TIER_4_COLOR = BUILDER.comment("Color for Tier 4 Outline").defineInRange("Tier 4 Color", Color.blue.getRGB(),Color.black.getRGB(), Color.white.getRGB());







        SPEC = BUILDER.build();
    }
}

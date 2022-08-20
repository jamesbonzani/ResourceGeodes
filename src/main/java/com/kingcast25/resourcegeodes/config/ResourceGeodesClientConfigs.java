package com.kingcast25.resourcegeodes.config;

import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import net.minecraftforge.common.ForgeConfigSpec;
import org.jline.utils.Colors;

import java.awt.*;

public class ResourceGeodesClientConfigs {


    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue RENDER_TIER;
    public static final ForgeConfigSpec.IntValue CYCLE_SPEED;

    public static final ForgeConfigSpec.IntValue BASE_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_1_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_2_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_3_COLOR;
    public static final ForgeConfigSpec.IntValue TIER_4_COLOR;


    static {


        BUILDER.push("Tier Rendering Configs");
        RENDER_TIER = BUILDER.comment("Should Block Outline be Rendered on Upgraded Tiers?").define("Render Tier Outlines", true);
        CYCLE_SPEED = BUILDER.comment("How Fast Should Colors Cycle on Tier 5?").defineInRange("Cycle Speed", 10, 1,100);
        BASE_COLOR = BUILDER.comment("Color for Base Outline").defineInRange("Base Color", Color.gray.getRGB(),Color.black.getRGB(), Color.white.getRGB());
        TIER_1_COLOR = BUILDER.comment("Color for Tier 1 Outline").defineInRange("Tier 1 Color", Color.red.getRGB(),Color.black.getRGB(), Color.white.getRGB());
        TIER_2_COLOR = BUILDER.comment("Color for Tier 2 Outline").defineInRange("Tier 2 Color", Color.HSBtoRGB(0.4166f, 1f, 1f),Color.black.getRGB(), Color.white.getRGB());
        TIER_3_COLOR = BUILDER.comment("Color for Tier 3 Outline").defineInRange("Tier 3 Color", Color.yellow.getRGB(), Color.black.getRGB(), Color.white.getRGB());
        TIER_4_COLOR = BUILDER.comment("Color for Tier 4 Outline").defineInRange("Tier 4 Color", Color.HSBtoRGB(0.5555f, 1f, 1f),Color.black.getRGB(), Color.white.getRGB());
        BUILDER.pop();






        SPEC = BUILDER.build();
    }
}

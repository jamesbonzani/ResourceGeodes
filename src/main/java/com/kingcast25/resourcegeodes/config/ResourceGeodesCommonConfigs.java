package com.kingcast25.resourcegeodes.config;


import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import org.lwjgl.system.CallbackI;

public class ResourceGeodesCommonConfigs {


    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;





    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_ONE_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_TWO_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_THREE_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_ONE_MIN_Y;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_TWO_MIN_Y;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_THREE_MIN_Y;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_ONE_MAX_Y;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_TWO_MAX_Y;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_THREE_MAX_Y;

    public static final ForgeConfigSpec.ConfigValue<Integer> BASE_GROWTH_RATE;
    public static final ForgeConfigSpec.ConfigValue<Integer> TIER_GROWTH_RATE;

    public static final ForgeConfigSpec.BooleanValue DEBUG_MESSAGES;




    static {
        BUILDER.push("Geode Generation Configs");
        TIER_ONE_PER_CHUNK = BUILDER.comment("Average Chunks per Tier 1 Geode").defineInRange("Chunks Per Tier 1 Geodes", 16, 1, Integer.MAX_VALUE);
        TIER_TWO_PER_CHUNK = BUILDER.comment("Average Chunks per Tier 2 Geode").defineInRange("Chunks Per Tier 2 Geodes", 32, 1, Integer.MAX_VALUE);
        TIER_THREE_PER_CHUNK = BUILDER.comment("Average Chunks per Tier 3 Geode").defineInRange("Chunks Per Tier 3 Geodes", 64, 1, Integer.MAX_VALUE);
        TIER_ONE_MIN_Y = BUILDER.comment("Tier 1 Geode Minimum Y Level").defineInRange("Tier 1 Geode Minimum Y", 0, -64, 320);
        TIER_ONE_MAX_Y = BUILDER.comment("Tier 1 Geode Maximum Y Level").defineInRange("Tier 1 Geode Maximum Y", 128, -64, 320);
        TIER_TWO_MIN_Y = BUILDER.comment("Tier 2 Geode Minimum Y Level").defineInRange("Tier 2 Geode Minimum Y", -32, -64, 320);
        TIER_TWO_MAX_Y = BUILDER.comment("Tier 2 Geode Maximum Y Level").defineInRange("Tier 2 Geode Maximum Y", 32, -64, 320);
        TIER_THREE_MIN_Y = BUILDER.comment("Tier 3 Geode Minimum Y Level").defineInRange("Tier 3 Geode Minimum Y", -64, -64, 320);
        TIER_THREE_MAX_Y = BUILDER.comment("Tier 3 Geode Maximum Y Level").defineInRange("Tier 3 Geode Maximum Y", 0, -64, 320);
        BUILDER.pop();


        BUILDER.push("Cluster Growth Configs");
        BASE_GROWTH_RATE = BUILDER.comment("Base Cluster Growth Rate (ticks per growth attempt)")
                .defineInRange("Base Cluster Growth Rate", 5, 1, Integer.MAX_VALUE);
        TIER_GROWTH_RATE = BUILDER.comment("Cluster Growth Rate per Tier (ticks per growth attempt)")
                .defineInRange("Tier Cluster Growth Rate", 5, 1, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Debug");
        DEBUG_MESSAGES = BUILDER.comment("Log Debug Messages?").define("Debug Messages", false);
        BUILDER.pop();




        SPEC = BUILDER.build();
    }



}

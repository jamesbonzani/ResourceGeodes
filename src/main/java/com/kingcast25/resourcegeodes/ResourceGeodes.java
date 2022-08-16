package com.kingcast25.resourcegeodes;


import com.kingcast25.resourcegeodes.config.ResourceGeodesClientConfigs;
import com.kingcast25.resourcegeodes.config.ResourceGeodesCommonConfigs;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.entity.ModBlockEntities;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import com.kingcast25.resourcegeodes.content.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.Iterator;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ResourceGeodes.MOD_ID)
public class ResourceGeodes
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final String MOD_ID = "resourcegeodes";

    public static final CreativeModeTab MOD_TAB = new ModTab("resource_geodes");


    public ResourceGeodes()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ResourceGeodesCommonConfigs.SPEC);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ResourceGeodesClientConfigs.SPEC);

        LOGGER.info("Registering Blocks");
        ModBlocks.blockSetup();
        ModBlocks.register(bus);
        ModItems.register(bus);

        ModBlockEntities.register(bus);

        // Register the setup method for modloading
        bus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        bus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        bus.addListener(this::processIMC);

        bus.addListener(this::clientLoad);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.info("Mod Registered");





    }



    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }


    public void clientLoad(final FMLClientSetupEvent event) {
        Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
        LOGGER.info("Setting Render Layers for Clusters");
        while (geodeIt.hasNext()){
            GeodeType currGeode = geodeIt.next();

            ItemBlockRenderTypes.setRenderLayer(currGeode.SMALL.get(),RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(currGeode.MEDIUM.get(),RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(currGeode.LARGE.get(),RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(currGeode.FULL.get(),RenderType.cutoutMipped());

            }

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    public static void logInfo(String text){
        if (ResourceGeodesCommonConfigs.DEBUG_MESSAGES.get()){
            LOGGER.info(text);
        }
    }





}



class ModTab extends CreativeModeTab {

    public ModTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(Items.AMETHYST_CLUSTER);
    }
}

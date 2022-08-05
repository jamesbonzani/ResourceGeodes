package com.kingcast25.resourcegeodes.content.block;


import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.custom.CrystalSensorBlock;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,ResourceGeodes.MOD_ID);
    public static HashMap<String,GeodeType> geodes = new HashMap<String, GeodeType>();


    public static void blockSetup(){

         geodes.put("iron",new GeodeType("iron", FastColor.ARGB32.color(255,227, 210, 163), Items.RAW_IRON));
         geodes.put("gold",new GeodeType("gold", FastColor.ARGB32.color(255,255, 203, 48), Items.RAW_GOLD));


        ResourceGeodes.logInfo(geodes.size() + " Geodes Created");

    }

    public static final RegistryObject<Block> SENSOR = BLOCKS.register("crystal_sensor", () -> new CrystalSensorBlock(BlockBehaviour.Properties.copy(Blocks.OBSERVER)));











    //BlockItem Creation

   @SubscribeEvent
   public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BLOCKS.getEntries().stream().map(RegistryObject::get).forEach( (block) -> {
            final Item.Properties properties = new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });
    }


    public static void register(IEventBus bus){
        BLOCKS.register(bus);
    }


}

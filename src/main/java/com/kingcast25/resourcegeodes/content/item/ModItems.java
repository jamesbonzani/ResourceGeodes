package com.kingcast25.resourcegeodes.content.item;


import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.item.custom.CatalystItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceGeodes.MOD_ID);



    public static final RegistryObject<Item> CATALYST_1 = ITEMS.register("catalyst_1", () ->
            new CatalystItem(new Item.Properties().tab(ResourceGeodes.MOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> CATALYST_2 = ITEMS.register("catalyst_2", () ->
            new CatalystItem(new Item.Properties().tab(ResourceGeodes.MOD_TAB).stacksTo(1)));


    public static final RegistryObject<Item> CATALYST_3 = ITEMS.register("catalyst_3", () ->
            new CatalystItem(new Item.Properties().tab(ResourceGeodes.MOD_TAB).stacksTo(1)));

    public static final RegistryObject<Item> CATALYST_4 = ITEMS.register("catalyst_4", () ->
            new CatalystItem(new Item.Properties().tab(ResourceGeodes.MOD_TAB).stacksTo(1)));


    public static final RegistryObject<Item> CATALYST_5 = ITEMS.register("catalyst_5", () ->
            new CatalystItem(new Item.Properties().tab(ResourceGeodes.MOD_TAB).stacksTo(1)));









    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }

}

package com.kingcast25.resourcegeodes.content.item;


import com.kingcast25.resourcegeodes.ResourceGeodes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ResourceGeodes.MOD_ID);










    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }

}

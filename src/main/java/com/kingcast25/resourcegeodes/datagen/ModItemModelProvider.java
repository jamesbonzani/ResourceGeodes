package com.kingcast25.resourcegeodes.datagen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import com.kingcast25.resourcegeodes.content.block.custom.BaseClusterBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryObject;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ResourceGeodes.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Collection<Item> items = ForgeRegistries.ITEMS.getValues();
        Collection<Item> modItems = new ArrayList<>();
        for (Item i : items){
            if (i.getRegistryName().getNamespace().equals("resourcegeodes")){
                modItems.add(i);
            }
        }
        for (Item entry : modItems) {
            if (entry instanceof BlockItem blockItem) {
                if (blockItem.getBlock() instanceof BaseBuddingBlock){
                    block(blockItem);
                } else if (blockItem.getBlock() instanceof BaseClusterBlock) {
                    block(blockItem);
                }
            }
        }
    }

    protected ItemModelBuilder block(BlockItem blockItem) {
        String fullName = blockItem.getBlock().getRegistryName().getPath();
        ResourceGeodes.logInfo(fullName);
        String[] parts = fullName.split("_");
        String blockName;
        switch (parts[0]){
            case "small":
            case "medium":
            case "large":
                return bud(blockItem, parts[0]);
            case "budding":
                blockName = "budding_block";
                break;
            default:
                return fullCluster(blockItem);
        }
        return withExistingParent(blockItem.getRegistryName().getPath(),modLoc("block/" +  blockName));
    }

    private ItemModelBuilder fullCluster(Item item){
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ResourceGeodes.MOD_ID, "block/full_cluster"));
    }

    private ItemModelBuilder bud(Item item, String typeName){
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ResourceGeodes.MOD_ID, "block/"+typeName+"_bud"));
    }






}


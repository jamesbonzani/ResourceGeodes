package com.kingcast25.resourcegeodes.datagen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Iterator;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, ResourceGeodes.MOD_ID, exFileHelper);
        ResourceGeodes.logInfo("Blockstate Provider Created");
    }

    @Override
    protected void registerStatesAndModels() {
        ResourceGeodes.logInfo("Registering states and models");
        Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
        while (geodeIt.hasNext()) {
            GeodeType currGeode = geodeIt.next();
            HashMap<String, RegistryObject<Block>> map = currGeode.getBLOCKS();

            simpleBlock(map.get("BUDDING").get(), models().getExistingFile(models().modLoc("budding_block")));
            directionalBlock(map.get("SMALL").get(), models().getExistingFile(models().modLoc("small_bud")));
            directionalBlock(map.get("MEDIUM").get(), models().getExistingFile(models().modLoc("medium_bud")));
            directionalBlock(map.get("LARGE").get(), models().getExistingFile(models().modLoc("large_bud")));
            directionalBlock(map.get("FULL").get(), models().getExistingFile(models().modLoc("full_cluster")));


        }
    }





}

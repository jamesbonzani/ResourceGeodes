package com.kingcast25.resourcegeodes.datagen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import com.kingcast25.resourcegeodes.content.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.locale.Language;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(DataGenerator gen, String locale) {
        super(gen, ResourceGeodes.MOD_ID, locale);
        ResourceGeodes.logInfo("Language Provider Created");
    }

    @Override
    protected void addTranslations() {

        Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
        while (geodeIt.hasNext()) {
            GeodeType currGeode = geodeIt.next();
            String capitalName = currGeode.name.substring(0,1).toUpperCase() + currGeode.name.substring(1);

            add(currGeode.SMALL.get(), "Small " + capitalName + " Bud");
            add(currGeode.MEDIUM.get(), "Medium " + capitalName + " Bud");
            add(currGeode.LARGE.get(), "Large " + capitalName + " Bud");
            add(currGeode.FULL.get(),  capitalName + " Cluster");
            add(currGeode.BUDDING.get(), "Budding " + capitalName);

            add("item"+ currGeode.SMALL.get().getDescriptionId().substring(5), "Small " + capitalName + " Bud");
            add("item"+ currGeode.MEDIUM.get().getDescriptionId().substring(5), "Medium " + capitalName + " Bud");
            add("item"+ currGeode.LARGE.get().getDescriptionId().substring(5), "Large " + capitalName + " Bud");
            add("item"+ currGeode.FULL.get().getDescriptionId().substring(5),  capitalName + " Cluster");
            add("item"+ currGeode.BUDDING.get().getDescriptionId().substring(5), "Budding " + capitalName);

        }
        //"item"+ .getDescriptionId().substring(5)

        add(ModBlocks.SENSOR.get(), "Crystal Sensor");

        add(ModItems.CATALYST_1.get(), "Tier 1 Growth Catalyst");
        add(ModItems.CATALYST_2.get(), "Tier 2 Growth Catalyst");
        add(ModItems.CATALYST_3.get(), "Tier 3 Growth Catalyst");
        add(ModItems.CATALYST_4.get(), "Tier 4 Growth Catalyst");
        add(ModItems.CATALYST_5.get(), "Tier 5 Growth Catalyst");

        add(ModItems.TIER_VIEWER.get(), "Tier Viewer");



        add("itemGroup.resource_geodes", "Resource Geodes");



    }



}

package com.kingcast25.resourcegeodes.datagen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
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
            HashMap<String, RegistryObject<Block>> map = currGeode.getBLOCKS();
            String capitalName = currGeode.name.substring(0,1).toUpperCase() + currGeode.name.substring(1);

            add(map.get("SMALL").get(), "Small " + capitalName + " Bud");
            add(map.get("MEDIUM").get(), "Medium " + capitalName + " Bud");
            add(map.get("LARGE").get(), "Large " + capitalName + " Bud");
            add(map.get("FULL").get(),  capitalName + " Cluster");
            add(map.get("BUDDING").get(), "Budding " + capitalName);

            add("item"+ map.get("SMALL").get().getDescriptionId().substring(5), "Small " + capitalName + " Bud");
            add("item"+ map.get("MEDIUM").get().getDescriptionId().substring(5), "Medium " + capitalName + " Bud");
            add("item"+ map.get("LARGE").get().getDescriptionId().substring(5), "Large " + capitalName + " Bud");
            add("item"+ map.get("FULL").get().getDescriptionId().substring(5),  capitalName + " Cluster");
            add("item"+ map.get("BUDDING").get().getDescriptionId().substring(5), "Budding " + capitalName);

        }
        //"item"+ .getDescriptionId().substring(5)


        add("itemGroup.resourcegeodes.resource_geodes", "Resource Geodes");



    }



}

package com.kingcast25.resourcegeodes.datagen;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Iterator;

public class ModTagProvider extends BlockTagsProvider {
    public ModTagProvider(DataGenerator p_126511_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_126511_, ResourceGeodes.MOD_ID, existingFileHelper);

    }


    @Override
    protected void addTags() {
       ResourceGeodes.logInfo("Adding Block Tags");
        Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
        while (geodeIt.hasNext()) {
            GeodeType currGeode = geodeIt.next();

            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(currGeode.SMALL.get(),currGeode.MEDIUM.get(),currGeode.LARGE.get(),currGeode.FULL.get(),currGeode.BUDDING.get());

            switch (currGeode.tier){
                case 1:
                    tag(BlockTags.NEEDS_STONE_TOOL).add(currGeode.SMALL.get(),currGeode.MEDIUM.get(),currGeode.LARGE.get(),currGeode.FULL.get(),currGeode.BUDDING.get());
                    break;
                case 2:
                    tag(BlockTags.NEEDS_IRON_TOOL).add(currGeode.SMALL.get(),currGeode.MEDIUM.get(),currGeode.LARGE.get(),currGeode.FULL.get(),currGeode.BUDDING.get());
                    break;
                case 3:
                    tag(BlockTags.NEEDS_DIAMOND_TOOL).add(currGeode.SMALL.get(),currGeode.MEDIUM.get(),currGeode.LARGE.get(),currGeode.FULL.get(),currGeode.BUDDING.get());
                    break;
            }


        }

        tag(BlockTags.NEEDS_STONE_TOOL).add(ModBlocks.SENSOR.get());
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.SENSOR.get());


    }




}

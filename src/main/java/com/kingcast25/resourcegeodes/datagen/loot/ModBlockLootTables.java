package com.kingcast25.resourcegeodes.datagen.loot;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.geode.GeodeType;
import com.sun.jna.platform.win32.OaIdl;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Iterator;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {

        ResourceGeodes.logInfo("Adding Block Loot Tables");


        Iterator<GeodeType> geodeIt = ModBlocks.geodes.values().iterator();
        while (geodeIt.hasNext()) {
            GeodeType currGeode = geodeIt.next();
            ResourceGeodes.logInfo("Adding Loot Tables for "+ currGeode.name + " Geode");
            this.add(currGeode.BUDDING.get(), noDrop());
            this.dropWhenSilkTouch(currGeode.SMALL.get());
            this.dropWhenSilkTouch(currGeode.MEDIUM.get());
            this.dropWhenSilkTouch(currGeode.LARGE.get());
            this.dropWhenSilkTouch(currGeode.FULL.get());
            this.add(currGeode.FULL.get(), (block) -> createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(currGeode.clusterDrop))
                    .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 4-currGeode.tier))));

        }

        this.dropSelf(ModBlocks.SENSOR.get());



    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


    /*{
        return createSilkTouchDispatchTable(block, LootItem.lootTableItem(currGeode.clusterDrop)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F-currGeode.tier)))
                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE)).when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                        .of(ItemTags.CLUSTER_MAX_HARVESTABLES))).otherwise(applyExplosionDecay(block, LootItem.lootTableItem(currGeode.clusterDrop)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F-currGeode.tier))))));
    }*/

}

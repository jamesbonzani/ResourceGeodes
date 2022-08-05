package com.kingcast25.resourcegeodes.content.geode;

import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import com.kingcast25.resourcegeodes.content.block.custom.BaseClusterBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GeodeType {

    public String name;
    public int color;

    public Item clusterDrop;

    public List<RegistryObject<Block>> clusters;


    public HashMap<String,RegistryObject<Block>> BLOCKS;

    public GeodeType(String name, int color, Item clusterDrop) {
        this.name = name;
        this.color = color;
        this.clusterDrop = clusterDrop;
        this.clusters = new ArrayList<RegistryObject<Block>>();
        this.BLOCKS = new HashMap<String, RegistryObject<Block>>();

        this.registerBlocks(name);

    }



    public void registerBlocks(String name){
        BLOCKS.put("SMALL",ModBlocks.BLOCKS.register("small_"+name+"_bud", () -> new BaseClusterBlock(3,4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD), this.color,1)));
        BLOCKS.put("MEDIUM",ModBlocks.BLOCKS.register("medium_"+name+"_bud", () -> new BaseClusterBlock(4,3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD), this.color,2)));
        BLOCKS.put("LARGE",ModBlocks.BLOCKS.register("large_"+name+"_bud", () -> new BaseClusterBlock(5,3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD), this.color,3)));
        BLOCKS.put("FULL",ModBlocks.BLOCKS.register(name+"_cluster", () -> new BaseClusterBlock(7,3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER), this.color,4)));
        BLOCKS.put("BUDDING",ModBlocks.BLOCKS.register("budding_"+name, () -> new BaseBuddingBlock(BlockBehaviour.Properties.copy(Blocks.BUDDING_AMETHYST),this.color)));

        clusters.add(BLOCKS.get("SMALL"));
        clusters.add(BLOCKS.get("MEDIUM"));
        clusters.add(BLOCKS.get("LARGE"));
        clusters.add(BLOCKS.get("FULL"));

    }


    public HashMap<String,RegistryObject<Block>> getBLOCKS(){
        return this.BLOCKS;
    }


    public int getColor(){
        return this.color;
    }

    public Item getClusterDrop(){
        return this.clusterDrop;
    }




}

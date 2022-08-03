package com.kingcast25.resourcegeodes.content.geode;

import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import com.kingcast25.resourcegeodes.content.block.custom.BaseClusterBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;

public class GeodeType {

    public String name;
    public static int color;

    public static Item clusterDrop;


    public static HashMap<String,RegistryObject<Block>> BLOCKS = new HashMap<String, RegistryObject<Block>>();

    public GeodeType(String name, int color, Item clusterDrop) {
        this.name = name;
        this.color = color;
        this.clusterDrop = clusterDrop;

        this.registerBlocks(name);

    }



    public void registerBlocks(String name){
        BLOCKS.put("SMALL",ModBlocks.BLOCKS.register("small_"+name+"_bud", () -> new BaseClusterBlock(3,4, BlockBehaviour.Properties.copy(Blocks.SMALL_AMETHYST_BUD), this.color,1)));
        BLOCKS.put("MEDIUM",ModBlocks.BLOCKS.register("medium_"+name+"_bud", () -> new BaseClusterBlock(4,3, BlockBehaviour.Properties.copy(Blocks.MEDIUM_AMETHYST_BUD), this.color,2)));
        BLOCKS.put("LARGE",ModBlocks.BLOCKS.register("large_"+name+"_bud", () -> new BaseClusterBlock(5,3, BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD), this.color,3)));
        BLOCKS.put("FULL",ModBlocks.BLOCKS.register(name+"_cluster", () -> new BaseClusterBlock(7,3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER), this.color,4)));
        BLOCKS.put("BUDDING",ModBlocks.BLOCKS.register("budding_"+name, () -> new BaseBuddingBlock(BlockBehaviour.Properties.copy(Blocks.BUDDING_AMETHYST),
                new Block[]{BLOCKS.get("SMALL").get(),BLOCKS.get("MEDIUM").get(),BLOCKS.get("LARGE").get(),BLOCKS.get("FULL").get()}, this.color)));


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

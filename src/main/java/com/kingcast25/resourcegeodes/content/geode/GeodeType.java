package com.kingcast25.resourcegeodes.content.geode;

import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import com.kingcast25.resourcegeodes.content.block.custom.BaseClusterBlock;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GeodeType {

    public String name;
    public int color;

    public Item clusterDrop;

    public List<RegistryObject<BaseClusterBlock>> clusters = new ArrayList<RegistryObject<BaseClusterBlock>>();

    public int tier;

    public RegistryObject<BaseClusterBlock> SMALL;
    public RegistryObject<BaseClusterBlock> MEDIUM;
    public RegistryObject<BaseClusterBlock> LARGE;
    public RegistryObject<BaseClusterBlock> FULL;
    public RegistryObject<BaseBuddingBlock> BUDDING;




    public GeodeType(String name, int color, int tier, Item clusterDrop) {
        this.name = name;
        this.color = color;
        this.clusterDrop = clusterDrop;


        this.tier = tier;

        this.registerBlocks(name);

    }

    private void registerBlocks(String name) {

        SMALL = ModBlocks.BLOCKS.register("small_"+name+"_bud", () -> new BaseClusterBlock(3,4, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER), 0));
        MEDIUM = ModBlocks.BLOCKS.register("medium_"+name+"_bud", () -> new BaseClusterBlock(3,4, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER), 1));
        LARGE = ModBlocks.BLOCKS.register("large_"+name+"_bud", () -> new BaseClusterBlock(3,4, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER), 2));
        FULL = ModBlocks.BLOCKS.register("full_"+name+"_cluster", () -> new BaseClusterBlock(3,4, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER), 3));

        BUDDING = ModBlocks.BLOCKS.register("budding_"+name, () -> new BaseBuddingBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)));


        clusters.add(SMALL);
        clusters.add(MEDIUM);
        clusters.add(LARGE);
        clusters.add(FULL);

    }


    /*  public void registerBlocksOld(String name, Registrate reg){
      SMALL = reg.object("small_"+name+"_bud").block((BlockBehaviour.Properties properties) -> new BaseClusterBlock(3, 4, properties,0 ))
                .properties(p -> p.copy(Blocks.AMETHYST_CLUSTER).lightLevel((level) -> 1))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate((ctx, prov) -> prov.directionalBlock(ctx.getEntry(),prov.models().getExistingFile(prov.models().modLoc("small_bud"))))
                .color(() -> () -> (pos, state, stack, index) -> this.color)
                .lang("Small "+capitalize(name)+ " Bud")
                .loot((tb, e) -> tb.dropWhenSilkTouch(e))
                .item()
                    .model((ctx, prov) -> prov.withExistingParent(ctx.get().getRegistryName().getPath(),
                        new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(ResourceGeodes.MOD_ID, "block/small_bud")))
                    .color(() -> () -> (pos, stack) -> this.color)
                    .lang("Small "+capitalize(name)+ " Bud")
                .build()


        .register();

        MEDIUM = reg.object("medium_"+name+"_bud").block((BlockBehaviour.Properties properties) -> new BaseClusterBlock(4, 3, properties, 1))
                .properties(p -> p.copy(Blocks.AMETHYST_CLUSTER).lightLevel((level) -> 2))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate((ctx, prov) -> prov.directionalBlock(ctx.getEntry(),
                        prov.models().getExistingFile(prov.models().modLoc("medium_bud"))))
                .color(() -> () -> (pos, state, stack, index) -> this.color)
                .lang("Medium "+capitalize(name)+ " Bud")
                .loot((tb, e) -> tb.dropWhenSilkTouch(e))
                .item()
                    .model((ctx, prov) -> prov.withExistingParent(ctx.get().getRegistryName().getPath(),
                            new ResourceLocation("item/generated")).texture("layer0",
                            new ResourceLocation(ResourceGeodes.MOD_ID, "block/medium_bud")))
                    .color(() -> () -> (pos, stack) -> this.color)
                    .lang("Medium "+capitalize(name)+ " Bud")
                    .build()
                .register();

        LARGE = reg.object("large_"+name+"_bud").block((BlockBehaviour.Properties properties) -> new BaseClusterBlock(5, 3, properties, 2))
                .properties(p -> p.copy(Blocks.AMETHYST_CLUSTER).lightLevel((level) -> 4))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate((ctx, prov) -> prov.directionalBlock(ctx.getEntry(),
                        prov.models().getExistingFile(prov.models().modLoc("large_bud"))))
                .color(() -> () -> (pos, state, stack, index) -> this.color)
                .lang("Full "+capitalize(name)+ " Cluster")
                .loot((tb, e) -> tb.dropWhenSilkTouch(e))
                .item()
                    .model((ctx, prov) -> prov.withExistingParent(ctx.get().getRegistryName().getPath(),
                        new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(ResourceGeodes.MOD_ID, "block/large_bud")))
                    .color(() -> () -> (pos, stack) -> this.color)
                    .lang("Large "+capitalize(name)+ " Bud")
                    .build()
                .register();

        FULL = reg.object("full_"+name+"_cluster").block((BlockBehaviour.Properties properties) -> new BaseClusterBlock(5, 3, properties, 3))
                .properties(p -> p.copy(Blocks.AMETHYST_CLUSTER).lightLevel((level) -> 5))
                .addLayer(() -> RenderType::cutoutMipped)
                .blockstate((ctx, prov) -> prov.directionalBlock(ctx.getEntry(),
                        prov.models().getExistingFile(prov.models().modLoc("full_cluster"))))
                .color(() -> () -> (pos, state, stack, index) -> this.color)
                .lang("Full "+capitalize(name)+ " Cluster")
                .loot((tb, e) -> tb.add(e, LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(clusterDrop))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1,4-tier)))
                                .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0,4-tier))))
                        .withPool(LootPool.lootPool()
                                .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                        .hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1)))))
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(clusterDrop)))))
                .item()
                    .model((ctx, prov) -> prov.withExistingParent(ctx.get().getRegistryName().getPath(),
                        new ResourceLocation("item/generated")).texture("layer0",
                        new ResourceLocation(ResourceGeodes.MOD_ID, "block/full_cluster")))
                    .color(() -> () -> (pos, stack) -> this.color)
                    .lang("Full "+capitalize(name)+ " Cluster")
                    .build()
                .register();

        BUDDING = reg.object("budding_"+name).block(BaseBuddingBlock::new).properties(p -> p.copy(Blocks.BUDDING_AMETHYST))
                .color(() -> () -> (pos, state, stack, index) -> this.color)
                .blockstate((ctx, prov) -> prov.simpleBlock(ctx.getEntry(),
                        prov.models().getExistingFile(prov.models().modLoc("budding_block"))))
                .lang("Budding "+capitalize(name))
                .blockEntity((type, pos, state) -> new BuddingBlockEntity(pos, state))
                .build()
                .item()
                    .color(() -> () -> (pos, stack) -> this.color)
                    .lang("Budding "+capitalize(name))
                .build()

                .register();




        clusters = new BlockEntry[]{SMALL, MEDIUM, LARGE, FULL};

}
       */


    public static String capitalize(String s){
       return s.substring(0,1).toUpperCase(Locale.ROOT)+s.substring(1);
    }



    public int getColor(){
        return this.color;
    }






}

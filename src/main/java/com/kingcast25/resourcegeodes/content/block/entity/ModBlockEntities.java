package com.kingcast25.resourcegeodes.content.block.entity;

import com.kingcast25.resourcegeodes.ResourceGeodes;
import com.kingcast25.resourcegeodes.content.block.ModBlocks;
import com.kingcast25.resourcegeodes.content.block.custom.BaseBuddingBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ResourceGeodes.MOD_ID);



    public static final RegistryObject<BlockEntityType<BuddingBlockEntity>> BUDDING_BLOCK_ENTITY = BLOCK_ENTITIES.register("budding_block_entity",
            () -> BlockEntityType.Builder.of(BuddingBlockEntity::new,
                    ModBlocks.geodes.get("iron").BUDDING.get(),
                    ModBlocks.geodes.get("copper").BUDDING.get(),
                    ModBlocks.geodes.get("coal").BUDDING.get(),
                    ModBlocks.geodes.get("gold").BUDDING.get(),
                    ModBlocks.geodes.get("redstone").BUDDING.get(),
                    ModBlocks.geodes.get("lapis").BUDDING.get(),
                    ModBlocks.geodes.get("diamond").BUDDING.get(),
                    ModBlocks.geodes.get("emerald").BUDDING.get(),
                    ModBlocks.geodes.get("zinc") != null ? ModBlocks.geodes.get("zinc").BUDDING.get() : ModBlocks.EMPTY.get()
            ).build(null));






    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

package com.algorithmlx.algotech.setup;

import com.algorithmlx.algotech.api.util.Constant;
import com.algorithmlx.algotech.block.generators.CoalGeneratorMK1;
import com.algorithmlx.algotech.block.StorageBlocks;
import com.algorithmlx.algotech.container.CoalGeneratorContainerMK1;
import com.algorithmlx.algotech.item.IngotBase;
import com.algorithmlx.algotech.tile.CoalGeneratorMK1Tile;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constant.ModId);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constant.ModId);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Constant.ModId);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Constant.ModId);
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Constant.ModId);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<StorageBlocks> BRONZE_BLOCK = BLOCKS.register("bronze_block", StorageBlocks::new);
    public static final RegistryObject<CoalGeneratorMK1> COAL_GENERATOR = BLOCKS.register("coal_generator", CoalGeneratorMK1::new);

    public static final RegistryObject<IngotBase> BRONZE_INGOT = ITEMS.register("bronze_ingot", IngotBase::new);

    public static final RegistryObject<TileEntityType<CoalGeneratorMK1Tile>> COAL_GENERATOR_TILE = TILES.register("coal_generator",
            ()-> TileEntityType.Builder.of(CoalGeneratorMK1Tile::new, COAL_GENERATOR.get()).build(null));

    public static final RegistryObject<ContainerType<CoalGeneratorContainerMK1>> COAL_GENERATOR_CONTAINER = CONTAINERS.register("coal_generator",
            ()-> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World level = inv.player.getCommandSenderWorld();
                return new CoalGeneratorContainerMK1(windowId, level, pos, inv, inv.player);
            })));
//    public static final RegistryObject<ContainerType<EnergyFurnaceContainer>> ENERGY_FURNACE_CONTAINER = CONTAINERS.register("energy_furnace",
//            ()-> IForgeContainerType.create((((windowId, inv, data) -> {
//                BlockPos pos = data.readBlockPos();
//                World level = inv.player.getCommandSenderWorld();
//                return new EnergyFurnaceContainer(windowId, level, pos, inv, inv.player);
//            }))));
}

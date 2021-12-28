package com.algorithmlx.algotech.setup;

import com.algorithmlx.algotech.AlgoTech;
import com.algorithmlx.algotech.block.generators.CoalGenerator;
import com.algorithmlx.algotech.block.StorageBlocks;
import com.algorithmlx.algotech.container.CoalGeneratorContainer;
import com.algorithmlx.algotech.container.EnergyFurnaceContainer;
import com.algorithmlx.algotech.item.IngotBase;
import com.algorithmlx.algotech.tile.CoalGeneratorTile;
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
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AlgoTech.ModId);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AlgoTech.ModId);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, AlgoTech.ModId);
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, AlgoTech.ModId);
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, AlgoTech.ModId);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FLUIDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    public static final RegistryObject<StorageBlocks> BRONZE_BLOCK = BLOCKS.register("bronze_block", StorageBlocks::new);
    public static final RegistryObject<CoalGenerator> COAL_GENERATOR = BLOCKS.register("coal_generator", CoalGenerator::new);

    public static final RegistryObject<IngotBase> BRONZE_INGOT = ITEMS.register("bronze_ingot", IngotBase::new);

    public static final RegistryObject<TileEntityType<CoalGeneratorTile>> COAL_GENERATOR_TILE = TILES.register("coal_generator",
            ()-> TileEntityType.Builder.of(CoalGeneratorTile::new, COAL_GENERATOR.get()).build(null));

    public static final RegistryObject<ContainerType<CoalGeneratorContainer>> COAL_GENERATOR_CONTAINER = CONTAINERS.register("coal_generator",
            ()-> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World level = inv.player.getCommandSenderWorld();
                return new CoalGeneratorContainer(windowId, level, pos, inv, inv.player);
            })));
    public static final RegistryObject<ContainerType<EnergyFurnaceContainer>> ENERGY_FURNACE_CONTAINER = CONTAINERS.register("energy_furnace",
            ()-> IForgeContainerType.create((((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World level = inv.player.getCommandSenderWorld();
                return new EnergyFurnaceContainer(windowId, level, pos, inv, inv.player);
            }))));
}

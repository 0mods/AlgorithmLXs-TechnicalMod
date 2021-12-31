package com.algorithmlx.algotech.world.gen;

import com.algorithmlx.algotech.AlgoTech;
import com.algorithmlx.algotech.api.util.Constant;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.Objects;

@Mod.EventBusSubscriber
public class OreGen {
    private static final ArrayList<ConfiguredFeature<?, ?>> overOres = new ArrayList<>();
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, Constant.ModId + ":" + name, configuredFeature);
    }
    public static void registerOres() {

    }
    public static ConfiguredFeature<?, ?> genOres(Block block, int minHeight, int maxHeight, int veinSize, int amountOfVeinInChunk) {
        AlgoTech.LOGGER.info("Registered nether ore: " + Objects.requireNonNull(block.getRegistryName()).getPath());
        return register(Objects.requireNonNull(block.getRegistryName()).getPath(),
                Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                block.defaultBlockState(), veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().count(amountOfVeinInChunk));
    }
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void generateOres(BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        for (ConfiguredFeature<?, ?> ore : overOres) {
            if (ore != null) generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
        }
    }
}

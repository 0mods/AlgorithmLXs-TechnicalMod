package com.algorithmlx.algotech.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Config {
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static ForgeConfigSpec.IntValue COAL_GENERATOR_MAX_POWER;
    public static ForgeConfigSpec.IntValue COAL_GENERATOR_GENERATE;
    public static ForgeConfigSpec.IntValue COAL_GENERATOR_SEND;

    static {
        ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("General Settings").push("general");
        CLIENT_BUILDER.pop();

        SERVER_BUILDER.comment("Power category").push("power");
        coalGenBlock(SERVER_BUILDER, CLIENT_BUILDER);
        SERVER_BUILDER.pop();

        SERVER_CONFIG = SERVER_BUILDER.build();
        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }

    private static void coalGenBlock(ForgeConfigSpec.Builder SERVER, ForgeConfigSpec.Builder CLIENT) {
        SERVER.comment("Coal Generator Category").push("coalGenerator");

        COAL_GENERATOR_MAX_POWER = SERVER.defineInRange("maxPower", 2000, 1000, 16000);
        COAL_GENERATOR_GENERATE = SERVER.defineInRange("generation", 10, 1, 20);
        COAL_GENERATOR_SEND = SERVER.defineInRange("send", 5, 1, 20);

        SERVER.pop();
    }

    @SubscribeEvent
    public static void onLoad(final ModConfig.Loading configEvent) {

    }

    @SubscribeEvent
    public static void onReload(final ModConfig.Reloading configEvent) {
    }

}

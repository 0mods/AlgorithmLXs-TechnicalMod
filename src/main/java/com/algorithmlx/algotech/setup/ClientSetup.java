package com.algorithmlx.algotech.setup;

import com.algorithmlx.algotech.api.util.Constant;
import com.algorithmlx.algotech.client.CoalGeneratorScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Constant.ModId, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        ScreenManager.register(Registration.COAL_GENERATOR_CONTAINER.get(), CoalGeneratorScreen::new);
    }
}

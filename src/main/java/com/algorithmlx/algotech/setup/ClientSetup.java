package com.algorithmlx.algotech.setup;

import com.algorithmlx.algotech.AlgoTech;
import com.algorithmlx.algotech.client.CoalGeneratorScreen;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = AlgoTech.ModId, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public static void init(final FMLClientSetupEvent event) {
        ScreenManager.register(Registration.COAL_GENERATOR_CONTAINER.get(), CoalGeneratorScreen::new);
        event.enqueueWork(() -> {

        });
    }
    @SubscribeEvent
    public static void onItemColor(ColorHandlerEvent.Item event) {

    }

    @SubscribeEvent
    public static void onModelRegistryEvent(ModelRegistryEvent event) {

    }

    @SubscribeEvent
    public static void onTextureStitch(TextureStitchEvent.Pre event) {
        if (!event.getMap().location().equals(AtlasTexture.LOCATION_BLOCKS)) {
            return;
        }

    }

    @SubscribeEvent
    public void onTooltipPre(RenderTooltipEvent.Pre event) {
        Item item = event.getStack().getItem();
        if (item.getRegistryName().getNamespace().equals(AlgoTech.ModId)) {
            event.setMaxWidth(200);
        }
    }
}

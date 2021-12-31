package com.algorithmlx.algotech;

import com.algorithmlx.algotech.api.util.Constant;
import com.algorithmlx.algotech.setup.ClientSetup;
import com.algorithmlx.algotech.setup.Config;
import com.algorithmlx.algotech.setup.ModSetup;
import com.algorithmlx.algotech.setup.Registration;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Constant.ModId)
@Mod.EventBusSubscriber(modid = Constant.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlgoTech {
    public static final Logger LOGGER = LogManager.getLogger();

    ModLoadingContext modContext = ModLoadingContext.get();
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    public AlgoTech() {
        modContext.registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_CONFIG);
        modContext.registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);
        Registration.init();
        bus.addListener(ModSetup::init);
        bus.addListener(ClientSetup::init);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry()
                    .register(new BlockItem(block, new Item.Properties().tab(ModSetup.TAB))
                            .setRegistryName(block.getRegistryName()));
        });
    }
}

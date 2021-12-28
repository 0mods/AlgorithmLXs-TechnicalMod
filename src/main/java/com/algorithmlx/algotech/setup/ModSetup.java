package com.algorithmlx.algotech.setup;

import com.algorithmlx.algotech.AlgoTech;
import com.algorithmlx.algotech.world.EndOreGen;
import com.algorithmlx.algotech.world.NetherOreGen;
import com.algorithmlx.algotech.world.OreGen;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = AlgoTech.ModId, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static final ItemGroup TAB = new ItemGroup(AlgoTech.ModId + ".algotechGroup") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.BRONZE_BLOCK.get());
        }

        @Override
        public boolean hasSearchBar() {
            return true;
        }

        @Override
        public ItemGroup setBackgroundImage(ResourceLocation texture) {
            return super.setBackgroundImage(new ResourceLocation(AlgoTech.ModId, "textures/gui/creative_gui.png"));
        }
    };
    public static void init(final FMLCommonSetupEvent event) {
        NetherOreGen.registerOres();
        EndOreGen.registerOres();
        OreGen.registerOres();
    }
    @SubscribeEvent
    public static void serverSetup(final RegisterCommandsEvent event) {

    }
}

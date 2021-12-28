package com.algorithmlx.algotech.mixin.client;

import com.algorithmlx.algotech.api.interfaces.IArmorRender;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(value = BipedArmorLayer.class, remap = false)
public class ArmorRenderMixin {
    @Final
    @Shadow
    private static Map<String, ResourceLocation> ARMOR_LOCATION_CACHE;

    @Inject(method = "getArmorLocation", at = @At("HEAD"), cancellable = true)
    private void getArmorLocationInject(ArmorItem p_241737_1_, boolean p_241737_2_, String p_241737_3_, CallbackInfoReturnable<ResourceLocation> cir) {
        if(p_241737_1_.getMaterial() instanceof IArmorRender) {
            cir.setReturnValue(ARMOR_LOCATION_CACHE.computeIfAbsent(
                    ((IArmorRender) p_241737_1_.getMaterial()).getModId() + ":textures/armor/"
                            + (p_241737_1_.getMaterial()).getName() + "/"
                            + (p_241737_2_ ? 2:1) + (p_241737_3_ == null ? "" : p_241737_3_)
                            + ".png", ResourceLocation::new));
        }
    }
}

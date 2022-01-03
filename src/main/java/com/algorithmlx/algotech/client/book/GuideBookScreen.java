package com.algorithmlx.algotech.client.book;

import api.algotech.util.Constant;
import api.algotech.util.GuiMaker;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GuideBookScreen extends Screen {
    private final GuiMaker maker = new GuiMaker("guide_book");
    private final ResourceLocation texture = maker.location;

    private int imageWidth  = 352; //x
    private int imageHeight = 322; //y

    public GuideBookScreen(String name) {
        super(new TranslationTextComponent("screen." + Constant.ModId + "." + name));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        Minecraft.getInstance().getTextureManager().bind(texture);
        blit(matrixStack, imageWidth / 2, imageHeight / 2, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void init() {

    }
}

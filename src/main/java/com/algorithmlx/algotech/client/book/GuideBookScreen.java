package com.algorithmlx.algotech.client.book;

import com.algorithmlx.algotech.api.util.Constant;
import com.algorithmlx.algotech.api.util.GuiMaker;
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

    private int imageWidth  = 176; //x
    private int imageHeight = 166; //y

    public GuideBookScreen(String name) {
        super(new TranslationTextComponent("screen." + Constant.ModId + "." + name));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        renderBackground(matrixStack);
    }

    @Override
    protected void init() {
        Minecraft.getInstance().getTextureManager().bind(texture);
    }
}

package com.algorithmlx.algotech.api.util;

import com.algorithmlx.algotech.api.interfaces.IComponent;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.StringTextComponent;

import java.awt.*;

public class EnergeticGui implements IComponent {
    public final IIntArray array;

    public EnergeticGui(IIntArray array) {
        this.array = array;
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta, int w, int h) {
        int lastEnergy = array.get(1);
        int maxEnergy = array.get(2);

        IRenderTypeBuffer.Impl immediate = IRenderTypeBuffer.immediate(Tessellator.getInstance().getBuilder());
/*26. Error with drawInBatch*/ // Minecraft.getInstance().font.drawInBatch(new StringTextComponent((lastEnergy / 1000f) + "/" + (maxEnergy / 1000f) + "FE").getVisualOrderText(), w, h, Color.BLACK.getRGB(), ColorUtils.calcColorWithEnergy(lastEnergy, maxEnergy), matrices.last().normal(), immediate);
        Minecraft.getInstance().font.drawInBatch(new StringTextComponent((lastEnergy / 1000f) + "/" + (maxEnergy / 1000f) + "FE").getVisualOrderText(), w, h, Color.BLACK.getRGB(), false, matrices.last().pose(), immediate, false, ColorUtils.calcColorWithEnergy(lastEnergy, maxEnergy), 0);
        immediate.endBatch();
    }
}

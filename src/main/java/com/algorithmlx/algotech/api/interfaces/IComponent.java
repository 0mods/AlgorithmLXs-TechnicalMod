package com.algorithmlx.algotech.api.interfaces;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.IRenderable;

public interface IComponent extends IRenderable {
    @Override
    default void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {

    }

    default void render(MatrixStack matrices, int mouseX, int mouseY, float delta, int w, int h) {
        this.render(matrices, mouseX, mouseY, delta);
    }
}

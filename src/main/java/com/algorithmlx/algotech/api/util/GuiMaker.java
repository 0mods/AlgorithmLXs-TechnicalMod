package com.algorithmlx.algotech.api.util;

import net.minecraft.util.ResourceLocation;

public class GuiMaker {
    public String name;
    public ResourceLocation location;
    public String texture;

    public GuiMaker(String name) {
        this.name = name;
        this.texture = "textures/gui/" + name + "_gui.png";
        this.location = new ResourceLocation(Constant.ModId, texture);
    }
}

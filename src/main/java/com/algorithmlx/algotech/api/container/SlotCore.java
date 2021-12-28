package com.algorithmlx.algotech.api.container;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SlotCore extends SlotItemHandler {
    public final String slotTitle;

    public SlotCore(IItemHandler itemHandler, int index, int xPosition, int yPosition, String slotTitle) {
        super(itemHandler, index, xPosition, yPosition);
        this.slotTitle = slotTitle;
    }

    public String getTitle() {
        return this.slotTitle;
    }
}

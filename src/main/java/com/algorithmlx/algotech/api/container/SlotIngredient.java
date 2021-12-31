package com.algorithmlx.algotech.api.container;

import com.algorithmlx.algotech.api.util.Constant;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

public class SlotIngredient extends SlotCore {
    private final IItemHandler itemHandler;

    private final int index;

    protected final World world;

    public SlotIngredient(IItemHandler itemHandler, int index, int xPosition, int yPosition, World world) {
        super(itemHandler, index, xPosition, yPosition, "slot." + Constant.ModId + ".ingredient");
        this.itemHandler = itemHandler;
        this.index = index;
        this.world = world;
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        if (stack.isEmpty() || !canSmelt(stack))
            return false;
        return this.itemHandler.isItemValid(this.index, stack);
    }

    protected boolean canSmelt(ItemStack stack) {
        return this.world.getRecipeManager().getRecipeFor(IRecipeType.SMELTING, new Inventory(stack), this.world).isPresent();
    }
}

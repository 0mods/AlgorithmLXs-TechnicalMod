package api.algotech.container;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;

public class SlotOutput extends SlotCore {
    public SlotOutput(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition, null);
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return false;
    }
}

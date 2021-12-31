package com.algorithmlx.algotech.item;

import com.algorithmlx.algotech.client.book.GuideBookScreen;
import com.algorithmlx.algotech.setup.ModSetup;
import com.algorithmlx.algotech.setup.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class GuideBook extends Item {
    public GuideBook() {
        super(new Item.Properties().tab(ModSetup.TAB));
    }

    @Override
    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack stack = p_77659_2_.getItemInHand(p_77659_3_);
        if (!p_77659_1_.isClientSide()) {
            Minecraft.getInstance().setScreen(new GuideBookScreen("guide_book"));
            return ActionResult.success(stack);
        }
        return super.use(p_77659_1_, p_77659_2_, p_77659_3_);
    }
}

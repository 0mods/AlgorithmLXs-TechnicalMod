package com.algorithmlx.algotech.api.enums;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum BasicItemTier implements IItemTier {
    BRONZE_TIER(3, 500, 6, 100, 2, Ingredient.EMPTY);
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float damage;
    private final int enchant;
    private final Ingredient ingredient;

    BasicItemTier(int harvestLevelIn, int maxUsesIn, int efficiencyIn, float damageIn, int enchantIn, Ingredient ingredientIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.damage = damageIn;
        this.enchant = enchantIn;
        this.ingredient = ingredientIn;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchant;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient;
    }
}

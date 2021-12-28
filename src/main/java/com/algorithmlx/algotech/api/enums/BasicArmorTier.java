package com.algorithmlx.algotech.api.enums;

import com.algorithmlx.algotech.AlgoTech;
import com.algorithmlx.algotech.api.interfaces.IArmorRender;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;

public enum BasicArmorTier implements IArmorRender {
    ;

    private static final int[] armorDurabilityBase = new int[]{1, 1, 1, 1};
    private final String name;
    private final int maxDurabilityDamage;
    private final int[] defense;
    private final int enchant;
    private final float toughness;
    private final float kbResistance;
    private final SoundEvent sound;
    private final Ingredient ingredient;

    BasicArmorTier(String name, int maxDurabilityDamage, int[] defense, int enchant, float toughness, float kbResistance, SoundEvent sound, Ingredient ingredient) {
        this.name = name;
        this.maxDurabilityDamage = maxDurabilityDamage;
        this.defense = defense;
        this.enchant = enchant;
        this.toughness = toughness;
        this.kbResistance = kbResistance;
        this.sound = sound;
        this.ingredient = ingredient;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return armorDurabilityBase[p_200896_1_.getIndex()] * this.maxDurabilityDamage;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return this.defense[p_200902_1_.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchant;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.kbResistance;
    }

    @Override
    public String getModId() {
        return AlgoTech.ModId;
    }
}

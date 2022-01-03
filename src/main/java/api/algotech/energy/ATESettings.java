package api.algotech.energy;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

public class ATESettings extends AlgoTechEnergyStorage implements INBTSerializable<CompoundNBT> {
    public ATESettings(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    protected void onEnergyChanged() {

    }

    public void setEnergy(int energy) {
        this.energy = energy;
        onEnergyChanged();
    }

    public void addEnergy(int energy) {
        this.energy += energy;
        if (this.energy > getMaxStored()) {
            this.energy = getStored();
        }
        onEnergyChanged();
    }

    public void consumeEnergy(int energy) {
        this.energy -= energy;
        if (this.energy < 0) {
            this.energy = 0;
        }
        onEnergyChanged();
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("ate", getStored());
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        setEnergy(nbt.getInt("ate"));
    }
}

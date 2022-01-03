package api.algotech.energy;

public interface IAlgoTechEnergyStorage {
    int receiveEnergy(int maxReceive, boolean simulate);

    int injectEnergy(int maxExtract, boolean simulate);

    int getStored();

    int getMaxStored();

    boolean canInject();

    boolean canReceive();
}


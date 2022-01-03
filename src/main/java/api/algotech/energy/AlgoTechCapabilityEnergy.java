package api.algotech.energy;

import net.minecraft.nbt.INBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class AlgoTechCapabilityEnergy {
    @CapabilityInject(IAlgoTechEnergyStorage.class)
    public static Capability<IAlgoTechEnergyStorage> ENERGY = null;

    public static void init() {
        CapabilityManager.INSTANCE.register(IAlgoTechEnergyStorage.class, new Capability.IStorage<IAlgoTechEnergyStorage>()
                {
                    @Override
                    public INBT writeNBT(Capability<IAlgoTechEnergyStorage> capability, IAlgoTechEnergyStorage instance, Direction side)
                    {
                        return IntNBT.valueOf(instance.getStored());
                    }

                    @Override
                    public void readNBT(Capability<IAlgoTechEnergyStorage> capability, IAlgoTechEnergyStorage instance, Direction side, INBT nbt)
                    {
                        if (!(instance instanceof AlgoTechEnergyStorage))
                            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
                        ((AlgoTechEnergyStorage)instance).energy = ((IntNBT)nbt).getAsInt();
                    }
                },
                () -> new AlgoTechEnergyStorage(1000));
    }
}


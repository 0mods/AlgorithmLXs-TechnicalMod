package com.algorithmlx.algotech.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StorageBlocks extends Block {
    public StorageBlocks() {
        super(Properties.of(Material.STONE).strength(3, 3).requiresCorrectToolForDrops().harvestLevel(1));
    }
}

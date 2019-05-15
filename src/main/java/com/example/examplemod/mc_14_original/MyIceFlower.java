package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.BlockFlower;
import net.minecraft.creativetab.CreativeTabs;

public class MyIceFlower extends BlockFlower {

    public BlockFlower.EnumFlowerColor getBlockType() {
        return EnumFlowerColor.RED;
    }

    public MyIceFlower() {
        super();
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("myiceflower");
        setHardness(3000);
        setUnlocalizedName(ExampleMod.MODID + "_myiceflower");
    }

}

package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MyIceBlock extends Block {
    public MyIceBlock() {
        super(Material.ICE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("myiceblock");
        setUnlocalizedName(ExampleMod.MODID + "_myiceblock");
    }
}

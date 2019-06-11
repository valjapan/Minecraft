package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ExplosionResistanceLightBlock extends Block {
    public ExplosionResistanceLightBlock() {
        super(Material.ROCK);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("explosion_resistance_light");
        setUnlocalizedName(ExampleMod.MODID + "_explosion_resistance_light");
        setResistance(2000F);
        setHardness(2);
        setLightLevel(2.0F);
        //そのブロックから放つ光の明るさを設定する
        setTickRandomly(false);
    }
}

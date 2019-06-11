package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ExplosionResistanceGlassBlock extends BlockGlass {
    public ExplosionResistanceGlassBlock() {
        super(Material.GLASS, false);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("explosion_resistance_glass");
        setUnlocalizedName(ExampleMod.MODID + "_explosion_resistance_glass");
        setResistance(2000F); //爆発耐性
        setHardness(2); //硬さ
        setTickRandomly(false);
        //updateTickがランダムに呼ばれるかを設定する
        //updateTickは燃える判定も入るのでそれを防ぐことができる = 燃えない！！
    }
}

package com.example.examplemod.mc_03_myitem;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemOnigiri extends ItemFood {
    public ItemOnigiri() {
        super(1, 0.5f, false);
        setCreativeTab(CreativeTabs.FOOD);
        setRegistryName("onigiri");
        setUnlocalizedName(ExampleMod.MODID + "_onigiri");
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        PotionEffect[] effects = {
                new PotionEffect(MobEffects.REGENERATION, 1200, 1),
                new PotionEffect(MobEffects.STRENGTH, 1200, 1),
                new PotionEffect(MobEffects.SPEED, 1200, 1),
                new PotionEffect(MobEffects.JUMP_BOOST, 600, 0)
        };
        super.onFoodEaten(stack, worldIn, player);
        for (int i = 0; i < effects.length; i++) {
            if (!worldIn.isRemote) {
                player.addPotionEffect(effects[i]);
            }
        }
    }
}

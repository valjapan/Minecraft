package com.example.examplemod.mc_03_myitem;

import com.example.examplemod.ExampleMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.EnumHelper;

public class ItemMySword extends ItemSword {
    public ItemMySword() {
        super(EnumHelper.addToolMaterial("my_sword", 4, 200, 16.0f, 3.0f, 22));
        setCreativeTab(CreativeTabs.COMBAT);
        setRegistryName("my_sword");
        setUnlocalizedName(ExampleMod.MODID + "_my_sword");
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (stack == null) {
            return true;
        }
        if (!(attacker instanceof EntityPlayer)) {
            return true;
        }

        BlockPos pos = new BlockPos(target.posX + 1, target.posY, target.posZ);
        BlockPos pos1 = new BlockPos(target.posX - 1, target.posY, target.posZ);
        BlockPos pos2 = new BlockPos(target.posX, target.posY, target.posZ + 1);
        BlockPos pos3 = new BlockPos(target.posX, target.posY, target.posZ - 1);
        BlockPos pos4 = new BlockPos(target.posX, target.posY - 1, target.posZ);
        BlockPos pos5 = new BlockPos(target.posX + 1, target.posY + 20, target.posZ);
        BlockPos pos6 = new BlockPos(target.posX - 1, target.posY + 20, target.posZ);
        BlockPos pos7 = new BlockPos(target.posX, target.posY + 20, target.posZ + 1);
        BlockPos pos8 = new BlockPos(target.posX, target.posY + 20, target.posZ - 1);

        target.worldObj.setBlockState(pos, ExampleMod.blockMyBlock.getDefaultState());
        target.worldObj.setBlockState(pos1, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(pos2, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(pos3, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(pos4, Blocks.SLIME_BLOCK.getDefaultState());
        target.worldObj.setBlockState(pos5, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(pos6, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(pos7, Blocks.GLASS.getDefaultState());
        target.worldObj.setBlockState(pos8, Blocks.GLASS.getDefaultState());

        target.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 0));
        target.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 1200, 0));
//        target.setFire(600);
        target.setPosition(target.posX, target.posY + 20, target.posZ);

        return true;
    }
}

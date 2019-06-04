package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemMyScoop extends ItemPickaxe {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE});

    public ItemMyScoop() {
        super(EnumHelper.addToolMaterial("my_scoop", 3, 1000, 8.0F, 2.0F, 100));
        setCreativeTab(CreativeTabs.TOOLS);
        setRegistryName("my_scoop");
        setUnlocalizedName(ExampleMod.MODID + "_my_scoop");
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player) {
        PotionEffect[] effects = {
                new PotionEffect(MobEffects.REGENERATION, 600, 3),
                new PotionEffect(MobEffects.STRENGTH, 600, 3),
                new PotionEffect(MobEffects.SPEED, 600, 3),
                new PotionEffect(MobEffects.JUMP_BOOST, 600, 3),
                new PotionEffect(MobEffects.NIGHT_VISION, 600, 3),
                new PotionEffect(MobEffects.LUCK, 600, 3),
        };

        for (int i = 0; i < effects.length; i++) {
            player.addPotionEffect(effects[i]);
        }
        return super.onBlockStartBreak(itemstack, pos, player);
    }
}

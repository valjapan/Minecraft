package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

import java.util.Set;

public class ItemMyScoop extends ItemPickaxe {

    private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[]{Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE});

    public ItemMyScoop() {
        super(EnumHelper.addToolMaterial("my_scoop", 3, 1000, 4.0F, 2.0F, 100));
        setCreativeTab(CreativeTabs.TOOLS);
        setRegistryName("my_scoop");
        setUnlocalizedName(ExampleMod.MODID + "_my_scoop");
    }
//
//    @Override
//    public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
//        if (stack == null) {
//            return true;
//        }
//        if (worldIn.isRemote) {
//            return true;
//        }
//
//        Block block = state.getBlock();
//        if (block == Blocks.DIAMOND_BLOCK){
//            //ここでアイテム化する感じかな
//            //返り値はtrueでいいのかな
//        }
//
//
//        return super.onBlockDestroyed(stack, worldIn, state, pos, entityLiving);
//    }
//
//    @Override
//    public boolean canHarvestBlock(IBlockState blockIn) {
//        Block block = blockIn.getBlock();
//
//        if (block == Blocks.OBSIDIAN) {
//            return this.toolMaterial.getHarvestLevel() == 3;
//        } else if (block != Blocks.DIAMOND_BLOCK && block != Blocks.DIAMOND_ORE) {
//            if (block != Blocks.EMERALD_ORE && block != Blocks.EMERALD_BLOCK) {
//                if (block != Blocks.GOLD_BLOCK && block != Blocks.GOLD_ORE) {
//                    if (block != Blocks.IRON_BLOCK && block != Blocks.IRON_ORE) {
//                        if (block != Blocks.LAPIS_BLOCK && block != Blocks.LAPIS_ORE) {
//                            if (block != Blocks.REDSTONE_ORE && block != Blocks.LIT_REDSTONE_ORE) {
//                                Material material = blockIn.getMaterial();
//                                return material == Material.ROCK ? true : (material == Material.IRON ? true : material == Material.ANVIL);
//                            } else {
//                                return this.toolMaterial.getHarvestLevel() >= 2;
//                            }
//                        } else {
//                            return this.toolMaterial.getHarvestLevel() >= 1;
//                        }
//                    } else {
//                        return this.toolMaterial.getHarvestLevel() >= 1;
//                    }
//                } else {
//                    return this.toolMaterial.getHarvestLevel() >= 2;
//                }
//            } else {
//                return this.toolMaterial.getHarvestLevel() >= 2;
//            }
//        } else {
//            return this.toolMaterial.getHarvestLevel() >= 2;
//        }
//    }
//
//    public float getStrVsBlock(ItemStack stack, IBlockState state) {
//        Material material = state.getMaterial();
//        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
//    }
}

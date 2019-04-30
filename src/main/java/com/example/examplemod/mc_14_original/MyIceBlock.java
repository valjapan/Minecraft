package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class MyIceBlock extends Block {
//    private static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 4);
//    private int next = 4;

    public MyIceBlock() {
        super(Material.ICE);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        setRegistryName("myiceblock");
        setHardness(3000);
        setUnlocalizedName(ExampleMod.MODID + "_myiceblock");
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        worldIn.setBlockToAir(pos);
    }

    //
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//        return getDefaultState().withProperty(COLOR, meta);
//    }
//
//    @Override
//    public int getMetaFromState(IBlockState state) {
//        return state.getValue(COLOR);
//    }

//
//    @Override
//    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
//        System.out.println(String.valueOf(next));
//        if (next == 4) {
//            for (int i = -2; i < 4; i++) {
//                for (int j = -2; j < 4; j++) {
//                    for (int k = -2; k < 4; k++) {
//                        worldIn.setBlockState(pos, state);
//                        pos.add(0, 0, k);
//                        System.out.println("POS x = " + pos.getX() + " y = " + pos.getY() + " z = " + pos.getZ());
//                    }
//                    pos.add(0, j, 0);
//                }
//                pos.add(i, 0, 0);
//            }
//            worldIn.scheduleBlockUpdate(pos, this, 10, 100);
//            next--;
//
//        } else if (next == 3) {
//            Minecraft.getMinecraft().thePlayer.sendChatMessage("咲け！青薔薇！");
//            worldIn.scheduleBlockUpdate(pos, this, 10, 100);
//            for (int i = -20; i < 20; i++) {
//                for (int j = -20; j < 20; j++) {
//                    worldIn.setBlockState(pos, state);
//                    pos.add(0, 0, j);
//                }
//                pos.add(i, 0, 0);
//            }
//            worldIn.scheduleBlockUpdate(pos, this, 10, 100);
//            next--;
//
//        } else if (next == 2) {
//            Minecraft.getMinecraft().thePlayer.sendChatMessage("エンハンス解除！");
//            worldIn.scheduleBlockUpdate(pos, this, 10, 100);
//            for (int i = -20; i < 20; i++) {
//                for (int j = -20; j < 20; j++) {
//                    worldIn.destroyBlock(pos, true);
//                    pos.add(0, 0, j);
//                }
//                pos.add(i, 0, 0);
//            }
//            worldIn.scheduleBlockUpdate(pos, this, 10, 100);
//            next--;
//
//        } else if (next == 1) {
//            for (int i = -2; i < 4; i++) {
//                for (int j = -2; j < 4; j++) {
//                    for (int k = -2; k < 4; k++) {
//                        worldIn.destroyBlock(pos, true);
//                        pos.add(0, 0, k);
//                        System.out.println("POS x = " + pos.getX() + " y = " + pos.getY() + " z = " + pos.getZ());
//                    }
//                    pos.add(0, j, 0);
//                }
//                pos.add(i, 0, 0);
//            }
//            next--;
//
//        } else if (next == 0) {
//            next = 4;
//        }
//    }
}

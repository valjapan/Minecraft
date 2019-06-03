package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockIcePlaceEventHandler {

    @SubscribeEvent
    public void onEntityDead(LivingDeathEvent event) {
        World world = event.getEntity().worldObj;
        if (world.isRemote) {
            return;
        }
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        if (player == null) {
            return;
        }
        if (player.getHeldItemMainhand() == null) {
            return;
        }
        Item item = player.getHeldItemMainhand().getItem();
        if (!(item == ExampleMod.iceSword)) {
            return;
        }


        BlockPos pos = event.getEntity().getPosition();
//        Block block = world.getBlockState(pos.add(0, 1, 0)).getBlock();
//        if (block != ExampleMod.blockBlueIce) {
//            return;
//        }

        event.setCanceled(true);

//        breakBlock(world, pos.getX(), pos.getY(), pos.getZ(), 1);
        breakBlock(world, pos);
    }

    private void breakBlock(World world, BlockPos pos) {
        for (int y = 0; y < 3; y++) {
            for (int z = -3; z < 4; z++) {
                world.setBlockToAir(pos.add(-3, y, z));
                world.setBlockToAir(pos.add(-2, y, z));
                world.setBlockToAir(pos.add(-1, y, z));
                world.setBlockToAir(pos.add(0, y, z));
                world.setBlockToAir(pos.add(1, y, z));
                world.setBlockToAir(pos.add(2, y, z));
                world.setBlockToAir(pos.add(3, y, z));
            }
        }
        Minecraft.getMinecraft().thePlayer.sendChatMessage("エンハンス解除！");

    }

    private void breakBlock(World world, int x, int y, int z, int depth) {
        BlockPos pos = new BlockPos(x, y, z);
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block == ExampleMod.blockMyIceBlock || block == ExampleMod.blockMyIceBlock || block == ExampleMod.blockMyIceBlock || block == ExampleMod.blockMyIceBlock) {
            block.dropBlockAsItem(world, pos, blockState, 0);
            world.setBlockToAir(pos);
            if (block == ExampleMod.blockMyIceBlock || block == ExampleMod.blockMyIceBlock) {
                breakBlock(world, x, y + 1, z, depth);
            }
            breakBlock(world, x + 1, y, z, depth + 1);
            breakBlock(world, x - 1, y, z, depth + 1);
            breakBlock(world, x, y, z + 1, depth + 1);
            breakBlock(world, x, y, z - 1, depth + 1);
        }

    }


}

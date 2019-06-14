package com.example.examplemod.mc_14_original;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BlockMyScoopEventHandler {
    private static final int MAX_DEPTH = 5;

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        EntityPlayer player = event.getPlayer();
        if (player == null) {
            return;
        }

        if (player.getHeldItemMainhand() == null) {
            return;
        }

        Item item = player.getHeldItemMainhand().getItem();
        if (!(item == Items.DIAMOND_PICKAXE || item == Items.GOLDEN_PICKAXE || item == Items.IRON_PICKAXE || item == Items.STONE_PICKAXE || item == Items.WOODEN_PICKAXE || item == ExampleMod.myScoop)) {
            return;
        }

        Block block = event.getState().getBlock();
        if (block != Blocks.STONE && block != Blocks.DIRT) {
            return;
        }
        event.setCanceled(true);

        BlockPos pos = event.getPos();
        breakBlock(event.getWorld(), pos.getX(), pos.getY(), pos.getZ(), 1);

    }

    private void breakBlock(World world, int x, int y, int z, int depth) {
        if (depth > MAX_DEPTH) {
            return;
        }
        BlockPos pos = new BlockPos(x, y, z);
        IBlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block == Blocks.STONE || block == Blocks.DIRT || block == Blocks.OBSIDIAN ||
                block == Blocks.GRASS || block == ExampleMod.blockMyBlock ||
                block == Blocks.GRAVEL || block == Blocks.LAVA || block == Blocks.WATER) {
            block.dropBlockAsItem(world, pos, blockState, 0);
            world.setBlockToAir(pos);

            if (block == Blocks.STONE || block == Blocks.DIRT || block == ExampleMod.blockMyBlock ||
                    block == Blocks.LAVA || block == Blocks.WATER) {
                breakBlock(world, x, y - 1, z, depth + 1);
                breakBlock(world, x, y + 1, z, depth + 1);
            }
            breakBlock(world, x + 1, y, z, depth + 1);
            breakBlock(world, x - 1, y, z, depth + 1);
            breakBlock(world, x, y, z + 1, depth + 1);
            breakBlock(world, x, y, z - 1, depth + 1);
        }
    }
}

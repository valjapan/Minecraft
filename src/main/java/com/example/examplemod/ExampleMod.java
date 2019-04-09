package com.example.examplemod;

import com.example.examplemod.mc_02_myblock.MyBlock;
import com.example.examplemod.mc_03_myitem.ItemMySword;
import com.example.examplemod.mc_03_myitem.ItemOnigiri;
import com.example.examplemod.mc_04_rainbowblock.BlockRainbow;
import com.example.examplemod.mc_05_soundblock.BlockSound;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
public class ExampleMod {
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";

    //MC-02 : MyBlock
    public static Block blockMyBlock = new MyBlock();

    //MC-03 : MyItem
    public static Item itemMySword = new ItemMySword();

    public static Item itemOnigiri = new ItemOnigiri();

    //MC-04 : Rainbow
    public static Block blockRainbow = new BlockRainbow();

    //MC-05 BlockSound
    public static Block blockSound = new BlockSound();
    public static SoundEvent[] soundEvents = {
            new SoundEvent(new ResourceLocation(MODID, "sound1")),
            new SoundEvent(new ResourceLocation(MODID, "sound2")),
            new SoundEvent(new ResourceLocation(MODID, "sound3"))
    };


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        boolean isClient = event.getSide().isClient();
        registerRecipe();

        registerBlock(blockMyBlock, isClient);
        registerBlock(blockRainbow, isClient);

        registerSoundBlock(isClient);

        registryMyItem(isClient);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    public void registerRecipe() {
        GameRegistry.addRecipe(new ItemStack(Blocks.DIAMOND_BLOCK),
                "AAA",
                "AAA",
                "AAA",
                'A', new ItemStack(Blocks.DIRT));

        NBTTagCompound creeperId = new NBTTagCompound();
        creeperId.setString("id", "Creeper");
        ItemStack crepperSpawnEgg = new ItemStack(Items.SPAWN_EGG);
        crepperSpawnEgg.setTagInfo("EntityTag", creeperId);
        GameRegistry.addRecipe(crepperSpawnEgg,
                " A ",
                "CBC",
                "CBC",
                'A', new ItemStack(Items.SKULL, 1, 4),
                'B', new ItemStack(Blocks.TNT),
                'C', new ItemStack(Items.GUNPOWDER));
    }

//    private void registerMyBlock(boolean isClient) {
//        ItemBlock itemBlock = new ItemBlock(blockMyBlock);
//
//        GameRegistry.register(blockMyBlock);
//        GameRegistry.register(itemBlock, blockMyBlock.getRegistryName());
//
//        if (isClient) {
//            ModelResourceLocation modelName = new ModelResourceLocation(blockMyBlock.getRegistryName(), "inventory");
//            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, modelName);
//        }
//    }
//
//    private void registerRainbowBlock(boolean isClient) {
//        ItemBlock itemBlock = new ItemBlock(blockRainbow);
//
//        GameRegistry.register(blockRainbow);
//        GameRegistry.register(itemBlock, blockRainbow.getRegistryName());
//
//        if (isClient) {
//            ModelResourceLocation modelName = new ModelResourceLocation(blockRainbow.getRegistryName(), "inventory");
//            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, modelName);
//        }
//    }

    private void registerSoundBlock(boolean isClient) {
        ItemBlock itemBlock = new ItemBlock(blockSound);

        GameRegistry.register(blockSound);
        GameRegistry.register(itemBlock, blockSound.getRegistryName());
        for (int i = 0; i < soundEvents.length; i++) {
            GameRegistry.register(soundEvents[i], soundEvents[i].getSoundName());
        }

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(blockSound.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, modelName);
        }
    }

    private void registryMyItem(boolean isClient) {
        GameRegistry.register(itemMySword);

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(itemMySword.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemMySword, 0, modelName);
        }

        GameRegistry.register(itemOnigiri);

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(itemOnigiri.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemOnigiri, 0, modelName);
        }
    }

    // ======================================================================================================
    // ここから下はいじらないよ！

    private void registerBlock(Block block, boolean isClient) {
        ItemBlock itemBlockInput = new ItemBlock(block);

        GameRegistry.register(block);
        GameRegistry.register(itemBlockInput, block.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(block.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockInput, 0, modelName);
        }
    }

    private void registerItem(Item item, boolean isClient) {
        GameRegistry.register(item);
        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelName);
        }
    }
}

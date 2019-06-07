package com.example.examplemod;

import com.example.examplemod.mc_02_myblock.MyBlock;
import com.example.examplemod.mc_03_myitem.ItemMySword;
import com.example.examplemod.mc_03_myitem.ItemOnigiri;
import com.example.examplemod.mc_04_rainbowblock.BlockRainbow;
import com.example.examplemod.mc_05_soundblock.BlockSound;
import com.example.examplemod.mc_06_woodcut.BlockBreakEventHandler;
import com.example.examplemod.mc_07_redstone.BlockRedstoneClock;
import com.example.examplemod.mc_07_redstone.BlockRedstoneInput;
import com.example.examplemod.mc_08_snowball_fight.EntityMySnowball;
import com.example.examplemod.mc_08_snowball_fight.ItemMySnowball;
import com.example.examplemod.mc_09_footprints_sand.BlockFootprintsSand;
import com.example.examplemod.mc_10_biome.BiomeIceberg;
import com.example.examplemod.mc_10_biome.BiomeMyBiome;
import com.example.examplemod.mc_10_biome.MyWorldGenerator;
import com.example.examplemod.mc_11_explosive_arrow.EntityExplosiveArrow;
import com.example.examplemod.mc_11_explosive_arrow.ItemExplosiveArrow;
import com.example.examplemod.mc_11_explosive_arrow.RenderExplosiveArrow;
import com.example.examplemod.mc_12_bull_fighting.EntityBull;
import com.example.examplemod.mc_12_bull_fighting.RenderBull;
import com.example.examplemod.mc_13_tobisuke.EntityTobisuke;
import com.example.examplemod.mc_13_tobisuke.RenderTobisuke;
import com.example.examplemod.mc_14_original.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
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

    //MC-07 RedStone
    public static Block blockRedstoneInput = new BlockRedstoneInput();
    public static Block blockRedstoneClock = new BlockRedstoneClock();

    //MC-08 SnowballFight
    public static Item itemMySnowball = new ItemMySnowball();

    //MC-09 FootprintsSand
    public static Block blockFootprintsSand = new BlockFootprintsSand();

    //MC-10 BiommeMod
    public static BiomeManager.BiomeEntry myBiomeEntry = new BiomeManager.BiomeEntry(new BiomeMyBiome(), 30);
    public static BiomeManager.BiomeEntry icebergBiommeEntry = new BiomeManager.BiomeEntry(new BiomeIceberg(), 30);

    //MC-11 ExplosiveArrow
    public static Item itemExplosiveArrow = new ItemExplosiveArrow();

    //MC-14 Original
    public static Item iceSword = new ItemIceSword();
    public static Block blockMyIceBlock = new MyIceBlock();

    public static Item myScoop = new ItemMyScoop();
//    public static Block blockMyMoveBlock = new MyMoveBlock();

    public static Block blockExplosionResistanceBlock = new ExplosionResistanceBlock();
    public static Block blockExplosionResistanceLightBlock = new ExplosionResistanceLightBlock();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        boolean isClient = event.getSide().isClient();
        registerRecipe();

        registerBlock(blockMyBlock, isClient);
        registerBlock(blockRainbow, isClient);

        registerSoundBlock(isClient);

        registryMyItem(isClient);

        registerRedstone(isClient);

        registerSnowballFight(isClient);

        registerSnowballFightRenderer();

        registerFootprintsSand(isClient);

        registerExplosiveArrow(isClient);

        registerExplosiveArrowRenderer();

        registerBull();

        registerBullRenderer();

        registerBiome();

        registerTobisuke();
        registerTobisukeRenderer();

        registerBlock(blockMyIceBlock, isClient);
//        registerBlock(blockMyMoveBlock,isClient);

        registerBlock(blockExplosionResistanceBlock, isClient);

        registerBlock(blockExplosionResistanceLightBlock, isClient);


    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        registerWoodCut();
        registerBlueIcePlace();
        registerMining();
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

        NBTTagCompound iceSwordId = new NBTTagCompound();
        iceSwordId.setString("id", "ice_sword");
        ItemStack iceSword = new ItemStack(ExampleMod.iceSword);
        iceSword.setTagInfo("item", iceSwordId);
        GameRegistry.addRecipe((iceSword),
                " A ",
                " A ",
                " B ",
                'A', new ItemStack(Blocks.ICE),
                'B', new ItemStack(Items.STICK));


        NBTTagCompound myScoopId = new NBTTagCompound();
        myScoopId.setString("id", "my_scoop");
        ItemStack myScoop = new ItemStack(ExampleMod.myScoop);
        myScoop.setTagInfo("item", myScoopId);
        GameRegistry.addRecipe((myScoop),
                "ACA",
                " B ",
                " B ",
                'A', new ItemStack(Items.DIAMOND),
                'B', new ItemStack(Items.STICK),
                'C', new ItemStack(Items.EMERALD));


        NBTTagCompound myIceBlockId = new NBTTagCompound();
        myIceBlockId.setString("id", "my_ice_block");
        ItemStack myIceBlock = new ItemStack(ExampleMod.blockMyIceBlock);
        myIceBlock.setTagInfo("item", myIceBlockId);
        GameRegistry.addRecipe((myIceBlock),
                "AAA",
                "AAA",
                "AAA",
                'A', new ItemStack(Blocks.ICE));


    }

    private void registerSnowballFight(boolean isClient) {
        GameRegistry.register(itemMySnowball);

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(Items.SNOWBALL.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemMySnowball, 0, modelName);
        }

        EntityRegistry.registerModEntity(EntityMySnowball.class, "my_snowball", EntityMySnowball.ENTITY_ID, this, 10, 10, true);
    }

    private void registerSnowballFightRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMySnowball.class, new IRenderFactory<EntityMySnowball>() {
            @Override
            public Render<? super EntityMySnowball> createRenderFor(RenderManager manager) {
                return new RenderSnowball<EntityMySnowball>(manager, Items.SNOWBALL, Minecraft.getMinecraft().getRenderItem());
            }
        });
    }

    private void registerMining() {
        MinecraftForge.EVENT_BUS.register(new BlockMyScoopEventHandler());
    }

    private void registerFootprintsSand(boolean isClient) {
        ItemBlock itemBlock = new ItemBlock(blockFootprintsSand);

        GameRegistry.register(blockFootprintsSand);
        GameRegistry.register(itemBlock, blockFootprintsSand.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelname = new ModelResourceLocation(blockFootprintsSand.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlock, 0, modelname);
        }
    }

    private void registerBiome() {
        GameRegistry.registerWorldGenerator(new MyWorldGenerator(blockMyBlock, 1000), 1);

        BiomeManager.oceanBiomes.clear();
        BiomeProvider.allowedBiomes.clear();

        Biome.registerBiome(40, "mybiome", myBiomeEntry.biome);
        BiomeManager.addSpawnBiome(myBiomeEntry.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, myBiomeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, myBiomeEntry);

        Biome.registerBiome(41, "iceberg", icebergBiommeEntry.biome);
        BiomeManager.addSpawnBiome(icebergBiommeEntry.biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, icebergBiommeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, icebergBiommeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.ICY, icebergBiommeEntry);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, icebergBiommeEntry);
    }

    private void registerBlueIcePlace() {
        // Handlerを設置
        MinecraftForge.EVENT_BUS.register(new BlockIcePlaceEventHandler());
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

    private void registerWoodCut() {
        MinecraftForge.EVENT_BUS.register(new BlockBreakEventHandler());
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

        GameRegistry.register(iceSword);

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(iceSword.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(iceSword, 0, modelName);
        }

        GameRegistry.register(myScoop);
        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(myScoop.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(myScoop, 0, modelName);
        }
    }

    private void registerRedstone(boolean isClient) {
        ItemBlock itemBlockImput = new ItemBlock(blockRedstoneInput);

        GameRegistry.register(blockRedstoneInput);
        GameRegistry.register(itemBlockImput, blockRedstoneInput.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(blockRedstoneInput.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockImput, 0, modelName);
        }

        ItemBlock itemBlockClock = new ItemBlock(blockRedstoneClock);

        GameRegistry.register(blockRedstoneClock);
        GameRegistry.register(itemBlockClock, blockRedstoneClock.getRegistryName());

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(blockRedstoneClock.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemBlockClock, 0, modelName);
        }
    }

    private void registerExplosiveArrow(boolean isClient) {
        GameRegistry.register(itemExplosiveArrow);
        EntityRegistry.registerModEntity(EntityExplosiveArrow.class, "explosive_arrow", EntityExplosiveArrow.ENTITY_ID, this, 10, 10, true);

        if (isClient) {
            ModelResourceLocation modelName = new ModelResourceLocation(itemExplosiveArrow.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(itemExplosiveArrow, 0, modelName);
        }
    }

    private void registerExplosiveArrowRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityExplosiveArrow.class, new IRenderFactory<EntityExplosiveArrow>() {
            @Override
            public Render<? super EntityExplosiveArrow> createRenderFor(RenderManager manager) {
                return new RenderExplosiveArrow(manager);
            }
        });
    }

    private void registerBull() {
        EntityRegistry.registerModEntity(EntityBull.class, "bull", EntityBull.ENTITY_ID, this, 10, 10, true, 0xFFFF00, 0xFF0000);
    }

    private void registerBullRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityBull.class, RenderBull::new);
    }

    private void registerTobisuke() {
        //新しいMobの登録と、spawnEggの登録
        EntityRegistry.registerModEntity(EntityTobisuke.class, "tobisuke", EntityTobisuke.ENTITY_ID, this, 10, 10, true, 0xFF0000, 0x00FF00);
        //自然にスポーンするように
        //"出現頻度","最小スポーン数","最大スポーン数"の順で値を決める
        //出現度の指定 creature:昼間,monster:夜,waterCreature:水の中
        //出現するバイオームの指定
        EntityRegistry.addSpawn(EntityTobisuke.class, 20, 15, 30, EnumCreatureType.CREATURE, Biomes.PLAINS);
    }

    private void registerTobisukeRenderer() {
        //MobとRenderの登録を行う
        RenderingRegistry.registerEntityRenderingHandler(EntityTobisuke.class, RenderTobisuke::new);
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

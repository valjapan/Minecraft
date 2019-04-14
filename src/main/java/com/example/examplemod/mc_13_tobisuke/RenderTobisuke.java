package com.example.examplemod.mc_13_tobisuke;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTobisuke extends RenderLiving<EntityTobisuke> {
    private static final ResourceLocation tobisukeTexture= new ResourceLocation("examplemod:textures/entity/tobisuke.png");

    public RenderTobisuke(RenderManager renderManagerIn){
        super(renderManagerIn,new ModelTobisuke(),0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityTobisuke entity) {
        return tobisukeTexture;
    }
}

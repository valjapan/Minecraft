package com.example.examplemod.mc_13_tobisuke;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTobisuke extends ModelBase {

    public ModelRenderer body;
    public ModelRenderer head;

    public ModelTobisuke() {
        float f = 4.0F;

        //新しく描画するものを作り、読み込むテクスチャサイズを64*64と指定する
        head = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);

        //頭を作る
        head.setTextureOffset(0, 0);
        //読み込むテクスチャの中で読み込みの開始位置を決める
        head.addBox(-3.0F, -1.0F, -7.0F, 6, 6, 6);

        //くちばしを作る
        //読み込むテクスチャの中で読み込みの開始位置を決める
        head.setTextureOffset(24, 0);
        //最初の3つで始点を決めて、3つで全体の形を決める
        head.addBox(-1.5F, 3.0F, -8.0F, 3, 1, 1);
        //回転する基準の場所を決める
        head.setRotationPoint(0.0F, 0.0F + f + 9.0F, 0.0F);

        body = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);

        //体を作る
        body.setTextureOffset(0, 18);
        //最初の3つで始点を決めて、3つで全体の形を決める
        body.addBox(-4.5F, -6.0F, -7.5F, 9, 6, 12);


        //翼(右)を作る
        //読み込むテクスチャの中で読み込みの開始位置を決める
        body.setTextureOffset(30, 0);
        //最初の3つで始点を決めて、3つで全体の形を決める
        body.addBox(-5.5F, -5.0F, -7.0F, 1, 4, 8);

        //翼(左)を作る
        //読み込むテクスチャの中で読み込みの開始位置を決める
        body.setTextureOffset(30, 0);
        //最初の3つで始点を決めて、3つで全体の形を決める
        body.addBox(4.5F, -5.0F, -7.0F, 1, 4, 8);
        //回転する基準の場所を決める
        body.setRotationPoint(0.0F, 0.0F + f + 20.0F, 0.0F);
    }

    public void setRotationAngels(float time, float speed, float miscAngle, float yaw, float pitch, float scale, Entity entity) {
        super.setRotationAngles(time, speed, miscAngle, yaw, pitch, scale, entity);
        head.rotateAngleY = yaw / (180F / (float) Math.PI) * 0.25F;
    }

    public void render(Entity entity, float time, float speed, float miscAngle, float yaw, float pitch, float scale) {
        setRotationAngels(time, speed, miscAngle, yaw, pitch, scale, entity);
        head.render(scale);
        body.render(scale);
    }
}

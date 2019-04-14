package com.example.examplemod.mc_13_tobisuke;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class EntityTobisuke extends EntityTameable {
    public static final int ENTITY_ID = 2;

    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(EntityWolf.class, DataSerializers.FLOAT);

    public EntityTobisuke(World worldIn) {
        super(worldIn);
        setSize(0.9F, 0.9F);
        //ここで使うAIを指定している
        //Tobisukeは、もともとあるAIを利用している
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0d, 10.0f, 2.0f));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0d));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0d));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        setTamed(false);
    }

    @Override
    protected void applyEntityAttributes() {
        //動作速度を指定しています
        super.applyEntityAttributes();
        getAttributeMap().getAttributeInstance(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3d);
    }

    @Override
    public boolean isAIDisabled() {
        //AIによる動きをさせないかどうかを指定している
        return false;
    }

    protected void updateAITasks() {
        this.dataManager.set(DATA_HEALTH_ID, getHealth());
    }

    protected void entityInit() {
        //Mobの体力を指定
        super.entityInit();
        this.dataManager.register(DATA_HEALTH_ID, getHealth());
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        //子供が生まれるときに子供サイズのものを作るかを指定
        //Tobisukeは子供サイズを作らない
        return new EntityTobisuke(worldObj);
    }

    @Override
    public boolean isBreedingItem(@Nullable ItemStack stack) {
        //懐かせるためのアイテムを指定している
        //Tobisukeは「りんご」で懐くようにしている
        return stack != null && stack.getItem() == Items.APPLE;
    }

    @Override
    protected boolean canDespawn() {
        //消滅させる条件を指定
        //今回は懐いていないかつ、距離が一定以上離れたらという条件
        return !isTamed() && ticksExisted > 2400;
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {
        //プレイヤーにクリックされた時の挙動を指定している
        if (isTamed()) {
            //すでに懐いていた時
            if (isOwner(player) && !this.worldObj.isRemote && !this.isBreedingItem(stack)) {
                aiSit.setSitting(!isSitting());
                isJumping = false;
                navigator.clearPathEntity();
                setAttackTarget(null);
            }
        } else if (isBreedingItem(stack)) {
            //懐いておらず、懐かせるためのアイテムを持っていた時
            if (!player.capabilities.isCreativeMode) {
                //持っている懐かせるためのアイテムを１つ減らす
                --stack.stackSize;
            }
            if (!this.worldObj.isRemote) {
                //Tobisukeの懐いた後の行動を決めている。
                //Tobisukeは懐いた後、プレイヤーの後をついてくるようにしたいのでこのように書く
                setTamed(true);
                navigator.clearPathEntity();
                setAttackTarget(null);
                aiSit.setSitting(true);
                setHealth(20.0F);
                setOwnerId(player.getUniqueID());
                playTameEffect(true);
                worldObj.setEntityState(this, (byte) 7);
            }
            return true;
        }
        return super.processInteract(player, hand, stack);
    }
}

package com.serenity.biomesplus.entity.monster;

import javax.annotation.Nullable;

import com.serenity.biomesplus.util.Reference;
import com.serenity.biomesplus.util.handlers.LootTableHandler;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIFleeSun;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictSun;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfo.Overlay;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityArmourSkeleton extends AbstractSkeleton

{
	
    public EntityArmourSkeleton(World worldIn)
    {
        super(worldIn);
    }

    public static void registerFixesSkeleton(DataFixer fixer)
    {
        EntityLiving.registerFixesMob(fixer, EntityArmourSkeleton.class);
    }
    

    @Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty)
    {
    	int rand_int1 = rand.nextInt(3);
    	int rand_int2 = rand.nextInt(99);
    	int rand_int3 = rand.nextInt(99);
    	int rand_int4 = rand.nextInt(99);
    	int rand_int5 = rand.nextInt(99);
    	int rand_int6 = rand.nextInt(100);
    	
    	int rand_int0 = rand.nextInt(5);
    	
    	if (rand_int1 == 0)
    			{
    				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
    			}else if (rand_int1 == 1)
    			{
    				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
    			}else if (rand_int1 == 2)
    			{
    				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
    			}else if (rand_int1 == 3)
    			{
    				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    			}
    	
    	if (rand_int2 >= 0  && rand_int2 <= 10)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.LEATHER_HELMET));
    		}else if (rand_int2 >= 11  && rand_int2 <= 40)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
    		}else if (rand_int2 >= 41  && rand_int2 <= 70)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
    		}else if (rand_int2 >= 71  && rand_int2 <= 99)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Items.DIAMOND_HELMET));
    		}
    	
    		if (rand_int3 >= 0  && rand_int3 <= 10)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.LEATHER_CHESTPLATE));    	
    		}else if (rand_int3 >= 11  && rand_int3 <= 40)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));		
    		}else if (rand_int3 >= 41  && rand_int3 <= 70)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));		
    		}else if (rand_int3 >= 71  && rand_int3 <= 99)
    		{
    			this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
    		}
    		
    		if (rand_int4 >= 0  && rand_int4 <= 10)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.LEATHER_LEGGINGS));
    		}else if (rand_int4 >= 11  && rand_int4 <= 40)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
    		}else if (rand_int4 >= 41  && rand_int4 <= 70)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
    		}else if (rand_int4 >= 71  && rand_int4 <= 99)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
    		}

    		if (rand_int5 >= 0  && rand_int5 <= 10)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.LEATHER_BOOTS));
    		}else if (rand_int5 >= 11  && rand_int5 <= 40)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
    		}else if (rand_int5 >= 41  && rand_int5 <= 70)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
    		}else if (rand_int5 >= 71  && rand_int5 <= 99)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
    		}
    		
    		if (rand_int0 >= 0  && rand_int0 <= 4)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Blocks.AIR));
    		}
    		
    		if (rand_int0 == 5)
    		{
    	    	this.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));

    		}
    		

    		if (rand_int6 == 3)
        	{
    			

    			
        		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
        		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0);
        		this.setHealth(this.getMaxHealth());
        		
        		this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
        		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Blocks.AIR));
        		this.setItemStackToSlot(EntityEquipmentSlot.LEGS, new ItemStack(Blocks.AIR));
        		this.setItemStackToSlot(EntityEquipmentSlot.FEET, new ItemStack(Blocks.AIR));
        		
        		this.glowing = true;
        		this.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 1000000, 0));       
        	    
        		this.setCustomNameTag("Skeleton Boss");
        		this.experienceValue = 80;
        		        		      	
        	
        		
        	}
    		
        
    }
    
   

	
    
   
	

	@Override
    protected void initEntityAI()
    {
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIRestrictSun(this));
        this.tasks.addTask(3, new EntityAIFleeSun(this, 1.0D));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityWolf.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
    }
    
    @Nullable
    protected ResourceLocation getLootTable()
    {    	 
    	
    	
    	if (this.glowing == true)
    	{
    		
    	return LootTableHandler.SKELETON_BOSS;
    	
    	}else
        return LootTableHandler.ARMOUR_SKELETON;
        
        		
    }

    protected SoundEvent getAmbientSound()
    {
    	if (this.glowing == true)
    	{
        	return SoundEvents.ENTITY_STRAY_AMBIENT;

    	}else
    	return SoundEvents.ENTITY_SKELETON_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
    	
    	if (this.glowing == true)
    	{
        	return SoundEvents.ENTITY_STRAY_HURT;

    	}else
        return SoundEvents.ENTITY_SKELETON_HURT;
    }

    protected SoundEvent getDeathSound()
    {
    	
    	if (this.glowing == true)
    	{
        	return SoundEvents.ENTITY_STRAY_DEATH;

    	}else
        return SoundEvents.ENTITY_SKELETON_DEATH;
    }

    protected SoundEvent getStepSound()
    {
    	
    	if (this.glowing == true)
    	{
        	return SoundEvents.ENTITY_STRAY_STEP;

    	}else
        return SoundEvents.ENTITY_SKELETON_STEP;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource cause)
    {
        super.onDeath(cause);

        if (cause.getTrueSource() instanceof EntityCreeper)
        {
            EntityCreeper entitycreeper = (EntityCreeper)cause.getTrueSource();

            if (entitycreeper.getPowered() && entitycreeper.ableToCauseSkullDrop())
            {
                entitycreeper.incrementDroppedSkulls();
                this.entityDropItem(new ItemStack(Items.SKULL, 1, 0), 0.0F);
            }
        }
    }
    
    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);

    }

    protected EntityArrow getArrow(float p_190726_1_)
    {
        ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

        if (itemstack.getItem() == Items.SPECTRAL_ARROW)
        {
            EntitySpectralArrow entityspectralarrow = new EntitySpectralArrow(this.world, this);
            entityspectralarrow.setEnchantmentEffectsFromEntity(this, p_190726_1_);
            return entityspectralarrow;
        }
        else
        {
            EntityArrow entityarrow = super.getArrow(p_190726_1_);

            if (itemstack.getItem() == Items.TIPPED_ARROW && entityarrow instanceof EntityTippedArrow)
            {
                ((EntityTippedArrow)entityarrow).setPotionEffect(itemstack);
            }

            return entityarrow;
        }
    }
}
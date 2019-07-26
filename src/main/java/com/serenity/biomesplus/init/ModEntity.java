package com.serenity.biomesplus.init;

import com.serenity.biomesplus.Main;
import com.serenity.biomesplus.entity.monster.EntityArmourSkeleton;
import com.serenity.biomesplus.entity.monster.EntityArmourWitherSkeleton;
import com.serenity.biomesplus.entity.monster.EntityCustomVindicator;
import com.serenity.biomesplus.entity.projectile.EntityCustomSnowball;
import com.serenity.biomesplus.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntity 
{
	
	public static void  registerEntities()
	{
		registerEntity("custom_vindicator", EntityCustomVindicator.class, Reference.ENTITY_CUSTOM_VINDICATOR, 50, 8553090, 000000);
		registerEntity("armoured_skeleton", EntityArmourSkeleton.class, Reference.ENTITY_ARMOUR_SKELETON, 50, 8553090, 000000);
		registerEntity("armoured_wither", EntityArmourWitherSkeleton.class, Reference.ENTITY_ARMOUR_WITHER_SKELETON, 50, 546437, 123456);
		registerProjectile("custom_snowball", Reference.ENTITY_SNOWBALL, EntityCustomSnowball.class, ModItems.CUSTOM_SNOWBALL);
		

	}
	
	private static void registerEntity(String name, Class <? extends Entity> entity, int id, int range, int color1, int color2)
	{
	EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
	}
	
	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, Main.instance, 64, 10, true);
	}
}

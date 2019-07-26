package com.serenity.biomesplus.util.handlers;

import com.serenity.biomesplus.Main;
import com.serenity.biomesplus.entity.monster.EntityArmourSkeleton;
import com.serenity.biomesplus.entity.monster.EntityArmourWitherSkeleton;

import com.serenity.biomesplus.entity.monster.EntityCustomVindicator;
import com.serenity.biomesplus.entity.projectile.EntityCustomSnowball;
import com.serenity.biomesplus.entity.render.RenderSkeleton;

import com.serenity.biomesplus.entity.render.RenderVindicator;
import com.serenity.biomesplus.entity.render.RenderWitherSkeleton;
import com.serenity.biomesplus.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

public class RenderHandler 
{

	
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityCustomVindicator.class, new IRenderFactory<EntityCustomVindicator>()
				{
					@Override
					public Render<? super EntityCustomVindicator> createRenderFor(RenderManager manager) {
						// TODO Auto-generated method stub
						return new RenderVindicator(manager);
					}
				});
		

		RenderingRegistry.registerEntityRenderingHandler(EntityArmourWitherSkeleton.class, new IRenderFactory<EntityArmourWitherSkeleton>()
		{
			@Override
			public Render<? super EntityArmourWitherSkeleton> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderWitherSkeleton(manager);
			}
		});
	
		
		RenderingRegistry.registerEntityRenderingHandler(EntityArmourSkeleton.class, new IRenderFactory<EntityArmourSkeleton>()
		{
			@Override
			public Render<? super EntityArmourSkeleton> createRenderFor(RenderManager manager) {
				// TODO Auto-generated method stub
				return new RenderSkeleton(manager);
			}
		});
	}
}
	

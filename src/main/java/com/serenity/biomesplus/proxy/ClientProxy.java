package com.serenity.biomesplus.proxy;

import com.serenity.biomesplus.entity.projectile.EntityCustomSnowball;

import com.serenity.biomesplus.init.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerItemRenderer(Item item, int meta, String id)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	
	@Override
	public void render()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityCustomSnowball.class, new RenderSnowball<EntityCustomSnowball>(Minecraft.getMinecraft().getRenderManager(), ModItems.CUSTOM_SNOWBALL, Minecraft.getMinecraft().getRenderItem()));
	}
}
package com.serenity.biomesplus.util.handlers;

import java.util.Random;

import com.serenity.biomesplus.Main;
import com.serenity.biomesplus.WorldGen.ModWorldGenerator;
import com.serenity.biomesplus.init.ModBiome;
import com.serenity.biomesplus.init.ModEntity;
import com.serenity.biomesplus.init.ModItems;
import com.serenity.biomesplus.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler 
{
	
	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		ModEntity.registerEntities();
		RenderHandler.registerEntityRenders();
		ConfigHandler.registerConfig(event);
		
		GameRegistry.registerWorldGenerator(new ModWorldGenerator(), 0);
	}
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
		{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));

		}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
		{
			
		}
	
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		
		for(Item item : ModItems.ITEMS)	
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		
		
	
	}
	
	public static void initRegistries()
	{
		Main.proxy.render();

	}

	
	public static void otherRegistries()
	{
		ModBiome.registerBiomes();
		
	}


}

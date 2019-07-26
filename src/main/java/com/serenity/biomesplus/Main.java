package com.serenity.biomesplus;

import java.io.File;

import com.serenity.biomesplus.init.ModBiome;
import com.serenity.biomesplus.proxy.CommonProxy;
import com.serenity.biomesplus.util.Reference;
import com.serenity.biomesplus.util.handlers.RegistryHandler;
import com.serenity.biomesplus.util.handlers.RenderHandler;

import net.minecraft.world.biome.BiomeForest.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)

public class Main {
	
	public static File config;
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	static { FluidRegistry.enableUniversalBucket(); }
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		
		RegistryHandler.preInitRegistries(event);
	
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		BiomeManager.addVillageBiome(ModBiome.OVERGROWN, true);
		BiomeManager.addStrongholdBiome(ModBiome.OVERGROWN);
		
		BiomeManager.addVillageBiome(ModBiome.MAGIC_FOREST, true);
		BiomeManager.addStrongholdBiome(ModBiome.MAGIC_FOREST);
		
		BiomeManager.addVillageBiome(ModBiome.SNOW_BIOME, true);
		BiomeManager.addStrongholdBiome(ModBiome.SNOW_BIOME);
			
		BiomeManager.addVillageBiome(ModBiome.DANGER_WOODS, true);
		BiomeManager.addStrongholdBiome(ModBiome.DANGER_WOODS);
		
		BiomeManager.addVillageBiome(ModBiome.BLACK_FOREST, true);
		BiomeManager.addStrongholdBiome(ModBiome.BLACK_FOREST);
		
		RegistryHandler.otherRegistries();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		
	}
	

	
}

package com.serenity.biomesplus.init;



import com.serenity.biomesplus.world.biomes.BiomeSnow;
import com.serenity.biomesplus.world.biomes.BiomeBlackForest;
import com.serenity.biomesplus.world.biomes.BiomeDangerWoods;
import com.serenity.biomesplus.world.biomes.BiomeMagicForest;
import com.serenity.biomesplus.world.biomes.BiomeOvergrown;


import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiome
{
	public static final Biome OVERGROWN = new BiomeOvergrown(false, (new Biome.BiomeProperties("Overgrown")).setTemperature(0.95F).setRainfall(50.0F));
	public static final Biome MAGIC_FOREST = new BiomeMagicForest(BiomeMagicForest.Type.BIRCH, (new Biome.BiomeProperties("Magical Forest")).setTemperature(0.6F).setRainfall(10.0F));
	public static final Biome SNOW_BIOME = new BiomeSnow(false, (new Biome.BiomeProperties("Snowy Plains")).setBaseHeight(0.125F).setHeightVariation(0.05F).setTemperature(-5.8F).setRainfall(0.4F).setSnowEnabled());
	public static final Biome DANGER_WOODS = new BiomeDangerWoods(BiomeTaiga.Type.NORMAL, (new Biome.BiomeProperties("Danger Woods")).setBaseHeight(0.2F).setHeightVariation(0.2F).setTemperature(0.25F).setRainfall(0.8F));
	public static final Biome BLACK_FOREST = new BiomeBlackForest(BiomeMagicForest.Type.BIRCH, (new Biome.BiomeProperties("Black Forest")).setTemperature(0.6F).setRainfall(10.0F));
	
	public static void registerBiomes()
	{
		modBiome(OVERGROWN, "Overgrown", BiomeType.WARM, Type.LUSH, Type.JUNGLE);
		modBiome(MAGIC_FOREST, "Magical Forest", BiomeType.WARM, Type.FOREST, Type.MAGICAL);
		modBiome(SNOW_BIOME, "Snowy Plains", BiomeType.WARM, Type.PLAINS, Type.DRY);
		modBiome(DANGER_WOODS, "Danger Woods", BiomeType.WARM, Type.DRY, Type.DEAD);
		modBiome(BLACK_FOREST, "Black Forest", BiomeType.WARM, Type.FOREST, Type.MAGICAL);
	}

	

	private static Biome modBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		System.out.println("*Biome Registered*");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		System.out.println("*Biome Added*");
		return biome;
	}
}
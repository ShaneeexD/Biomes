package com.serenity.biomesplus.util.handlers;

import java.io.File;

import com.serenity.biomesplus.Main;
import com.serenity.biomesplus.util.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConfigHandler 
{
	public static Configuration config;
	
	//public static int REEDS_PER_CHUNK = 1;
	
	
	
	public static void init(File file)
	{
		config = new Configuration(file);
		
		String category1;
		
		category1 = "";
		config.addCustomCategoryComment(category1, "");


		
		config.save();
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID_CFG);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MOD_ID_CFG + ".cfg"));
	}
}
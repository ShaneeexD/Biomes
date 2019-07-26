package com.serenity.biomesplus.util.handlers;

import com.serenity.biomesplus.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation CUSTOM_VINDICATOR = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "vindicator"));
	public static final ResourceLocation VINDICATOR_HOUSE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "vindicator_house"));
	
	public static final ResourceLocation ARMOUR_SKELETON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "armour_skeleton"));
	public static final ResourceLocation SKELETON_BOSS = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "skeleton_boss"));

}

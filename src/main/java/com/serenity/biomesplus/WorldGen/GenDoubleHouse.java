package com.serenity.biomesplus.WorldGen;

import java.util.Map;
import java.util.Random;

import com.serenity.biomesplus.util.Reference;
import com.serenity.biomesplus.util.handlers.LootTableHandler;

import java.util.Map.Entry;


import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.LootTableList;

public class GenDoubleHouse extends WorldGenerator {
	 Random r2 =new Random();
	
  
    int r;
	@Override
	public boolean generate(World world, Random rand, BlockPos position) {
		WorldServer worldserver = (WorldServer) world;
		MinecraftServer minecraftserver = world.getMinecraftServer();
		TemplateManager templatemanager = worldserver.getStructureTemplateManager();
		Template template = templatemanager.getTemplate(minecraftserver, new ResourceLocation(Reference.MOD_ID+":double_house"));
		
		if(template == null)
		{
			System.out.println("NO STRUCTURE");
			return false;
		}
		
		if(ModWorldGenerator.canSpawnHere(template, worldserver, position)) {
			IBlockState iblockstate = world.getBlockState(position);
			world.notifyBlockUpdate(position, iblockstate, iblockstate, 3);
			
			
			
			PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE)
					.setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk((ChunkPos) null)
					.setReplacedBlock((Block) null).setIgnoreStructureBlock(false);
			template.getDataBlocks(position, placementsettings);
			template.addBlocksToWorld(world, position.add(0, 1, 0), placementsettings);
			// Get the tile entity at this position.
			
			
			 Map<BlockPos, String> map = template.getDataBlocks(position, placementsettings);
			 
		 

	         for (Entry<BlockPos, String> entry : map.entrySet())
	         {
	             if ("chest_loot".equals(entry.getValue()))
	             {
	                 BlockPos blockpos2 = entry.getKey();
	                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
	                 TileEntity tileentity = world.getTileEntity(blockpos2);

	                 if (tileentity instanceof TileEntityChest)
	                 {
	                     ((TileEntityChest)tileentity).setLootTable(LootTableHandler.VINDICATOR_HOUSE, rand.nextLong());
	                 }
	             }
	             
	             
	             if ("chest_kitchen".equals(entry.getValue()))
	             {
	                 BlockPos blockpos2 = entry.getKey();
	                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
	                 TileEntity tileentity = world.getTileEntity(blockpos2);

	                 if (tileentity instanceof TileEntityChest)
	                 {
	                     ((TileEntityChest)tileentity).setLootTable(LootTableList.CHESTS_SIMPLE_DUNGEON, rand.nextLong());
	                 }
	             }
	          

	             if ("furnace_kitchen".equals(entry.getValue()))
	             {
	                 BlockPos blockpos2 = entry.getKey();
	                 world.setBlockState(blockpos2.up(), Blocks.AIR.getDefaultState(), 3);
	                 TileEntity tileentity = world.getTileEntity(blockpos2);
	                 
	                 if (tileentity instanceof TileEntityFurnace)
	                 {
	                	 Random randItemAmount = new Random(); 
	                	 
	                	 int i  =1+r2.nextInt(1);
	                	 
	                	 for (int j=0;j<i;j++) {
	                		 
	                		
	                		 r = r2.nextInt(10);
	                		
	                		 ItemStack pot=null;
	                	 switch(r) {
	                	 case 0:{pot = new ItemStack(Items.COAL, randItemAmount.nextInt(64));}
	                	 break;
	                	 
	                	 case 1:{pot = new ItemStack(Items.BLAZE_ROD, randItemAmount.nextInt(64));}
	                	 break;
	                	 
	                	 case 2:{pot = new ItemStack(Items.PORKCHOP, randItemAmount.nextInt(64));}
	                	 break;
	                	 
	                	 case 3:{pot = new ItemStack(Items.BEEF, randItemAmount.nextInt(64));}
	                	 break;
	                	 
	                	 
	                	 case 4:{pot = new ItemStack(Items.STICK, randItemAmount.nextInt(64));}
	                	 break;
	                	 
	                	 case 5:{pot = new ItemStack(Blocks.AIR);}
	                	 break;
	                	 
	                	 case 6:{pot = new ItemStack(Blocks.AIR);}
	                	 break;
	                	 
	                	 case 7:{pot = new ItemStack(Blocks.AIR);}
	                	 break;
	                	 
	                	 case 8:{pot = new ItemStack(Blocks.AIR);}
	                	 break;
	                	 
	                	 case 9:{pot = new ItemStack(Blocks.AIR);}
	                	 break;
	                	 
	                	               	 	                	 	                	 	            
	                	 }
	                	 
	                	 ((TileEntityFurnace)tileentity).setInventorySlotContents(i,pot);
	                	 }
	                 }
	                
	                     
	                 }
	             }
	         
	     
			return true;
		}
		
		return false;
	}
	
	
	
	public void addLoot(World world) {
		
		
		
		
		
	}

}
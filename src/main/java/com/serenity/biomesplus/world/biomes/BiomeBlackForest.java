package com.serenity.biomesplus.world.biomes;

import java.util.Random;

import com.serenity.biomesplus.world.decorators.BiomeBlackForestDecorator;
import com.serenity.biomesplus.world.decorators.BiomeMagicForestDecorator;
import com.serenity.biomesplus.world.decorators.BiomeOvergrownDecorator;

import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import com.serenity.biomesplus.entity.monster.EntityArmourSkeleton;
import com.serenity.biomesplus.entity.monster.EntityArmourWitherSkeleton;

public class BiomeBlackForest extends Biome
{

    
    private final BiomeMagicForest.Type type;

    public BiomeBlackForest(BiomeMagicForest.Type typeIn, Biome.BiomeProperties properties)
    {
        super(properties);
        decorator = new BiomeBlackForestDecorator();
        
        this.type = typeIn;   
        
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		
     
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityArmourWitherSkeleton.class, 50, 3, 5));
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySpider.class, 50, 2, 2));
                                   
    }
       
    @Override
    public int getModdedBiomeGrassColor(int original)
    {
		return 4210752;
    	
    }
    
    public int getModdedBiomeSkyColor(int original)
    {
		return 000000;
    	
    }
    
    @Override
    public int getModdedBiomeFoliageColor(int original)
    {
    	return 4210752;
    }

  

       

	public WorldGenAbstractTree getRandomTreeFeature(Random rand)
    {
        return (WorldGenAbstractTree)(rand.nextInt(3) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE);
    }

  



   
    

    public Class <? extends Biome > getBiomeClass()
    {
        return BiomeMagicForest.class;
    }

    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos)
    {
        int i = super.getGrassColorAtPos(pos);
        return this.type == BiomeMagicForest.Type.ROOFED ? (i & 16711422) + 2634762 >> 1 : i;
    }

    public static enum Type
    {
        NORMAL,
        FLOWER,
        BIRCH,
        ROOFED;
    }
}
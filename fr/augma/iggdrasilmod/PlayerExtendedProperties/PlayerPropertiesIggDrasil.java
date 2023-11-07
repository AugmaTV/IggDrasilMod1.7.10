/*     */ package fr.augma.iggdrasilmod.PlayerExtendedProperties;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IExtendedEntityProperties;
/*     */ 
/*     */ public class PlayerPropertiesIggDrasil
/*     */   implements IExtendedEntityProperties
/*     */ {
/*     */   public static final String EXT_PROP_NAME = "ExtPropIgg";
/*     */   private final EntityPlayer PLAYER;
/*     */   public int strength;
/*     */   public int health;
/*     */   public int agility;
/*  18 */   public final int maxAgility = 20;
/*     */   public int chance;
/*     */   public int intelligence;
/*     */   public int wisdom;
/*     */   public int availablePoint;
/*     */   
/*     */   public PlayerPropertiesIggDrasil(EntityPlayer player) {
/*  25 */     this.PLAYER = player;
/*  26 */     this.strength = 0;
/*  27 */     this.health = 0;
/*  28 */     this.agility = 0;
/*  29 */     this.chance = 0;
/*  30 */     this.intelligence = 0;
/*  31 */     this.wisdom = 0;
/*  32 */     this.availablePoint = 0;
/*     */   }
/*     */   
/*     */   public static final void register(EntityPlayer player) {
/*  36 */     player.registerExtendedProperties("ExtPropIgg", new PlayerPropertiesIggDrasil(player));
/*     */   }
/*     */   
/*     */   public static final PlayerPropertiesIggDrasil get(EntityPlayer player) {
/*  40 */     return (PlayerPropertiesIggDrasil)player.getExtendedProperties("ExtPropIgg");
/*     */   }
/*     */   
/*     */   public static final boolean has(EntityPlayer player) {
/*  44 */     if (get(player) == null) return false; 
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public void set(PlayerPropertiesIggDrasil old) {
/*  49 */     this.strength = old.strength;
/*  50 */     this.health = old.health;
/*  51 */     this.agility = old.agility;
/*  52 */     this.chance = old.chance;
/*  53 */     this.intelligence = old.intelligence;
/*  54 */     this.wisdom = old.wisdom;
/*  55 */     this.availablePoint = old.availablePoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveNBTData(NBTTagCompound compound) {
/*  60 */     NBTTagCompound properties = new NBTTagCompound();
/*     */     
/*  62 */     properties.func_74768_a("force", this.strength);
/*  63 */     properties.func_74768_a("vie", this.health);
/*  64 */     properties.func_74768_a("agility", this.agility);
/*  65 */     properties.func_74768_a("chance", this.chance);
/*  66 */     properties.func_74768_a("intelligence", this.intelligence);
/*  67 */     properties.func_74768_a("sagesse", this.wisdom);
/*  68 */     properties.func_74768_a("availablePoint", this.availablePoint);
/*     */     
/*  70 */     compound.func_74782_a("ExtPropIgg", (NBTBase)properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadNBTData(NBTTagCompound compound) {
/*  75 */     compound = (NBTTagCompound)compound.func_74781_a("ExtPropIgg");
/*     */     
/*  77 */     this.strength = compound.func_74762_e("force");
/*  78 */     this.health = compound.func_74762_e("vie");
/*  79 */     this.agility = compound.func_74762_e("agility");
/*  80 */     this.chance = compound.func_74762_e("chance");
/*  81 */     this.intelligence = compound.func_74762_e("intelligence");
/*  82 */     this.wisdom = compound.func_74762_e("sagesse");
/*  83 */     this.availablePoint = compound.func_74762_e("availablePoint");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Entity entity, World world) {}
/*     */ 
/*     */   
/*     */   public boolean hasPoint() {
/*  92 */     if (this.availablePoint == 0) return false; 
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public void usePoint() {
/*  97 */     this.availablePoint--;
/*     */   }
/*     */   
/*     */   public void addPoint(int s) {
/* 101 */     this.availablePoint += s;
/*     */   }
/*     */   
/*     */   public void addStrength(int s) {
/* 105 */     this.strength += s;
/* 106 */     usePoint();
/*     */   }
/*     */   
/*     */   public void addHealth(int s) {
/* 110 */     this.health += s;
/* 111 */     usePoint();
/*     */   }
/*     */   
/*     */   public void addAgility(int s) {
/* 115 */     getClass(); if (this.agility != 20) {
/* 116 */       this.agility += s;
/* 117 */       usePoint();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addChance(int s) {
/* 122 */     this.chance += s;
/* 123 */     usePoint();
/*     */   }
/*     */   
/*     */   public void addIntelligence(int s) {
/* 127 */     this.intelligence += s;
/* 128 */     usePoint();
/*     */   }
/*     */   
/*     */   public void addWisdom(int s) {
/* 132 */     this.wisdom += s;
/* 133 */     usePoint();
/*     */   }
/*     */   
/*     */   public int sumsOfAll() {
/* 137 */     return this.strength + this.health + this.agility + this.chance + this.intelligence + this.wisdom;
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\PlayerExtendedProperties\PlayerPropertiesIggDrasil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
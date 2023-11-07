/*     */ package fr.augma.iggdrasilmod.PlayerExtendedProperties;
/*     */ 
/*     */ import fr.augma.iggdrasilmod.event.PlayerEventHandlerServer;
/*     */ import fr.augma.iggdrasilmod.utils.Classes;
/*     */ import fr.json.simple.JSONObject;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IExtendedEntityProperties;
/*     */ 
/*     */ 
/*     */ public class PlayerPropertiesIggDrasil
/*     */   implements IExtendedEntityProperties
/*     */ {
/*     */   public static final String EXT_PROP_NAME = "ExtPropIgg";
/*     */   private static FileWriter file;
/*     */   private final EntityPlayer PLAYER;
/*     */   public int strength;
/*     */   public int health;
/*     */   public int agility;
/*  25 */   public final int maxAgility = 20;
/*     */   public int chance;
/*     */   public int intelligence;
/*     */   public int wisdom;
/*     */   public int availablePoint;
/*     */   public Classes classe;
/*     */   public boolean isNew;
/*     */   
/*     */   public PlayerPropertiesIggDrasil(EntityPlayer player) {
/*  34 */     this.PLAYER = player;
/*  35 */     this.strength = 0;
/*  36 */     this.health = 0;
/*  37 */     this.agility = 0;
/*  38 */     this.chance = 0;
/*  39 */     this.intelligence = 0;
/*  40 */     this.wisdom = 0;
/*  41 */     this.availablePoint = 0;
/*  42 */     this.classe = null;
/*  43 */     this.isNew = true;
/*  44 */     refreshFile();
/*     */   }
/*     */   
/*     */   public static final void register(EntityPlayer player) {
/*  48 */     player.registerExtendedProperties("ExtPropIgg", new PlayerPropertiesIggDrasil(player));
/*     */   }
/*     */   
/*     */   public static final PlayerPropertiesIggDrasil get(EntityPlayer player) {
/*  52 */     return (PlayerPropertiesIggDrasil)player.getExtendedProperties("ExtPropIgg");
/*     */   }
/*     */   
/*     */   public static final boolean has(EntityPlayer player) {
/*  56 */     if (get(player) == null) return false; 
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public void set(PlayerPropertiesIggDrasil old) {
/*  61 */     this.strength = old.strength;
/*  62 */     this.health = old.health;
/*  63 */     this.agility = old.agility;
/*  64 */     this.chance = old.chance;
/*  65 */     this.intelligence = old.intelligence;
/*  66 */     this.wisdom = old.wisdom;
/*  67 */     this.availablePoint = old.availablePoint;
/*  68 */     this.classe = old.classe;
/*  69 */     this.isNew = old.isNew;
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveNBTData(NBTTagCompound compound) {
/*  74 */     NBTTagCompound properties = new NBTTagCompound();
/*     */     
/*  76 */     properties.func_74768_a("force", this.strength);
/*  77 */     properties.func_74768_a("vie", this.health);
/*  78 */     properties.func_74768_a("agility", this.agility);
/*  79 */     properties.func_74768_a("chance", this.chance);
/*  80 */     properties.func_74768_a("intelligence", this.intelligence);
/*  81 */     properties.func_74768_a("sagesse", this.wisdom);
/*  82 */     properties.func_74768_a("availablePoint", this.availablePoint);
/*  83 */     properties.func_74757_a("isnew", this.isNew);
/*     */     
/*  85 */     compound.func_74782_a("ExtPropIgg", (NBTBase)properties);
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadNBTData(NBTTagCompound compound) {
/*  90 */     compound = (NBTTagCompound)compound.func_74781_a("ExtPropIgg");
/*     */     
/*  92 */     this.strength = compound.func_74762_e("force");
/*  93 */     this.health = compound.func_74762_e("vie");
/*  94 */     this.agility = compound.func_74762_e("agility");
/*  95 */     this.chance = compound.func_74762_e("chance");
/*  96 */     this.intelligence = compound.func_74762_e("intelligence");
/*  97 */     this.wisdom = compound.func_74762_e("sagesse");
/*  98 */     this.availablePoint = compound.func_74762_e("availablePoint");
/*  99 */     this.isNew = compound.func_74767_n("isnew");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Entity entity, World world) {}
/*     */ 
/*     */   
/*     */   public boolean isNew() {
/* 108 */     return this.isNew;
/*     */   }
/*     */   
/*     */   public void New() {
/* 112 */     if (this.isNew) this.isNew = !this.isNew; 
/*     */   }
/*     */   
/*     */   public void setClasses(Classes classe) {
/* 116 */     this.classe = classe;
/* 117 */     refreshFile();
/*     */   }
/*     */   
/*     */   public Classes getClasses() {
/* 121 */     return this.classe;
/*     */   }
/*     */   
/*     */   public boolean hasPoint() {
/* 125 */     if (this.availablePoint == 0) return false; 
/* 126 */     return true;
/*     */   }
/*     */   
/*     */   public void usePoint() {
/* 130 */     this.availablePoint--;
/* 131 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void addPoint(int s) {
/* 135 */     this.availablePoint += s;
/* 136 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void addStrength(int s) {
/* 140 */     this.strength += s;
/* 141 */     usePoint();
/* 142 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void addHealth(int s) {
/* 146 */     this.health += s;
/* 147 */     usePoint();
/* 148 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void addAgility(int s) {
/* 152 */     getClass(); if (this.agility != 20) {
/* 153 */       this.agility += s;
/* 154 */       usePoint();
/* 155 */       refreshFile();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addChance(int s) {
/* 160 */     this.chance += s;
/* 161 */     usePoint();
/* 162 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void addIntelligence(int s) {
/* 166 */     this.intelligence += s;
/* 167 */     usePoint();
/* 168 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void addWisdom(int s) {
/* 172 */     this.wisdom += s;
/* 173 */     usePoint();
/* 174 */     refreshFile();
/*     */   }
/*     */   
/*     */   public void reset() {
/* 178 */     this.availablePoint += sumsOfAll();
/* 179 */     this.agility = 0;
/* 180 */     this.chance = 0;
/* 181 */     this.health = 0;
/* 182 */     this.intelligence = 0;
/* 183 */     this.strength = 0;
/* 184 */     this.wisdom = 0;
/* 185 */     refreshFile();
/* 186 */     PlayerEventHandlerServer.refreshHealth(this.PLAYER);
/* 187 */     PlayerEventHandlerServer.refreshStrength(this.PLAYER);
/* 188 */     PlayerEventHandlerServer.refreshSpeed(this.PLAYER);
/*     */   }
/*     */   
/*     */   public int sumsOfAll() {
/* 192 */     return this.strength + this.health + this.agility + this.chance + this.intelligence + this.wisdom;
/*     */   }
/*     */   
/*     */   private void refreshFile() {
/* 196 */     JSONObject obj = new JSONObject();
/* 197 */     if (this.classe != null) {
/* 198 */       obj.put("classe", this.classe.name());
/*     */     } else {
/* 200 */       obj.put("classe", "aucune");
/*     */     } 
/*     */     
/* 203 */     JSONObject objSkills = new JSONObject();
/* 204 */     objSkills.put("force", Integer.valueOf(this.strength));
/* 205 */     objSkills.put("vie", Integer.valueOf(this.health));
/* 206 */     objSkills.put("agility", Integer.valueOf(this.agility));
/* 207 */     objSkills.put("chance", Integer.valueOf(this.chance));
/* 208 */     objSkills.put("intelligence", Integer.valueOf(this.intelligence));
/* 209 */     objSkills.put("sagesse", Integer.valueOf(this.wisdom));
/* 210 */     obj.put("skills", objSkills);
/*     */     
/*     */     try {
/* 213 */       file = new FileWriter("config/IDM/playerdata/" + this.PLAYER.func_110124_au() + ".json");
/* 214 */       file.write(obj.toJSONString());
/* 215 */     } catch (IOException e) {
/* 216 */       e.printStackTrace();
/*     */     } finally {
/*     */       
/*     */       try {
/* 220 */         file.flush();
/* 221 */         file.close();
/* 222 */       } catch (IOException e) {
/* 223 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\PlayerExtendedProperties\PlayerPropertiesIggDrasil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
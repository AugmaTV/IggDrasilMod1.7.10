/*     */ package fr.augma.iggdrasilmod.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import net.minecraftforge.common.config.ConfigCategory;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ 
/*     */ 
/*     */ public class ConfigBase
/*     */ {
/*     */   public static Configuration config;
/*     */   private static String filePath;
/*     */   
/*     */   public ConfigBase(String fileName) {
/*  14 */     filePath = "config/" + fileName + ".cfg";
/*  15 */     config = new Configuration(new File(filePath));
/*     */   }
/*     */   
/*     */   public Configuration getConfigFile() {
/*  19 */     return config;
/*     */   }
/*     */   
/*     */   public static void removeConfig(String category) {
/*  23 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  25 */       config.load();
/*  26 */       if (config.hasCategory(category))
/*  27 */         config.removeCategory(new ConfigCategory(category)); 
/*  28 */     } catch (Exception e) {
/*  29 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  31 */       config.save();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeConfig(String category, String key) {
/*  39 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  41 */       config.load();
/*  42 */       if (config.getCategory(category).containsKey(key))
/*  43 */         config.getCategory(category).remove(key); 
/*  44 */     } catch (Exception e) {
/*  45 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  47 */       config.save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean getBoolean(String category, String key) {
/*  52 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  54 */       config.load();
/*  55 */       if (config.getCategory(category).containsKey(key))
/*  56 */         return config.get(category, key, false).getBoolean(); 
/*  57 */     } catch (Exception e) {
/*  58 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  60 */       config.save();
/*     */     } 
/*  62 */     return false;
/*     */   }
/*     */   
/*     */   public static void writeConfig(String category, String key, boolean value) {
/*  66 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  68 */       config.load();
/*  69 */       config.getCategory(category).get(key).set(value);
/*  70 */     } catch (Exception e) {
/*  71 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  73 */       config.save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean hasCategory(String category) {
/*  78 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  80 */       config.load();
/*  81 */       return config.hasCategory(category);
/*  82 */     } catch (Exception e) {
/*  83 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  85 */       config.save();
/*     */     } 
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean hasKey(String category, String key) {
/*  91 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  93 */       config.load();
/*  94 */       if (!config.hasCategory(category))
/*  95 */         return false; 
/*  96 */       return config.getCategory(category).containsKey(key);
/*  97 */     } catch (Exception e) {
/*  98 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/* 100 */       config.save();
/*     */     } 
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\config\ConfigBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
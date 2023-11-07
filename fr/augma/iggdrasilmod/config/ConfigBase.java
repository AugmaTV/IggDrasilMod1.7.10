/*     */ package fr.augma.iggdrasilmod.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import net.minecraftforge.common.config.ConfigCategory;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConfigBase
/*     */ {
/*     */   public static Configuration config;
/*     */   private static String filePath;
/*     */   
/*     */   public ConfigBase(String fileName) {
/*  17 */     filePath = "config/" + fileName + ".cfg";
/*  18 */     config = new Configuration(new File(filePath));
/*     */   }
/*     */   
/*     */   public Configuration getConfigFile() {
/*  22 */     return config;
/*     */   }
/*     */   
/*     */   public static void removeConfig(String category) {
/*  26 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  28 */       config.load();
/*  29 */       if (config.hasCategory(category))
/*  30 */         config.removeCategory(new ConfigCategory(category)); 
/*  31 */     } catch (Exception e) {
/*  32 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  34 */       config.save();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeConfig(String category, String key) {
/*  42 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  44 */       config.load();
/*  45 */       if (config.getCategory(category).containsKey(key))
/*  46 */         config.getCategory(category).remove(key); 
/*  47 */     } catch (Exception e) {
/*  48 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  50 */       config.save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean getBoolean(String category, String key) {
/*  55 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  57 */       config.load();
/*  58 */       if (config.getCategory(category).containsKey(key))
/*  59 */         return config.get(category, key, false).getBoolean(); 
/*  60 */     } catch (Exception e) {
/*  61 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  63 */       config.save();
/*     */     } 
/*  65 */     return false;
/*     */   }
/*     */   
/*     */   public static void writeConfig(String category, String key, boolean value) {
/*  69 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  71 */       config.load();
/*  72 */       boolean set = config.get(category, key, value).getBoolean();
/*  73 */       config.getCategory(category).get(key).set(value);
/*  74 */     } catch (Exception e) {
/*  75 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  77 */       config.save();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static boolean hasCategory(String category) {
/*  82 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  84 */       config.load();
/*  85 */       return config.hasCategory(category);
/*  86 */     } catch (Exception e) {
/*  87 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/*  89 */       config.save();
/*     */     } 
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean hasKey(String category, String key) {
/*  95 */     config = new Configuration(new File(filePath));
/*     */     try {
/*  97 */       config.load();
/*  98 */       if (!config.hasCategory(category))
/*  99 */         return false; 
/* 100 */       return config.getCategory(category).containsKey(key);
/* 101 */     } catch (Exception e) {
/* 102 */       System.out.println("Cannot load configuration file!");
/*     */     } finally {
/* 104 */       config.save();
/*     */     } 
/* 106 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\config\ConfigBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
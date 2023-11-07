/*    */ package fr.augma.iggdrasilmod.utils;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ 
/*    */ 
/*    */ public class Classes
/*    */ {
/*    */   public String NAME;
/*    */   public String DESCRIPTION;
/*    */   public List<Classes> SUBCLASSES;
/*    */   public PotionEffect EFFECT;
/*    */   
/*    */   public Classes(String name, String description, List<Classes> subclasses, PotionEffect effect) {
/* 15 */     this.NAME = name;
/* 16 */     this.DESCRIPTION = description;
/* 17 */     this.SUBCLASSES = subclasses;
/* 18 */     this.EFFECT = effect;
/*    */   }
/*    */   
/*    */   public String name() {
/* 22 */     return this.NAME;
/*    */   }
/*    */   
/*    */   public void name(String name) {
/* 26 */     this.NAME = name;
/*    */   }
/*    */   
/*    */   public String description() {
/* 30 */     return this.DESCRIPTION;
/*    */   }
/*    */   
/*    */   public void description(String description) {
/* 34 */     this.DESCRIPTION = description;
/*    */   }
/*    */   
/*    */   public List<Classes> subClasses() {
/* 38 */     return this.SUBCLASSES;
/*    */   }
/*    */   
/*    */   public void subClasses(List<Classes> subclasses) {
/* 42 */     this.SUBCLASSES = subclasses;
/*    */   }
/*    */   
/*    */   public PotionEffect effect() {
/* 46 */     return this.EFFECT;
/*    */   }
/*    */   
/*    */   public void effect(PotionEffect effect) {
/* 50 */     this.EFFECT = effect;
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmo\\utils\Classes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
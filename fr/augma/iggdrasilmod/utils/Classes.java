/*    */ package fr.augma.iggdrasilmod.utils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Classes
/*    */ {
/*    */   public String NAME;
/*    */   public String[] DESCRIPTION;
/*    */   public Classes[] SUBCLASSES;
/*    */   
/*    */   public Classes(String name, String[] description, Classes[] subclasses) {
/* 14 */     this.NAME = name;
/* 15 */     this.DESCRIPTION = description;
/* 16 */     this.SUBCLASSES = subclasses;
/*    */   }
/*    */   
/*    */   public String name() {
/* 20 */     return this.NAME;
/*    */   }
/*    */   
/*    */   public void name(String name) {
/* 24 */     this.NAME = name;
/*    */   }
/*    */   
/*    */   public String[] description() {
/* 28 */     return this.DESCRIPTION;
/*    */   }
/*    */   
/*    */   public void description(String[] description) {
/* 32 */     this.DESCRIPTION = description;
/*    */   }
/*    */   
/*    */   public Classes[] subClasses() {
/* 36 */     return this.SUBCLASSES;
/*    */   }
/*    */   
/*    */   public void subClasses(Classes[] subclasses) {
/* 40 */     this.SUBCLASSES = subclasses;
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmo\\utils\Classes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
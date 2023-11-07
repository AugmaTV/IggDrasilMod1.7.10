/*    */ package fr.augma.iggdrasilmod.gui.screen;
/*    */ 
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseArcher;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseAssassin;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseBenediction;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseCauchemar;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseFaucheur;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseGuerrier;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseIngenieur;
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonClasseSamourai;
/*    */ import fr.augma.iggdrasilmod.utils.Classes;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class GuiClassesChoice
/*    */   extends GuiScreen
/*    */ {
/* 21 */   public static int GuiWidth = 300;
/* 22 */   public static int GuiHeight = 300;
/* 23 */   public static Classes classe = null;
/*    */   
/*    */   public GuiButton Button;
/*    */ 
/*    */   
/*    */   public void func_73863_a(int x, int y, float ticks) {
/* 29 */     int GuiX = (this.field_146294_l - 380) / 2;
/* 30 */     int GuiY = (this.field_146295_m - 250) / 2;
/* 31 */     func_146276_q_();
/* 32 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/gui_classe.png"));
/* 33 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, 380, 250, 128.0F, 128.0F);
/* 34 */     super.func_73863_a(x, y, ticks);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 44 */     this.field_146292_n.clear();
/* 45 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseGuerrier(1, 100, 70, 35, 35, "class_guerrier_icon.png"));
/* 46 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseAssassin(2, 145, 70, 35, 35, "class_assassin_icon.png"));
/* 47 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseArcher(3, 190, 70, 35, 35, "class_archer_icon.png"));
/* 48 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseSamourai(4, 100, 115, 35, 35, "class_samourai_icon.png"));
/* 49 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseFaucheur(5, 145, 115, 35, 35, "class_faucheur_icon.png"));
/* 50 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseIngenieur(6, 190, 115, 35, 35, "class_ingenieur_icon.png"));
/* 51 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseBenediction(7, 122, 160, 35, 35, "class_benediction_icon.png"));
/* 52 */     this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonClasseCauchemar(8, 166, 160, 35, 35, "class_cauchemar_icon.png"));
/* 53 */     super.func_73866_w_();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton btn) {
/* 58 */     switch (btn.field_146127_k) {
/*    */     
/*    */     } 
/*    */ 
/*    */     
/* 63 */     super.func_146284_a(btn);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\screen\GuiClassesChoice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
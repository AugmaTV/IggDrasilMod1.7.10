/*    */ package fr.augma.iggdrasilmod.gui.screen;
/*    */ 
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonCrossComunity;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ public class GuiStats
/*    */   extends GuiScreen
/*    */ {
/* 13 */   public static int GuiWidth = 300;
/* 14 */   public static int GuiHeight = 300;
/*    */   
/*    */   public GuiButton button;
/*    */ 
/*    */   
/*    */   public void func_73863_a(int x, int y, float ticks) {
/* 20 */     int GuiX = (this.field_146294_l - GuiWidth) / 2;
/* 21 */     int GuiY = (this.field_146295_m - GuiHeight) / 2;
/* 22 */     func_146276_q_();
/* 23 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/background_stats.png"));
/* 24 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, GuiWidth, GuiHeight, 128.0F, 128.0F);
/* 25 */     super.func_73863_a(x, y, ticks);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 30 */     this.field_146292_n.clear();
/* 31 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.38D), (int)(this.field_146295_m / 5.5D), 23, 23));
/* 32 */     super.func_73866_w_();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton button) {
/* 37 */     switch (button.field_146127_k) {
/*    */       case 0:
/* 39 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */     } 
/* 42 */     super.func_146284_a(button);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char c, int key) {
/* 47 */     switch (key) {
/*    */       case 18:
/* 49 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */     } 
/* 52 */     super.func_73869_a(c, key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\gui\screen\GuiStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package fr.augma.iggdrasilmod.gui.screen;
/*    */ 
/*    */ import fr.augma.iggdrasilmod.gui.button.GuiButtonCrossComunity;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiFriend
/*    */   extends GuiScreen
/*    */ {
/* 15 */   public static int GuiWidth = 300;
/* 16 */   public static int GuiHeight = 300;
/*    */   
/*    */   public GuiButton button;
/*    */   
/*    */   public void initFriend() {
/* 21 */     func_73731_b(this.field_146297_k.field_71466_p, "ma bite", 140, 110, 16777215);
/* 22 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/friend_disconnect.png"));
/* 23 */     Gui.func_152125_a(232, 105, 0.0F, 0.0F, 128, 128, 20, 17, 128.0F, 128.0F);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int x, int y, float ticks) {
/* 28 */     int GuiX = (this.field_146294_l - GuiWidth) / 2;
/* 29 */     int GuiY = (this.field_146295_m - GuiHeight) / 2;
/* 30 */     func_146276_q_();
/* 31 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/background_friend_listings.png"));
/* 32 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, GuiWidth, GuiHeight, 128.0F, 128.0F);
/* 33 */     initFriend();
/* 34 */     super.func_73863_a(x, y, ticks);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 39 */     this.field_146292_n.clear();
/* 40 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.38D), (int)(this.field_146295_m / 5.5D), 23, 23));
/* 41 */     super.func_73866_w_();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton button) {
/* 46 */     switch (button.field_146127_k) {
/*    */       case 0:
/* 48 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */     } 
/* 51 */     super.func_146284_a(button);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char c, int key) {
/* 56 */     switch (key) {
/*    */       case 18:
/* 58 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */     } 
/* 61 */     super.func_73869_a(c, key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\screen\GuiFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
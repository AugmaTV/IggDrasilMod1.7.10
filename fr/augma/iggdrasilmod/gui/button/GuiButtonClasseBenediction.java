/*    */ package fr.augma.iggdrasilmod.gui.button;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class GuiButtonClasseBenediction
/*    */   extends GuiButton {
/* 10 */   private static ResourceLocation BACKGROUND_TEXTURE = null;
/*    */   
/*    */   public GuiButtonClasseBenediction(int buttonId, int x, int y, int width, int height, String texture) {
/* 13 */     super(buttonId, x, y, "");
/* 14 */     this.field_146121_g = height;
/* 15 */     this.field_146120_f = width;
/* 16 */     this; BACKGROUND_TEXTURE = new ResourceLocation("idm", "textures/gui/" + texture);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int x, int y) {
/* 21 */     mc.func_110434_K().func_110577_a(BACKGROUND_TEXTURE);
/* 22 */     Gui.func_152125_a(this.field_146128_h, this.field_146129_i, 0.0F, 0.0F, 128, 128, this.field_146120_f, this.field_146121_g, 128.0F, 128.0F);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\button\GuiButtonClasseBenediction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
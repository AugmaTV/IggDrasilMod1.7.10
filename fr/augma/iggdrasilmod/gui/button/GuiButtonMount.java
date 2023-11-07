/*    */ package fr.augma.iggdrasilmod.gui.button;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ public class GuiButtonMount
/*    */   extends GuiButton
/*    */ {
/* 13 */   private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("idm", "textures/gui/monture_idle.png");
/* 14 */   private static final ResourceLocation BACKGROUND_TEXTURE_HOVER = new ResourceLocation("idm", "textures/gui/monture_hover.png");
/*    */   
/*    */   public GuiButtonMount(int buttonId, int x, int y, int width, int height) {
/* 17 */     super(buttonId, x, y, "");
/* 18 */     this.field_146121_g = height;
/* 19 */     this.field_146120_f = width;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int mouseX, int mouseY) {
/* 24 */     if (this.field_146125_m) {
/* 25 */       boolean mouseHover = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
/* 26 */       if (mouseHover) {
/* 27 */         mc.func_110434_K().func_110577_a(BACKGROUND_TEXTURE_HOVER);
/*    */       } else {
/* 29 */         mc.func_110434_K().func_110577_a(BACKGROUND_TEXTURE);
/*    */       } 
/* 31 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 32 */       Gui.func_152125_a(this.field_146128_h, this.field_146129_i, 0.0F, 0.0F, 128, 128, this.field_146120_f, this.field_146121_g, 128.0F, 128.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\gui\button\GuiButtonMount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package fr.augma.iggdrasilmod.gui.button;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class GuiButtonFriend
/*    */   extends GuiButton
/*    */ {
/* 12 */   private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation("idm", "textures/gui/friend_idle.png");
/* 13 */   private static final ResourceLocation BACKGROUND_TEXTURE_HOVER = new ResourceLocation("idm", "textures/gui/friend_hover.png");
/*    */   
/*    */   public GuiButtonFriend(int buttonId, int x, int y, int width, int height) {
/* 16 */     super(buttonId, x, y, "");
/* 17 */     this.field_146121_g = height;
/* 18 */     this.field_146120_f = width;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft mc, int mouseX, int mouseY) {
/* 23 */     if (this.field_146125_m) {
/* 24 */       boolean mouseHover = (mouseX >= this.field_146128_h && mouseY >= this.field_146129_i && mouseX < this.field_146128_h + this.field_146120_f && mouseY < this.field_146129_i + this.field_146121_g);
/* 25 */       if (mouseHover) {
/* 26 */         mc.func_110434_K().func_110577_a(BACKGROUND_TEXTURE_HOVER);
/*    */       } else {
/* 28 */         mc.func_110434_K().func_110577_a(BACKGROUND_TEXTURE);
/*    */       } 
/* 30 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 31 */       Gui.func_152125_a(this.field_146128_h, this.field_146129_i, 0.0F, 0.0F, 128, 128, this.field_146120_f, this.field_146121_g, 128.0F, 128.0F);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\gui\button\GuiButtonFriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
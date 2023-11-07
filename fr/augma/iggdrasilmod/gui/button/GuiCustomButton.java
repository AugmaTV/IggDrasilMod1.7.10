/*    */ package fr.augma.iggdrasilmod.gui.button;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiCustomButton
/*    */   extends GuiButton
/*    */ {
/* 17 */   private ResourceLocation button_texture = new ResourceLocation("idm", "textures/gui/button.png");
/*    */   
/*    */   public GuiCustomButton(int id, int x, int y, int width, int height, String text) {
/* 20 */     super(id, x, y, width, height, text);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_146112_a(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_) {
/* 26 */     if (this.field_146125_m) {
/*    */       
/* 28 */       FontRenderer fontrenderer = p_146112_1_.field_71466_p;
/* 29 */       p_146112_1_.func_110434_K().func_110577_a(this.button_texture);
/* 30 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 31 */       this.field_146123_n = (p_146112_2_ >= this.field_146128_h && p_146112_3_ >= this.field_146129_i && p_146112_2_ < this.field_146128_h + this.field_146120_f && p_146112_3_ < this.field_146129_i + this.field_146121_g);
/* 32 */       int k = func_146114_a(this.field_146123_n);
/* 33 */       GL11.glEnable(3042);
/* 34 */       OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 35 */       GL11.glBlendFunc(770, 771);
/* 36 */       func_73729_b(this.field_146128_h, this.field_146129_i, 0, 46 + k * 20, this.field_146120_f / 2, this.field_146121_g);
/* 37 */       func_73729_b(this.field_146128_h + this.field_146120_f / 2, this.field_146129_i, 200 - this.field_146120_f / 2, 46 + k * 20, this.field_146120_f / 2, this.field_146121_g);
/* 38 */       func_146119_b(p_146112_1_, p_146112_2_, p_146112_3_);
/* 39 */       int l = 14737632;
/*    */       
/* 41 */       if (this.packedFGColour != 0) {
/*    */         
/* 43 */         l = this.packedFGColour;
/*    */       }
/* 45 */       else if (!this.field_146124_l) {
/*    */         
/* 47 */         l = 10526880;
/*    */       }
/* 49 */       else if (this.field_146123_n) {
/*    */         
/* 51 */         l = 16777120;
/*    */       } 
/*    */       
/* 54 */       func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\button\GuiCustomButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
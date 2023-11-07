/*    */ package fr.augma.iggdrasilmod.gui.overlay;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import fr.augma.iggdrasilmod.common.IDMClient;
/*    */ import java.text.DecimalFormat;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiLifeBar
/*    */   extends Gui
/*    */ {
/* 19 */   final ResourceLocation bar = new ResourceLocation("idm", "textures/gui/life_bar.png");
/*    */   
/*    */   @SubscribeEvent
/*    */   public void renderOverlay(RenderGameOverlayEvent e) {
/* 23 */     if (e.type == RenderGameOverlayEvent.ElementType.TEXT) {
/* 24 */       String lifeInPercentage; Minecraft mc = Minecraft.func_71410_x();
/* 25 */       EntityClientPlayerMP entityClientPlayerMP = mc.field_71439_g;
/* 26 */       GL11.glPushMatrix();
/* 27 */       GL11.glScalef(1.1F, 1.1F, 1.1F);
/* 28 */       func_73731_b(mc.field_71466_p, entityClientPlayerMP.getDisplayName(), 70, 9, 16777215);
/* 29 */       GL11.glPopMatrix();
/* 30 */       GL11.glPushMatrix();
/* 31 */       GL11.glScalef(3.0F, 3.0F, 3.0F);
/* 32 */       func_73732_a(mc.field_71466_p, ((EntityPlayer)entityClientPlayerMP).field_71068_ca + "", 13, 7, 16777215);
/* 33 */       GL11.glPopMatrix();
/* 34 */       mc.field_71446_o.func_110577_a(this.bar);
/* 35 */       GL11.glPushMatrix();
/* 36 */       GL11.glScalef(0.8F, 0.8F, 0.8F);
/* 37 */       func_73729_b(1, 1, 0, 0, 256, 78);
/* 38 */       int scale = (int)(entityClientPlayerMP.func_110143_aJ() * 168.0F / entityClientPlayerMP.func_110138_aP());
/* 39 */       func_73729_b(81, 24, 81, 82, scale, 60);
/* 40 */       GL11.glPopMatrix();
/* 41 */       GL11.glPushMatrix();
/* 42 */       GL11.glScalef(1.1F, 1.1F, 1.1F);
/*    */       
/* 44 */       if (IDMClient.lifeType) {
/* 45 */         DecimalFormat df = new DecimalFormat();
/* 46 */         df.setMaximumFractionDigits(3);
/* 47 */         lifeInPercentage = df.format((entityClientPlayerMP.func_110143_aJ() * 100.0F / entityClientPlayerMP.func_110138_aP())) + " %";
/*    */       } else {
/* 49 */         lifeInPercentage = (int)entityClientPlayerMP.func_110143_aJ() + "/" + (int)entityClientPlayerMP.func_110138_aP();
/*    */       } 
/* 51 */       func_73731_b(mc.field_71466_p, lifeInPercentage, 110, 28, 16777215);
/* 52 */       GL11.glPopMatrix();
/* 53 */     } else if (e.type == RenderGameOverlayEvent.ElementType.HEALTH && 
/* 54 */       !e.isCanceled()) {
/* 55 */       e.setCanceled(true);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\gui\overlay\GuiLifeBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
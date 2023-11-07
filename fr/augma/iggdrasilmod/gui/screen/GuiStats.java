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
/*    */   public int strength;
/*    */   public int health;
/*    */   public int agility;
/*    */   public int chance;
/*    */   public int intelligence;
/*    */   public int wisdom;
/*    */   public int availablePoint;
/*    */   public String classe;
/*    */   
/*    */   public GuiStats(int[] stats, String classe) {
/* 28 */     this.strength = stats[0];
/* 29 */     this.health = stats[1];
/* 30 */     this.agility = stats[2];
/* 31 */     this.chance = stats[3];
/* 32 */     this.intelligence = stats[4];
/* 33 */     this.wisdom = stats[5];
/* 34 */     this.availablePoint = stats[6];
/* 35 */     this.classe = classe;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73863_a(int x, int y, float ticks) {
/* 40 */     int GuiX = (this.field_146294_l - GuiWidth) / 2;
/* 41 */     int GuiY = (this.field_146295_m - GuiHeight) / 2;
/* 42 */     func_146276_q_();
/* 43 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/background_stats.png"));
/* 44 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, GuiWidth, GuiHeight, 128.0F, 128.0F);
/* 45 */     drawValue();
/* 46 */     super.func_73863_a(x, y, ticks);
/*    */   }
/*    */   
/*    */   public void drawValue() {
/* 50 */     func_73731_b(this.field_146297_k.field_71466_p, this.health + "", 300, 80, 16777215);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_73866_w_() {
/* 55 */     this.field_146292_n.clear();
/* 56 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.38D), (int)(this.field_146295_m / 5.5D), 23, 23));
/* 57 */     super.func_73866_w_();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton button) {
/* 62 */     switch (button.field_146127_k) {
/*    */       case 0:
/* 64 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */     } 
/* 67 */     super.func_146284_a(button);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char c, int key) {
/* 72 */     switch (key) {
/*    */       case 18:
/* 74 */         this.field_146297_k.func_147108_a(null);
/*    */         break;
/*    */     } 
/* 77 */     super.func_73869_a(c, key);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\screen\GuiStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
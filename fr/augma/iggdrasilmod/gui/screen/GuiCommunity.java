/*     */ package fr.augma.iggdrasilmod.gui.screen;
/*     */ 
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import fr.augma.iggdrasilmod.IDMod;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonConfrerie;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonCrossComunity;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonFriend;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonMount;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonPersonnage;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonSkill;
/*     */ import fr.augma.iggdrasilmod.packet.PacketRequestSkills;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GuiCommunity
/*     */   extends GuiScreen
/*     */ {
/*  24 */   public static int GuiWidth = 300;
/*  25 */   public static int GuiHeight = 300;
/*     */   
/*     */   public GuiButton Button;
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float ticks) {
/*  31 */     int GuiX = (this.field_146294_l - GuiWidth) / 2;
/*  32 */     int GuiY = (this.field_146295_m - GuiHeight) / 2;
/*  33 */     func_146276_q_();
/*  34 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/background_comunity.png"));
/*  35 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, GuiWidth, GuiHeight, 128.0F, 128.0F);
/*  36 */     super.func_73863_a(x, y, ticks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  41 */     this.field_146292_n.clear();
/*  42 */     if (this.field_146297_k.field_71474_y.field_74335_Z == 0) {
/*  43 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonPersonnage(0, (int)(this.field_146294_l / 3.5D), (int)(this.field_146295_m / 2.55D), 65, 30));
/*  44 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonSkill(1, (int)(this.field_146294_l / 2.3D), (int)(this.field_146295_m / 2.55D), 60, 30));
/*  45 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonMount(2, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 2.55D), 60, 30));
/*  46 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonConfrerie(3, (int)(this.field_146294_l / 2.8D), (int)(this.field_146295_m / 1.8D), 60, 30));
/*  47 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonFriend(4, (int)(this.field_146294_l / 1.96D), (int)(this.field_146295_m / 1.8D), 60, 30));
/*  48 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonCrossComunity(5, (int)(this.field_146294_l / 1.38D), (int)(this.field_146295_m / 5.8D), 25, 25));
/*  49 */     } else if (this.field_146297_k.field_71474_y.field_74335_Z == 3) {
/*  50 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonPersonnage(0, this.field_146294_l / 3, (int)(this.field_146295_m / 2.4D), 65, 30));
/*  51 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonSkill(1, (int)(this.field_146294_l / 2.2D), (int)(this.field_146295_m / 2.4D), 60, 30));
/*  52 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonMount(2, (int)(this.field_146294_l / 1.77D), (int)(this.field_146295_m / 2.4D), 60, 30));
/*  53 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonConfrerie(3, (int)(this.field_146294_l / 2.55D), (int)(this.field_146295_m / 1.9D), 60, 30));
/*  54 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonFriend(4, (int)(this.field_146294_l / 1.96D), (int)(this.field_146295_m / 1.9D), 60, 30));
/*  55 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonCrossComunity(5, (int)(this.field_146294_l / 1.5D), (int)(this.field_146295_m / 4.12D), 25, 25));
/*  56 */     } else if (this.field_146297_k.field_71474_y.field_74335_Z == 2) {
/*  57 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonPersonnage(0, (int)(this.field_146294_l / 2.55D), (int)(this.field_146295_m / 2.28D), 65, 30));
/*  58 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonSkill(1, (int)(this.field_146294_l / 2.13D), (int)(this.field_146295_m / 2.28D), 60, 30));
/*  59 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonMount(2, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 2.28D), 60, 30));
/*  60 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonConfrerie(3, (int)(this.field_146294_l / 2.3D), (int)(this.field_146295_m / 1.95D), 60, 30));
/*  61 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonFriend(4, (int)(this.field_146294_l / 1.98D), (int)(this.field_146295_m / 1.95D), 60, 30));
/*  62 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonCrossComunity(5, (int)(this.field_146294_l / 1.63D), (int)(this.field_146295_m / 3.03D), 25, 25));
/*     */     } else {
/*  64 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonPersonnage(0, (int)(this.field_146294_l / 2.25D), (int)(this.field_146295_m / 2.15D), 65, 30));
/*  65 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonSkill(1, (int)(this.field_146294_l / 2.06D), (int)(this.field_146295_m / 2.15D), 60, 30));
/*  66 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonMount(2, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 2.15D), 60, 30));
/*  67 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonConfrerie(3, (int)(this.field_146294_l / 2.16D), (int)(this.field_146295_m / 1.95D), 60, 30));
/*  68 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonFriend(4, (int)(this.field_146294_l / 1.97D), (int)(this.field_146295_m / 1.95D), 60, 30));
/*  69 */       this.field_146292_n.add(this.Button = (GuiButton)new GuiButtonCrossComunity(5, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 2.42D), 25, 25));
/*     */     } 
/*  71 */     super.func_73866_w_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/*  76 */     switch (button.field_146127_k) {
/*     */ 
/*     */ 
/*     */       
/*     */       case 1:
/*  81 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 2:
/*  84 */         this.field_146297_k.func_147108_a(null);
/*  85 */         (Minecraft.func_71410_x()).field_71439_g.func_71165_d("/mount");
/*     */         break;
/*     */       case 3:
/*  88 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */       case 4:
/*  91 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */       case 5:
/*  94 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */     } 
/*  97 */     super.func_146284_a(button);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char c, int key) {
/* 102 */     switch (key) {
/*     */       case 18:
/* 104 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */     } 
/* 107 */     super.func_73869_a(c, key);
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\screen\GuiCommunity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
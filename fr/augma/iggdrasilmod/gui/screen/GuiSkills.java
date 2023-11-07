/*     */ package fr.augma.iggdrasilmod.gui.screen;
/*     */ 
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import fr.augma.iggdrasilmod.IDMod;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonAdd;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonCrossComunity;
/*     */ import fr.augma.iggdrasilmod.packet.PacketRequestSkills;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class GuiSkills
/*     */   extends GuiScreen
/*     */ {
/*  16 */   public static int GuiWidth = 250;
/*  17 */   public static int GuiHeight = 250;
/*     */   
/*     */   public GuiButton button;
/*     */   
/*     */   public int strength;
/*     */   public int health;
/*     */   public int agility;
/*     */   public int chance;
/*     */   public int intelligence;
/*     */   public int wisdom;
/*     */   public int availablePoint;
/*     */   public int maxAgility;
/*     */   
/*     */   public GuiSkills(int[] info) {
/*  31 */     this.strength = info[0];
/*  32 */     this.health = info[1];
/*  33 */     this.agility = info[2];
/*  34 */     this.chance = info[3];
/*  35 */     this.intelligence = info[4];
/*  36 */     this.wisdom = info[5];
/*  37 */     this.availablePoint = info[6];
/*  38 */     this.maxAgility = info[7];
/*     */   }
/*     */   
/*     */   public void drawSkillValue() {
/*  42 */     func_73731_b(this.field_146297_k.field_71466_p, this.health + "", 250, 70, 16777215);
/*  43 */     func_73731_b(this.field_146297_k.field_71466_p, this.agility + "", 250, 86, 16777215);
/*  44 */     if (this.maxAgility == this.agility)
/*  45 */       func_73731_b(this.field_146297_k.field_71466_p, "Maxed", (int)(this.field_146294_l / 1.75D), 86, 16777215); 
/*  46 */     func_73731_b(this.field_146297_k.field_71466_p, this.chance + "", 250, 103, 16777215);
/*  47 */     func_73731_b(this.field_146297_k.field_71466_p, this.strength + "", 250, 122, 16777215);
/*  48 */     func_73731_b(this.field_146297_k.field_71466_p, this.intelligence + "", 250, 140, 16777215);
/*  49 */     func_73731_b(this.field_146297_k.field_71466_p, this.wisdom + "", 250, 156, 16777215);
/*  50 */     func_73731_b(this.field_146297_k.field_71466_p, this.availablePoint + "", 270, 177, 16777215);
/*     */   }
/*     */   
/*     */   public void initButton() {
/*  54 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.61D), (int)(this.field_146295_m / 8.7D), 20, 20));
/*  55 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(1, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 3.9D), 15, 15));
/*  56 */     if (this.maxAgility != this.agility)
/*  57 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(2, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 3.105D), 15, 15)); 
/*  58 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(3, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 2.57D), 15, 15));
/*  59 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(4, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 2.16D), 15, 15));
/*  60 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(5, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 1.87D), 15, 15));
/*  61 */     this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(6, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 1.685D), 15, 15));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float ticks) {
/*  66 */     int GuiX = (this.field_146294_l - GuiWidth) / 2;
/*  67 */     int GuiY = (this.field_146295_m - GuiHeight) / 2;
/*  68 */     func_146276_q_();
/*  69 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/background_skills.png"));
/*  70 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, GuiWidth, GuiHeight, 128.0F, 128.0F);
/*  71 */     drawSkillValue();
/*  72 */     super.func_73863_a(x, y, ticks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/*  77 */     this.field_146292_n.clear();
/*  78 */     initButton();
/*  79 */     super.func_73866_w_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/*  84 */     switch (button.field_146127_k) {
/*     */       case 0:
/*  86 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */       case 1:
/*  89 */         if (this.availablePoint == 0)
/*  90 */           break;  this.field_146297_k.field_71439_g.func_71165_d("/addskill vitalite");
/*  91 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 2:
/*  94 */         if (this.availablePoint == 0 || 
/*  95 */           this.agility == 20)
/*  96 */           break;  this.field_146297_k.field_71439_g.func_71165_d("/addskill agilite");
/*  97 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 3:
/* 100 */         if (this.availablePoint == 0)
/* 101 */           break;  this.field_146297_k.field_71439_g.func_71165_d("/addskill chance");
/* 102 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 4:
/* 105 */         if (this.availablePoint == 0)
/* 106 */           break;  this.field_146297_k.field_71439_g.func_71165_d("/addskill force");
/* 107 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 5:
/* 110 */         if (this.availablePoint == 0)
/* 111 */           break;  this.field_146297_k.field_71439_g.func_71165_d("/addskill intelligence");
/* 112 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 6:
/* 115 */         if (this.availablePoint == 0)
/* 116 */           break;  this.field_146297_k.field_71439_g.func_71165_d("/addskill sagesse");
/* 117 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */     } 
/* 120 */     super.func_146284_a(button);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char c, int key) {
/* 125 */     switch (key) {
/*     */       case 18:
/* 127 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */     } 
/* 130 */     super.func_73869_a(c, key);
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\gui\screen\GuiSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package fr.augma.iggdrasilmod.gui.screen;
/*     */ 
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import fr.augma.iggdrasilmod.IDMod;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonAdd;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiButtonCrossComunity;
/*     */ import fr.augma.iggdrasilmod.packet.PacketRequestSkills;
/*     */ import fr.augma.iggdrasilmod.packet.PacketSkillUp;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class GuiSkills
/*     */   extends GuiScreen
/*     */ {
/*  17 */   public static int GuiWidth = 250;
/*  18 */   public static int GuiHeight = 250;
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
/*  32 */     this.strength = info[0];
/*  33 */     this.health = info[1];
/*  34 */     this.agility = info[2];
/*  35 */     this.chance = info[3];
/*  36 */     this.intelligence = info[4];
/*  37 */     this.wisdom = info[5];
/*  38 */     this.availablePoint = info[6];
/*  39 */     this.maxAgility = info[7];
/*     */   }
/*     */   
/*     */   public void drawSkillValue() {
/*  43 */     if (this.field_146297_k.field_71474_y.field_74335_Z == 0) {
/*  44 */       func_73731_b(this.field_146297_k.field_71466_p, this.health + "", 250, 70, 16777215);
/*  45 */       func_73731_b(this.field_146297_k.field_71466_p, this.agility + "", 250, 86, 16777215);
/*  46 */       if (this.maxAgility == this.agility)
/*  47 */         func_73731_b(this.field_146297_k.field_71466_p, "Maxed", (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 3.105D), 16777215); 
/*  48 */       func_73731_b(this.field_146297_k.field_71466_p, this.chance + "", 250, 103, 16777215);
/*  49 */       func_73731_b(this.field_146297_k.field_71466_p, this.strength + "", 250, 122, 16777215);
/*  50 */       func_73731_b(this.field_146297_k.field_71466_p, this.intelligence + "", 250, 140, 16777215);
/*  51 */       func_73731_b(this.field_146297_k.field_71466_p, this.wisdom + "", 250, 156, 16777215);
/*  52 */       func_73731_b(this.field_146297_k.field_71466_p, this.availablePoint + "", 270, 177, 16777215);
/*  53 */     } else if (this.field_146297_k.field_71474_y.field_74335_Z == 3) {
/*  54 */       func_73731_b(this.field_146297_k.field_71466_p, this.health + "", 330, 112, 16777215);
/*  55 */       func_73731_b(this.field_146297_k.field_71466_p, this.agility + "", 330, 129, 16777215);
/*  56 */       if (this.maxAgility == this.agility)
/*  57 */         func_73731_b(this.field_146297_k.field_71466_p, "Maxed", (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 2.629D), 16777215); 
/*  58 */       func_73731_b(this.field_146297_k.field_71466_p, this.chance + "", 330, 147, 16777215);
/*  59 */       func_73731_b(this.field_146297_k.field_71466_p, this.strength + "", 330, 166, 16777215);
/*  60 */       func_73731_b(this.field_146297_k.field_71466_p, this.intelligence + "", 330, 183, 16777215);
/*  61 */       func_73731_b(this.field_146297_k.field_71466_p, this.wisdom + "", 330, 199, 16777215);
/*  62 */       func_73731_b(this.field_146297_k.field_71466_p, this.availablePoint + "", 350, 219, 16777215);
/*  63 */     } else if (this.field_146297_k.field_71474_y.field_74335_Z == 2) {
/*  64 */       func_73731_b(this.field_146297_k.field_71466_p, this.health + "", 490, 198, 16777215);
/*  65 */       func_73731_b(this.field_146297_k.field_71466_p, this.agility + "", 490, 215, 16777215);
/*  66 */       if (this.maxAgility == this.agility)
/*  67 */         func_73731_b(this.field_146297_k.field_71466_p, "Maxed", (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 2.37D), 16777215); 
/*  68 */       func_73731_b(this.field_146297_k.field_71466_p, this.chance + "", 490, 233, 16777215);
/*  69 */       func_73731_b(this.field_146297_k.field_71466_p, this.strength + "", 490, 252, 16777215);
/*  70 */       func_73731_b(this.field_146297_k.field_71466_p, this.intelligence + "", 490, 268, 16777215);
/*  71 */       func_73731_b(this.field_146297_k.field_71466_p, this.wisdom + "", 490, 284, 16777215);
/*  72 */       func_73731_b(this.field_146297_k.field_71466_p, this.availablePoint + "", 510, 304, 16777215);
/*  73 */     } else if (this.field_146297_k.field_71474_y.field_74335_Z == 1) {
/*  74 */       func_73731_b(this.field_146297_k.field_71466_p, this.health + "", 980, 453, 16777215);
/*  75 */       func_73731_b(this.field_146297_k.field_71466_p, this.agility + "", 980, 470, 16777215);
/*  76 */       if (this.maxAgility == this.agility)
/*  77 */         func_73731_b(this.field_146297_k.field_71466_p, "Maxed", (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 2.16D), 16777215); 
/*  78 */       func_73731_b(this.field_146297_k.field_71466_p, this.chance + "", 980, 487, 16777215);
/*  79 */       func_73731_b(this.field_146297_k.field_71466_p, this.strength + "", 980, 504, 16777215);
/*  80 */       func_73731_b(this.field_146297_k.field_71466_p, this.intelligence + "", 980, 522, 16777215);
/*  81 */       func_73731_b(this.field_146297_k.field_71466_p, this.wisdom + "", 980, 539, 16777215);
/*  82 */       func_73731_b(this.field_146297_k.field_71466_p, this.availablePoint + "", 990, 558, 16777215);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void initButton() {
/*  87 */     if (this.field_146297_k.field_71474_y.field_74335_Z == 0) {
/*  88 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.61D), (int)(this.field_146295_m / 8.7D), 20, 20));
/*  89 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(1, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 3.9D), 15, 15));
/*  90 */       if (this.maxAgility != this.agility)
/*  91 */         this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(2, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 3.105D), 15, 15)); 
/*  92 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(3, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 2.57D), 15, 15));
/*  93 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(4, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 2.16D), 15, 15));
/*  94 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(5, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 1.87D), 15, 15));
/*  95 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(6, (int)(this.field_146294_l / 1.75D), (int)(this.field_146295_m / 1.685D), 15, 15));
/*     */     }
/*  97 */     else if (this.field_146297_k.field_71474_y.field_74335_Z == 3) {
/*  98 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.7D), (int)(this.field_146295_m / 4.9D), 20, 20));
/*  99 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(1, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 3.1D), 15, 15));
/* 100 */       if (this.maxAgility != this.agility)
/* 101 */         this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(2, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 2.629D), 15, 15)); 
/* 102 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(3, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 2.37D), 15, 15));
/* 103 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(4, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 2.09D), 15, 15));
/* 104 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(5, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 1.89D), 15, 15));
/* 105 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(6, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 1.729D), 15, 15));
/*     */     }
/* 107 */     else if (this.field_146297_k.field_71474_y.field_74335_Z == 2) {
/* 108 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.8D), (int)(this.field_146295_m / 3.28D), 20, 20));
/* 109 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(1, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 2.61D), 15, 15));
/* 110 */       if (this.maxAgility != this.agility)
/* 111 */         this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(2, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 2.37D), 15, 15)); 
/* 112 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(3, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 2.22D), 15, 15));
/* 113 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(4, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 2.04D), 15, 15));
/* 114 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(5, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 1.92D), 15, 15));
/* 115 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(6, (int)(this.field_146294_l / 1.85D), (int)(this.field_146295_m / 1.8D), 15, 15));
/*     */     }
/* 117 */     else if (this.field_146297_k.field_71474_y.field_74335_Z == 1) {
/* 118 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonCrossComunity(0, (int)(this.field_146294_l / 1.89D), (int)(this.field_146295_m / 2.47D), 20, 20));
/* 119 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(1, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 2.255D), 15, 15));
/* 120 */       if (this.maxAgility != this.agility)
/* 121 */         this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(2, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 2.175D), 15, 15)); 
/* 122 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(3, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 2.101D), 15, 15));
/* 123 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(4, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 2.03D), 15, 15));
/* 124 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(5, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 1.96D), 15, 15));
/* 125 */       this.field_146292_n.add(this.button = (GuiButton)new GuiButtonAdd(6, (int)(this.field_146294_l / 1.91D), (int)(this.field_146295_m / 1.9D), 15, 15));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float ticks) {
/* 131 */     int GuiX = (this.field_146294_l - GuiWidth) / 2;
/* 132 */     int GuiY = (this.field_146295_m - GuiHeight) / 2;
/* 133 */     func_146276_q_();
/* 134 */     this.field_146297_k.field_71446_o.func_110577_a(new ResourceLocation("idm", "textures/gui/background_skills.png"));
/* 135 */     Gui.func_152125_a(GuiX, GuiY, 0.0F, 0.0F, 128, 128, GuiWidth, GuiHeight, 128.0F, 128.0F);
/* 136 */     drawSkillValue();
/* 137 */     super.func_73863_a(x, y, ticks);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 142 */     this.field_146292_n.clear();
/* 143 */     initButton();
/* 144 */     super.func_73866_w_();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/* 149 */     switch (button.field_146127_k) {
/*     */       case 0:
/* 151 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */       case 1:
/* 154 */         if (this.availablePoint == 0)
/* 155 */           break;  IDMod.NETWORK.sendToServer((IMessage)new PacketSkillUp("vitalite"));
/* 156 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 2:
/* 159 */         if (this.availablePoint == 0 || 
/* 160 */           this.agility == 20)
/* 161 */           break;  IDMod.NETWORK.sendToServer((IMessage)new PacketSkillUp("agilite"));
/* 162 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 3:
/* 165 */         if (this.availablePoint == 0)
/* 166 */           break;  IDMod.NETWORK.sendToServer((IMessage)new PacketSkillUp("chance"));
/* 167 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 4:
/* 170 */         if (this.availablePoint == 0)
/* 171 */           break;  IDMod.NETWORK.sendToServer((IMessage)new PacketSkillUp("force"));
/* 172 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 5:
/* 175 */         if (this.availablePoint == 0)
/* 176 */           break;  IDMod.NETWORK.sendToServer((IMessage)new PacketSkillUp("intelligence"));
/* 177 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */       case 6:
/* 180 */         if (this.availablePoint == 0)
/* 181 */           break;  IDMod.NETWORK.sendToServer((IMessage)new PacketSkillUp("sagesse"));
/* 182 */         IDMod.NETWORK.sendToServer((IMessage)new PacketRequestSkills());
/*     */         break;
/*     */     } 
/* 185 */     super.func_146284_a(button);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char c, int key) {
/* 190 */     switch (key) {
/*     */       case 18:
/* 192 */         this.field_146297_k.func_147108_a(null);
/*     */         break;
/*     */     } 
/* 195 */     super.func_73869_a(c, key);
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\screen\GuiSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
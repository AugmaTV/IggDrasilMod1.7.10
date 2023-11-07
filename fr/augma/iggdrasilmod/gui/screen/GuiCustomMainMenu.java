/*     */ package fr.augma.iggdrasilmod.gui.screen;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import cpw.mods.fml.client.GuiModList;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import fr.augma.iggdrasilmod.gui.button.GuiCustomButton;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiConfirmOpenLink;
/*     */ import net.minecraft.client.gui.GuiLanguage;
/*     */ import net.minecraft.client.gui.GuiMultiplayer;
/*     */ import net.minecraft.client.gui.GuiOptions;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.gui.GuiSelectWorld;
/*     */ import net.minecraft.client.gui.GuiYesNo;
/*     */ import net.minecraft.client.gui.GuiYesNoCallback;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.DynamicTexture;
/*     */ import net.minecraft.client.resources.I18n;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.demo.DemoWorldServer;
/*     */ import net.minecraft.world.storage.ISaveFormat;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import org.apache.commons.io.Charsets;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GLContext;
/*     */ import org.lwjgl.util.glu.Project;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class GuiCustomMainMenu
/*     */   extends GuiScreen
/*     */   implements GuiYesNoCallback
/*     */ {
/*  53 */   private static final Logger logger = LogManager.getLogger();
/*     */   
/*  55 */   private static final Random rand = new Random();
/*     */   
/*     */   private float updateCounter;
/*     */   
/*     */   private String splashText;
/*     */   
/*     */   private GuiButton buttonResetDemo;
/*     */   
/*     */   private int panoramaTimer;
/*     */   
/*     */   private DynamicTexture viewportTexture;
/*     */   
/*  67 */   private final Object field_104025_t = new Object();
/*     */   private String field_92025_p;
/*     */   private String field_146972_A;
/*     */   private String field_104024_v;
/*  71 */   private static final ResourceLocation splashTexts = new ResourceLocation("texts/splashes.txt");
/*  72 */   private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");
/*  73 */   private static final ResourceLocation BACKGROUND = new ResourceLocation("idm", "textures/gui/background.jpg");
/*     */   
/*  75 */   private static final ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] { new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png") };
/*  76 */   public static final String field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
/*     */   
/*     */   private int field_92024_r;
/*     */   private int field_92023_s;
/*     */   private int field_92022_t;
/*     */   private int field_92021_u;
/*     */   private int field_92020_v;
/*     */   private int field_92019_w;
/*     */   private ResourceLocation field_110351_G;
/*     */   private static final String __OBFID = "CL_00001154";
/*     */   
/*     */   public GuiCustomMainMenu() {
/*  88 */     this.field_146972_A = field_96138_a;
/*  89 */     this.splashText = "missingno";
/*  90 */     BufferedReader bufferedreader = null;
/*     */ 
/*     */     
/*     */     try {
/*  94 */       ArrayList<String> arraylist = new ArrayList();
/*  95 */       bufferedreader = new BufferedReader(new InputStreamReader(Minecraft.func_71410_x().func_110442_L().func_110536_a(splashTexts).func_110527_b(), Charsets.UTF_8));
/*     */       
/*     */       String s;
/*  98 */       while ((s = bufferedreader.readLine()) != null) {
/*     */         
/* 100 */         s = s.trim();
/*     */         
/* 102 */         if (!s.isEmpty())
/*     */         {
/* 104 */           arraylist.add(s);
/*     */         }
/*     */       } 
/*     */       
/* 108 */       if (!arraylist.isEmpty()) {
/*     */         do
/*     */         {
/*     */           
/* 112 */           this.splashText = arraylist.get(rand.nextInt(arraylist.size()));
/*     */         }
/* 114 */         while (this.splashText.hashCode() == 125780783);
/*     */       }
/*     */     }
/* 117 */     catch (IOException iOException) {
/*     */ 
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/* 123 */       if (bufferedreader != null) {
/*     */         
/*     */         try {
/*     */           
/* 127 */           bufferedreader.close();
/*     */         }
/* 129 */         catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     this.updateCounter = rand.nextFloat();
/* 137 */     this.field_92025_p = "";
/*     */     
/* 139 */     if (!(GLContext.getCapabilities()).OpenGL20 && !OpenGlHelper.func_153193_b()) {
/*     */       
/* 141 */       this.field_92025_p = I18n.func_135052_a("title.oldgl1", new Object[0]);
/* 142 */       this.field_146972_A = I18n.func_135052_a("title.oldgl2", new Object[0]);
/* 143 */       this.field_104024_v = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 152 */     this.panoramaTimer++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 160 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73866_w_() {
/* 174 */     this.viewportTexture = new DynamicTexture(256, 256);
/* 175 */     this.field_110351_G = this.field_146297_k.func_110434_K().func_110578_a("background", this.viewportTexture);
/* 176 */     Calendar calendar = Calendar.getInstance();
/* 177 */     calendar.setTime(new Date());
/*     */     
/* 179 */     if (calendar.get(2) + 1 == 11 && calendar.get(5) == 9) {
/*     */       
/* 181 */       this.splashText = "Happy birthday, ez!";
/*     */     }
/* 183 */     else if (calendar.get(2) + 1 == 6 && calendar.get(5) == 1) {
/*     */       
/* 185 */       this.splashText = "Happy birthday, Notch!";
/*     */     }
/* 187 */     else if (calendar.get(2) + 1 == 12 && calendar.get(5) == 24) {
/*     */       
/* 189 */       this.splashText = "Merry X-mas!";
/*     */     }
/* 191 */     else if (calendar.get(2) + 1 == 1 && calendar.get(5) == 1) {
/*     */       
/* 193 */       this.splashText = "Happy new year!";
/*     */     }
/* 195 */     else if (calendar.get(2) + 1 == 10 && calendar.get(5) == 31) {
/*     */       
/* 197 */       this.splashText = "OOoooOOOoooo! Spooky!";
/*     */     } 
/*     */     
/* 200 */     boolean flag = true;
/* 201 */     int i = this.field_146295_m / 4 + 48;
/*     */     
/* 203 */     if (this.field_146297_k.func_71355_q()) {
/*     */       
/* 205 */       addDemoButtons(i, 24);
/*     */     }
/*     */     else {
/*     */       
/* 209 */       addSingleplayerMultiplayerButtons(i, 24);
/*     */     } 
/*     */     
/* 212 */     this.field_146292_n.add(new GuiCustomButton(0, this.field_146294_l / 4 - 100, i + 76, 88, 20, I18n.func_135052_a("menu.options", new Object[0])));
/* 213 */     this.field_146292_n.add(new GuiCustomButton(4, this.field_146294_l / 4 + 2, i + 76, 88, 20, I18n.func_135052_a("menu.quit", new Object[0])));
/*     */     
/* 215 */     Object object = this.field_104025_t;
/*     */     
/* 217 */     synchronized (this.field_104025_t) {
/*     */       
/* 219 */       this.field_92023_s = this.field_146289_q.func_78256_a(this.field_92025_p);
/* 220 */       this.field_92024_r = this.field_146289_q.func_78256_a(this.field_146972_A);
/* 221 */       int j = Math.max(this.field_92023_s, this.field_92024_r);
/* 222 */       this.field_92022_t = (this.field_146294_l - j) / 2;
/* 223 */       this.field_92021_u = ((GuiButton)this.field_146292_n.get(0)).field_146129_i - 24;
/* 224 */       this.field_92020_v = this.field_92022_t + j;
/* 225 */       this.field_92019_w = this.field_92021_u + 24;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addSingleplayerMultiplayerButtons(int x, int y) {
/* 236 */     this.field_146292_n.add(new GuiCustomButton(20, this.field_146294_l / 4 - 100, this.field_146295_m / 5 + 24 + 24, 190, 20, "IggDrasil France"));
/* 237 */     this.field_146292_n.add(new GuiCustomButton(23, this.field_146294_l / 4 - 100, this.field_146295_m / 5 + 48 + 24, 190, 20, "IggDrasil Staff"));
/* 238 */     this.field_146292_n.add(new GuiCustomButton(21, this.field_146294_l / 4 - 100, this.field_146295_m / 5 + 72 + 24, 88, 20, "Site D'IggDrasil"));
/* 239 */     this.field_146292_n.add(new GuiCustomButton(22, this.field_146294_l / 4 + 2, this.field_146295_m / 5 + 72 + 24, 88, 20, "Discord"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void addDemoButtons(int x, int y) {
/* 247 */     this.field_146292_n.add(new GuiButton(11, this.field_146294_l / 2 - 100, x, I18n.func_135052_a("menu.playdemo", new Object[0])));
/* 248 */     this.field_146292_n.add(this.buttonResetDemo = new GuiButton(12, this.field_146294_l / 2 - 100, x + y * 1, I18n.func_135052_a("menu.resetdemo", new Object[0])));
/* 249 */     ISaveFormat isaveformat = this.field_146297_k.func_71359_d();
/* 250 */     WorldInfo worldinfo = isaveformat.func_75803_c("Demo_World");
/*     */     
/* 252 */     if (worldinfo == null)
/*     */     {
/* 254 */       this.buttonResetDemo.field_146124_l = false;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/* 260 */     if (button.field_146127_k == 0)
/*     */     {
/* 262 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiOptions(this, this.field_146297_k.field_71474_y));
/*     */     }
/*     */     
/* 265 */     if (button.field_146127_k == 5)
/*     */     {
/* 267 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiLanguage(this, this.field_146297_k.field_71474_y, this.field_146297_k.func_135016_M()));
/*     */     }
/*     */     
/* 270 */     if (button.field_146127_k == 1)
/*     */     {
/* 272 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiSelectWorld(this));
/*     */     }
/*     */     
/* 275 */     if (button.field_146127_k == 2)
/*     */     {
/* 277 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiMultiplayer(this));
/*     */     }
/*     */     
/* 280 */     if (button.field_146127_k == 4)
/*     */     {
/* 282 */       this.field_146297_k.func_71400_g();
/*     */     }
/*     */     
/* 285 */     if (button.field_146127_k == 6)
/*     */     {
/* 287 */       this.field_146297_k.func_147108_a((GuiScreen)new GuiModList(this));
/*     */     }
/*     */     
/* 290 */     if (button.field_146127_k == 11)
/*     */     {
/* 292 */       this.field_146297_k.func_71371_a("Demo_World", "Demo_World", DemoWorldServer.field_73071_a);
/*     */     }
/*     */     
/* 295 */     if (button.field_146127_k == 12) {
/*     */       
/* 297 */       ISaveFormat isaveformat = this.field_146297_k.func_71359_d();
/* 298 */       WorldInfo worldinfo = isaveformat.func_75803_c("Demo_World");
/*     */       
/* 300 */       if (worldinfo != null) {
/*     */         
/* 302 */         GuiYesNo guiyesno = GuiSelectWorld.func_152129_a(this, worldinfo.func_76065_j(), 12);
/* 303 */         this.field_146297_k.func_147108_a((GuiScreen)guiyesno);
/*     */       } 
/*     */     } 
/*     */     
/* 307 */     if (button.field_146127_k == 20)
/*     */     {
/* 309 */       FMLClientHandler.instance().connectToServerAtStartup("178.63.206.98", 10007);
/*     */     }
/*     */     
/* 312 */     if (button.field_146127_k == 23)
/*     */     {
/* 314 */       FMLClientHandler.instance().connectToServerAtStartup("178.63.206.98", 20032);
/*     */     }
/*     */     
/* 317 */     if (button.field_146127_k == 21);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 331 */     if (button.field_146127_k == 22) {
/*     */       
/*     */       try {
/*     */         
/* 335 */         Class<?> oclass = Class.forName("java.awt.Desktop");
/* 336 */         Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 337 */         oclass.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { new URI("https://discord.gg/pfaBGh2") });
/*     */       }
/* 339 */       catch (Throwable throwable) {
/*     */         
/* 341 */         logger.error("Couldn't open link", throwable);
/*     */       } 
/*     */     }
/*     */     
/* 345 */     if (button.field_146127_k == 20);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73878_a(boolean p_73878_1_, int id) {
/* 354 */     if (p_73878_1_ && id == 12) {
/*     */       
/* 356 */       ISaveFormat isaveformat = this.field_146297_k.func_71359_d();
/* 357 */       isaveformat.func_75800_d();
/* 358 */       isaveformat.func_75802_e("Demo_World");
/* 359 */       this.field_146297_k.func_147108_a(this);
/*     */     }
/* 361 */     else if (id == 13) {
/*     */       
/* 363 */       if (p_73878_1_) {
/*     */         
/*     */         try {
/*     */           
/* 367 */           Class<?> oclass = Class.forName("java.awt.Desktop");
/* 368 */           Object object = oclass.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
/* 369 */           oclass.getMethod("browse", new Class[] { URI.class }).invoke(object, new Object[] { new URI(this.field_104024_v) });
/*     */         }
/* 371 */         catch (Throwable throwable) {
/*     */           
/* 373 */           logger.error("Couldn't open link", throwable);
/*     */         } 
/*     */       }
/*     */       
/* 377 */       this.field_146297_k.func_147108_a(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawPanorama(int x, int y, float partialTick) {
/* 386 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 387 */     GL11.glMatrixMode(5889);
/* 388 */     GL11.glPushMatrix();
/* 389 */     GL11.glLoadIdentity();
/* 390 */     Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
/* 391 */     GL11.glMatrixMode(5888);
/* 392 */     GL11.glPushMatrix();
/* 393 */     GL11.glLoadIdentity();
/* 394 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 395 */     GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
/* 396 */     GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
/* 397 */     GL11.glEnable(3042);
/* 398 */     GL11.glDisable(3008);
/* 399 */     GL11.glDisable(2884);
/* 400 */     GL11.glDepthMask(false);
/* 401 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 402 */     byte b0 = 8;
/*     */     
/* 404 */     for (int k = 0; k < b0 * b0; k++) {
/*     */       
/* 406 */       GL11.glPushMatrix();
/* 407 */       float f1 = ((k % b0) / b0 - 0.5F) / 64.0F;
/* 408 */       float f2 = ((k / b0) / b0 - 0.5F) / 64.0F;
/* 409 */       float f3 = 0.0F;
/* 410 */       GL11.glTranslatef(f1, f2, f3);
/* 411 */       GL11.glRotatef(MathHelper.func_76126_a((this.panoramaTimer + partialTick) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
/* 412 */       GL11.glRotatef(-(this.panoramaTimer + partialTick) * 0.1F, 0.0F, 1.0F, 0.0F);
/*     */       
/* 414 */       for (int l = 0; l < 6; l++) {
/*     */         
/* 416 */         GL11.glPushMatrix();
/*     */         
/* 418 */         if (l == 1)
/*     */         {
/* 420 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 423 */         if (l == 2)
/*     */         {
/* 425 */           GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 428 */         if (l == 3)
/*     */         {
/* 430 */           GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */         
/* 433 */         if (l == 4)
/*     */         {
/* 435 */           GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*     */         }
/*     */         
/* 438 */         if (l == 5)
/*     */         {
/* 440 */           GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/*     */         }
/*     */         
/* 443 */         this.field_146297_k.func_110434_K().func_110577_a(titlePanoramaPaths[l]);
/* 444 */         tessellator.func_78382_b();
/* 445 */         tessellator.func_78384_a(16777215, 255 / (k + 1));
/* 446 */         float f4 = 0.0F;
/* 447 */         tessellator.func_78374_a(-1.0D, -1.0D, 1.0D, (0.0F + f4), (0.0F + f4));
/* 448 */         tessellator.func_78374_a(1.0D, -1.0D, 1.0D, (1.0F - f4), (0.0F + f4));
/* 449 */         tessellator.func_78374_a(1.0D, 1.0D, 1.0D, (1.0F - f4), (1.0F - f4));
/* 450 */         tessellator.func_78374_a(-1.0D, 1.0D, 1.0D, (0.0F + f4), (1.0F - f4));
/* 451 */         tessellator.func_78381_a();
/* 452 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/* 455 */       GL11.glPopMatrix();
/* 456 */       GL11.glColorMask(true, true, true, false);
/*     */     } 
/*     */     
/* 459 */     tessellator.func_78373_b(0.0D, 0.0D, 0.0D);
/* 460 */     GL11.glColorMask(true, true, true, true);
/* 461 */     GL11.glMatrixMode(5889);
/* 462 */     GL11.glPopMatrix();
/* 463 */     GL11.glMatrixMode(5888);
/* 464 */     GL11.glPopMatrix();
/* 465 */     GL11.glDepthMask(true);
/* 466 */     GL11.glEnable(2884);
/* 467 */     GL11.glEnable(2929);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void rotateAndBlurSkybox(float partialTick) {
/* 475 */     this.field_146297_k.func_110434_K().func_110577_a(this.field_110351_G);
/* 476 */     GL11.glTexParameteri(3553, 10241, 9729);
/* 477 */     GL11.glTexParameteri(3553, 10240, 9729);
/* 478 */     GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
/* 479 */     GL11.glEnable(3042);
/* 480 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 481 */     GL11.glColorMask(true, true, true, false);
/* 482 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 483 */     tessellator.func_78382_b();
/* 484 */     GL11.glDisable(3008);
/* 485 */     byte b0 = 3;
/*     */     
/* 487 */     for (int i = 0; i < b0; i++) {
/*     */       
/* 489 */       tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F / (i + 1));
/* 490 */       int j = this.field_146294_l;
/* 491 */       int k = this.field_146295_m;
/* 492 */       float f1 = (i - b0 / 2) / 256.0F;
/* 493 */       tessellator.func_78374_a(j, k, this.field_73735_i, (0.0F + f1), 1.0D);
/* 494 */       tessellator.func_78374_a(j, 0.0D, this.field_73735_i, (1.0F + f1), 1.0D);
/* 495 */       tessellator.func_78374_a(0.0D, 0.0D, this.field_73735_i, (1.0F + f1), 0.0D);
/* 496 */       tessellator.func_78374_a(0.0D, k, this.field_73735_i, (0.0F + f1), 0.0D);
/*     */     } 
/*     */     
/* 499 */     tessellator.func_78381_a();
/* 500 */     GL11.glEnable(3008);
/* 501 */     GL11.glColorMask(true, true, true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderSkybox(int x, int y, float partialTick) {
/* 509 */     this.field_146297_k.func_147110_a().func_147609_e();
/* 510 */     GL11.glViewport(0, 0, 256, 256);
/* 511 */     drawPanorama(x, y, partialTick);
/* 512 */     rotateAndBlurSkybox(partialTick);
/* 513 */     rotateAndBlurSkybox(partialTick);
/* 514 */     rotateAndBlurSkybox(partialTick);
/* 515 */     rotateAndBlurSkybox(partialTick);
/* 516 */     rotateAndBlurSkybox(partialTick);
/* 517 */     rotateAndBlurSkybox(partialTick);
/* 518 */     rotateAndBlurSkybox(partialTick);
/* 519 */     this.field_146297_k.func_147110_a().func_147610_a(true);
/* 520 */     GL11.glViewport(0, 0, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 521 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 522 */     tessellator.func_78382_b();
/* 523 */     float f1 = (this.field_146294_l > this.field_146295_m) ? (120.0F / this.field_146294_l) : (120.0F / this.field_146295_m);
/* 524 */     float f2 = this.field_146295_m * f1 / 256.0F;
/* 525 */     float f3 = this.field_146294_l * f1 / 256.0F;
/* 526 */     tessellator.func_78369_a(1.0F, 1.0F, 1.0F, 1.0F);
/* 527 */     int k = this.field_146294_l;
/* 528 */     int l = this.field_146295_m;
/* 529 */     tessellator.func_78374_a(0.0D, l, this.field_73735_i, (0.5F - f2), (0.5F + f3));
/* 530 */     tessellator.func_78374_a(k, l, this.field_73735_i, (0.5F - f2), (0.5F - f3));
/* 531 */     tessellator.func_78374_a(k, 0.0D, this.field_73735_i, (0.5F + f2), (0.5F - f3));
/* 532 */     tessellator.func_78374_a(0.0D, 0.0D, this.field_73735_i, (0.5F + f2), (0.5F + f3));
/* 533 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTextureWithOptionalSize(int x, int y, int u, int v, int width, int height, int uSize, int vSize) {
/* 538 */     float scaledX = 1.0F / uSize;
/* 539 */     float scaledY = 1.0F / vSize;
/* 540 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 541 */     tessellator.func_78382_b();
/* 542 */     tessellator.func_78374_a((x + 0), (y + height), this.field_73735_i, ((u + 0) * scaledX), ((v + height) * scaledY));
/* 543 */     tessellator.func_78374_a((x + width), (y + height), this.field_73735_i, ((u + width) * scaledX), ((v + height) * scaledY));
/* 544 */     tessellator.func_78374_a((x + width), (y + 0), this.field_73735_i, ((u + width) * scaledX), ((v + 0) * scaledY));
/* 545 */     tessellator.func_78374_a((x + 0), (y + 0), this.field_73735_i, ((u + 0) * scaledX), ((v + 0) * scaledY));
/* 546 */     tessellator.func_78381_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawBackground() {
/* 551 */     GL11.glDisable(2896);
/* 552 */     GL11.glDisable(2912);
/* 553 */     Tessellator var2 = Tessellator.field_78398_a;
/* 554 */     GL11.glBindTexture(3553, 0);
/* 555 */     this.field_146297_k.func_110434_K().func_110577_a(BACKGROUND);
/* 556 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 557 */     var2.func_78382_b();
/* 558 */     var2.func_78374_a(0.0D, this.field_146295_m, 0.0D, 0.0D, 1.0D);
/* 559 */     var2.func_78374_a(this.field_146294_l, this.field_146295_m, 0.0D, 1.0D, 1.0D);
/* 560 */     var2.func_78374_a(this.field_146294_l, 0.0D, 0.0D, 1.0D, 0.0D);
/* 561 */     var2.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/* 562 */     var2.func_78381_a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int x, int y, float partialTick) {
/* 570 */     drawBackground();
/* 571 */     String s = "Minecraft 1.7.10";
/*     */     
/* 573 */     if (this.field_146297_k.func_71355_q())
/*     */     {
/* 575 */       s = s + " Demo";
/*     */     }
/*     */     
/* 578 */     List<String> brandings = Lists.reverse(FMLCommonHandler.instance().getBrandings(true));
/* 579 */     for (int brdline = 0; brdline < brandings.size(); brdline++) {
/*     */       
/* 581 */       String brd = brandings.get(brdline);
/* 582 */       if (!Strings.isNullOrEmpty(brd))
/*     */       {
/* 584 */         func_73731_b(this.field_146289_q, brd, 2, this.field_146295_m - 10 - 10 + brdline * (this.field_146289_q.field_78288_b + 1), 16777215);
/*     */       }
/*     */     } 
/* 587 */     func_73731_b(this.field_146289_q, "IggDrasil Menu Ordered By Byakkoki, Dev By Augma", 2, this.field_146295_m - 10, 16777215);
/* 588 */     String s1 = "Copyright Mojang AB. Do not distribute!";
/* 589 */     func_73731_b(this.field_146289_q, s1, this.field_146294_l - this.field_146289_q.func_78256_a(s1) - 2, this.field_146295_m - 10, -1);
/*     */     
/* 591 */     if (this.field_92025_p != null && this.field_92025_p.length() > 0) {
/*     */       
/* 593 */       func_73734_a(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
/* 594 */       func_73731_b(this.field_146289_q, this.field_92025_p, this.field_92022_t, this.field_92021_u, -1);
/* 595 */       func_73731_b(this.field_146289_q, this.field_146972_A, (this.field_146294_l - this.field_92024_r) / 2, ((GuiButton)this.field_146292_n.get(0)).field_146129_i - 12, -1);
/*     */     } 
/*     */     
/* 598 */     super.func_73863_a(x, y, partialTick);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 606 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 607 */     Object object = this.field_104025_t;
/*     */     
/* 609 */     synchronized (this.field_104025_t) {
/*     */       
/* 611 */       if (this.field_92025_p.length() > 0 && p_73864_1_ >= this.field_92022_t && p_73864_1_ <= this.field_92020_v && p_73864_2_ >= this.field_92021_u && p_73864_2_ <= this.field_92019_w) {
/*     */         
/* 613 */         GuiConfirmOpenLink guiconfirmopenlink = new GuiConfirmOpenLink(this, this.field_104024_v, 13, true);
/* 614 */         guiconfirmopenlink.func_146358_g();
/* 615 */         this.field_146297_k.func_147108_a((GuiScreen)guiconfirmopenlink);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\gui\screen\GuiCustomMainMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
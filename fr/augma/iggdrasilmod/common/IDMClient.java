/*    */ package fr.augma.iggdrasilmod.common;
/*    */ 
/*    */ import cpw.mods.fml.client.registry.ClientRegistry;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.InputEvent;
/*    */ import fr.augma.iggdrasilmod.config.ConfigBase;
/*    */ import fr.augma.iggdrasilmod.gui.overlay.GuiLifeBar;
/*    */ import fr.augma.iggdrasilmod.gui.screen.GuiCommunity;
/*    */ import fr.augma.iggdrasilmod.gui.screen.GuiCustomMainMenu;
/*    */ import java.io.File;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiMainMenu;
/*    */ import net.minecraft.client.gui.GuiMultiplayer;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.settings.KeyBinding;
/*    */ import net.minecraftforge.client.event.GuiOpenEvent;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDMClient
/*    */   extends IDMCommon
/*    */ {
/* 25 */   public static final KeyBinding HEALTH_INTERFACE_KEY = new KeyBinding("Vie en pourcentage ou brute", 37, "IggDrasil Mod");
/* 26 */   public static final KeyBinding COMMUNITY_INTERFACE_KEY = new KeyBinding("Ouvrir : Menu Communautaire", 46, "IggDrasil Mod");
/*    */   
/*    */   public static boolean lifeType;
/*    */   
/*    */   public static ConfigBase save;
/*    */   
/*    */   public void preInit(File configFile) {
/* 33 */     System.out.println("préInit client side");
/* 34 */     FMLCommonHandler.instance().bus().register(this);
/* 35 */     MinecraftForge.EVENT_BUS.register(this);
/* 36 */     MinecraftForge.EVENT_BUS.register(new GuiLifeBar());
/* 37 */     super.preInit(configFile);
/* 38 */     save = new ConfigBase("iggdrasilLifeBar");
/* 39 */     if (!ConfigBase.hasKey("lifebar", "displayType")) {
/* 40 */       ConfigBase.writeConfig("lifebar", "displayType", true);
/* 41 */       lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */     } else {
/* 43 */       lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */     } 
/* 45 */     ClientRegistry.registerKeyBinding(HEALTH_INTERFACE_KEY);
/* 46 */     ClientRegistry.registerKeyBinding(COMMUNITY_INTERFACE_KEY);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 51 */     super.init();
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onOpenGui(GuiOpenEvent event) {
/* 56 */     if (event.gui != null && event.gui.getClass() == GuiMainMenu.class) {
/* 57 */       event.setCanceled(true);
/* 58 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiCustomMainMenu());
/* 59 */     } else if (event.gui != null && event.gui.getClass() == GuiMultiplayer.class) {
/* 60 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiCustomMainMenu());
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onInput(InputEvent.KeyInputEvent event) {
/* 66 */     if (HEALTH_INTERFACE_KEY.func_151468_f()) {
/* 67 */       if (ConfigBase.getBoolean("lifebar", "displayType")) {
/* 68 */         ConfigBase.writeConfig("lifebar", "displayType", false);
/* 69 */         lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */       } else {
/* 71 */         ConfigBase.writeConfig("lifebar", "displayType", true);
/* 72 */         lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */       } 
/*    */     }
/* 75 */     if (COMMUNITY_INTERFACE_KEY.func_151468_f())
/* 76 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiCommunity()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\common\IDMClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
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
/*    */ public class IDMClient
/*    */   extends IDMCommon
/*    */ {
/* 24 */   public static final KeyBinding HEALTH_INTERFACE_KEY = new KeyBinding("Vie en pourcentage ou brute", 37, "IggDrasil Mod");
/* 25 */   public static final KeyBinding COMMUNITY_INTERFACE_KEY = new KeyBinding("Ouvrir : Menu Communautaire", 46, "IggDrasil Mod");
/*    */   
/*    */   public static boolean lifeType;
/*    */   public static ConfigBase save;
/*    */   
/*    */   public void preInit(File configFile) {
/* 31 */     System.out.println("préInit client side");
/* 32 */     FMLCommonHandler.instance().bus().register(this);
/* 33 */     MinecraftForge.EVENT_BUS.register(this);
/* 34 */     MinecraftForge.EVENT_BUS.register(new GuiLifeBar());
/* 35 */     super.preInit(configFile);
/* 36 */     save = new ConfigBase("iggdrasilLifeBar");
/* 37 */     if (!ConfigBase.hasKey("lifebar", "displayType")) {
/* 38 */       ConfigBase.writeConfig("lifebar", "displayType", true);
/* 39 */       lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */     } else {
/* 41 */       lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */     } 
/* 43 */     ClientRegistry.registerKeyBinding(HEALTH_INTERFACE_KEY);
/* 44 */     ClientRegistry.registerKeyBinding(COMMUNITY_INTERFACE_KEY);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 49 */     super.init();
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onOpenGui(GuiOpenEvent event) {
/* 54 */     if (event.gui != null && event.gui.getClass() == GuiMainMenu.class) {
/* 55 */       event.setCanceled(true);
/* 56 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiCustomMainMenu());
/* 57 */     } else if (event.gui != null && event.gui.getClass() == GuiMultiplayer.class) {
/* 58 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiCustomMainMenu());
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onInput(InputEvent.KeyInputEvent event) {
/* 64 */     if (HEALTH_INTERFACE_KEY.func_151468_f()) {
/* 65 */       if (ConfigBase.getBoolean("lifebar", "displayType")) {
/* 66 */         ConfigBase.writeConfig("lifebar", "displayType", false);
/* 67 */         lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */       } else {
/* 69 */         ConfigBase.writeConfig("lifebar", "displayType", true);
/* 70 */         lifeType = ConfigBase.getBoolean("lifebar", "displayType");
/*    */       } 
/*    */     }
/* 73 */     if (COMMUNITY_INTERFACE_KEY.func_151468_f())
/* 74 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiCommunity()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\common\IDMClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package fr.augma.iggdrasilmod;
/*    */ 
/*    */ import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.Mod.EventHandler;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*    */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import fr.augma.iggdrasilmod.command.CommandAddSkill;
/*    */ import fr.augma.iggdrasilmod.common.IDMCommon;
/*    */ import fr.augma.iggdrasilmod.creativetabs.IggDrasilTabs;
/*    */ import fr.augma.iggdrasilmod.event.PlayerEventHandlerServer;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminCommun;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminEvent;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminLegendaire;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminRare;
/*    */ import fr.augma.iggdrasilmod.packet.PacketRequestSkills;
/*    */ import fr.augma.iggdrasilmod.packet.PacketSkills;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.common.MinecraftForge;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "idm", version = "1.0", name = "IggDrasilMod")
/*    */ public class IDMod
/*    */ {
/*    */   public static final String MODID = "idm";
/*    */   public static final String NAME = "IggDrasilMod";
/*    */   public static final String VERSION = "1.0";
/*    */   public static final String ACCEPTED_VERSION = "[1.7.10]";
/*    */   @SidedProxy(clientSide = "fr.augma.iggdrasilmod.common.IDMClient", serverSide = "fr.augma.iggdrasilmod.common.IDMServer")
/*    */   public static IDMCommon PROXY;
/*    */   public static SimpleNetworkWrapper NETWORK;
/* 39 */   public static CreativeTabs IggDrasilTab = (CreativeTabs)new IggDrasilTabs("iggdrasilmount");
/*    */   public static Item parcheminCommun;
/*    */   public static Item parcheminRare;
/*    */   public static Item parcheminLegendaire;
/*    */   public static Item parcheminEvent;
/*    */   
/*    */   @EventHandler
/*    */   public void preInit(FMLPreInitializationEvent event) {
/* 47 */     PROXY.preInit(event.getSuggestedConfigurationFile());
/* 48 */     MinecraftForge.EVENT_BUS.register(new PlayerEventHandlerServer());
/* 49 */     parcheminCommun = (Item)new ItemParcheminCommun("parchemin_commun");
/* 50 */     parcheminRare = (Item)new ItemParcheminRare("parchemin_rare");
/* 51 */     parcheminRare = (Item)new ItemParcheminLegendaire("parchemin_legendaire");
/* 52 */     parcheminRare = (Item)new ItemParcheminEvent("parchemin_event");
/*    */     
/* 54 */     NETWORK = new SimpleNetworkWrapper("idm");
/* 55 */     NETWORK.registerMessage(PacketRequestSkills.Handler.class, PacketRequestSkills.class, 0, Side.SERVER);
/* 56 */     NETWORK.registerMessage(PacketSkills.Handler.class, PacketSkills.class, 1, Side.CLIENT);
/*    */   }
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void init(FMLInitializationEvent event) {
/* 62 */     PROXY.init();
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onServerStarting(FMLServerStartingEvent event) {
/* 67 */     event.registerServerCommand((ICommand)new CommandAddSkill());
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\IDMod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
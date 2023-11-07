/*     */ package fr.augma.iggdrasilmod;
/*     */ 
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import fr.augma.iggdrasilmod.command.CommandAddSkill;
/*     */ import fr.augma.iggdrasilmod.command.CommandLevelUp;
/*     */ import fr.augma.iggdrasilmod.command.CommandResetSkillPlayer;
/*     */ import fr.augma.iggdrasilmod.common.IDMCommon;
/*     */ import fr.augma.iggdrasilmod.creativetabs.IggDrasilTabs;
/*     */ import fr.augma.iggdrasilmod.event.PlayerEventHandlerServer;
/*     */ import fr.augma.iggdrasilmod.init.ItemsInit;
/*     */ import fr.augma.iggdrasilmod.packet.PacketClasseChoice;
/*     */ import fr.augma.iggdrasilmod.packet.PacketCriticParticle;
/*     */ import fr.augma.iggdrasilmod.packet.PacketRequestSkills;
/*     */ import fr.augma.iggdrasilmod.packet.PacketRequestStats;
/*     */ import fr.augma.iggdrasilmod.packet.PacketSkillUp;
/*     */ import fr.augma.iggdrasilmod.packet.PacketSkills;
/*     */ import fr.augma.iggdrasilmod.packet.PacketStats;
/*     */ import fr.augma.iggdrasilmod.utils.Classes;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ @Mod(modid = "idm", version = "1.0", name = "IggDrasilMod")
/*     */ public class IDMod
/*     */ {
/*     */   public static final String MODID = "idm";
/*     */   public static final String NAME = "IggDrasilMod";
/*     */   public static final String VERSION = "1.0";
/*     */   public static final String ACCEPTED_VERSION = "[1.7.10]";
/*     */   @SidedProxy(clientSide = "fr.augma.iggdrasilmod.common.IDMClient", serverSide = "fr.augma.iggdrasilmod.common.IDMServer")
/*     */   public static IDMCommon PROXY;
/*     */   public static SimpleNetworkWrapper NETWORK;
/*  55 */   public static CreativeTabs IggDrasilTab = (CreativeTabs)new IggDrasilTabs("iggdrasilmount");
/*     */   public static List<Classes> classe;
/*     */   
/*     */   @EventHandler
/*     */   public void preInit(FMLPreInitializationEvent event) {
/*  60 */     PROXY.preInit(event.getSuggestedConfigurationFile());
/*  61 */     MinecraftForge.EVENT_BUS.register(new PlayerEventHandlerServer());
/*  62 */     ItemsInit.init();
/*  63 */     loadNetwork();
/*  64 */     createFolder();
/*  65 */     loadClasses();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void init(FMLInitializationEvent event) {
/*  71 */     PROXY.init();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onServerStarting(FMLServerStartingEvent event) {
/*  76 */     event.registerServerCommand((ICommand)new CommandAddSkill());
/*  77 */     event.registerServerCommand((ICommand)new CommandLevelUp());
/*  78 */     event.registerServerCommand((ICommand)new CommandResetSkillPlayer());
/*     */   }
/*     */   
/*     */   public void loadClasses() {
/*  82 */     classe = new ArrayList<Classes>();
/*  83 */     classe.add(new Classes("Guerrier", new String[] { "Le Guerrier est la classe la plus Tank du Continent d'IggDrasil !", "Elle est super utile dans les combats ou bien m�me dans les donjons !", "Au niveau 50, elle choisit de devenir un Paladin ou un Chevalier" }, new Classes[] { new Classes("Paladin", null, null), new Classes("Chevalier", null, null) }));
/*  84 */     classe.add(new Classes("Archer", new String[] { "L'archer est la classe � distance favorite de tous !", "Au niveau 50, elle choisit de devenir un Chasseur ou un Ranger !" }, new Classes[] { new Classes("Chasseur", null, null), new Classes("Ranger", null, null) }));
/*  85 */     classe.add(new Classes("Assassin", new String[] { "L'assassin est l'une des des meilleurs classe DPS du Continent d'IggDrasil !", "Elle permet d'infliger de tr�s lourds d�g�ts et rapidement !", "Au niveau 50, elle choisit de devenir Rodeur ou un Ninja !" }, new Classes[] { new Classes("Rodeur", null, null), new Classes("Ninja", null, null) }));
/*  86 */     classe.add(new Classes("Samoura�", new String[] { "Le Samoura� qui a une maniabilit� excellente avec son Katana vous aurez quand m�me de la difficult� � vous d�fendre !", "Au niveau 50, elle choisit de devenir Da�sho ou un Wakazaki !" }, new Classes[] { new Classes("Da�sho", null, null), new Classes("Wakazaki", null, null) }));
/*  87 */     classe.add(new Classes("Ing�nieur", new String[] { "L'Ing�nieur ! Une classe tr�s difficile � jouer mais une fois maitris�e vous deviendrez un v�ritable enfer pour les joueurs comme pour les monstres !", "Au niveau 50, elle choisit de devenir M�cano ou un Artilleur !" }, new Classes[] { new Classes("M�cano", null, null), new Classes("Artilleur", null, null) }));
/*  88 */     classe.add(new Classes("Faucheur", new String[] { "Le Faucheur est la seule classe du Continent d'IggDrasil � �tre sp�cialis�e dans le vol de vie sur les monstres ou m�me sur des joueurs en PVP !", "Au niveau 50, elle choisit de devenir Life Thief ou un Finalist !" }, new Classes[] { new Classes("Life Thief", null, null), new Classes("Finalist", null, null) }));
/*  89 */     classe.add(new Classes("B�n�diction", new String[] { "Vous voulez vivre paisiblement dans le Continent d'Iggdrasil ?! Cette classe est faite pour vous !", "Elle ne poss�de aucune Sous-Classe !" }, null));
/*  90 */     classe.add(new Classes("Cauchemar", new String[] { "Vous voulez vraiment vivre un Cauchemar dans le Continent d'IggDrasil ?! Cette classe est faite pour vous !", "Elle ne poss�de aucune Sous-Classe !" }, null));
/*     */   }
/*     */   
/*     */   public void createFolder() {
/*  94 */     File directory = new File("config/IDM/playerdata/");
/*  95 */     if (!directory.exists()) {
/*  96 */       directory.mkdirs();
/*     */     }
/*     */   }
/*     */   
/*     */   public void loadNetwork() {
/* 101 */     NETWORK = new SimpleNetworkWrapper("idm");
/* 102 */     NETWORK.registerMessage(PacketRequestSkills.Handler.class, PacketRequestSkills.class, 0, Side.SERVER);
/* 103 */     NETWORK.registerMessage(PacketSkills.Handler.class, PacketSkills.class, 1, Side.CLIENT);
/* 104 */     NETWORK.registerMessage(PacketRequestStats.Handler.class, PacketRequestStats.class, 2, Side.SERVER);
/* 105 */     NETWORK.registerMessage(PacketStats.Handler.class, PacketStats.class, 3, Side.CLIENT);
/* 106 */     NETWORK.registerMessage(PacketCriticParticle.Handler.class, PacketCriticParticle.class, 4, Side.CLIENT);
/* 107 */     NETWORK.registerMessage(PacketClasseChoice.Handler.class, PacketClasseChoice.class, 5, Side.CLIENT);
/* 108 */     NETWORK.registerMessage(PacketSkillUp.Handler.class, PacketSkillUp.class, 6, Side.SERVER);
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\IDMod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
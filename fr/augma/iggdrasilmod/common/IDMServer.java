/*    */ package fr.augma.iggdrasilmod.common;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import fr.augma.iggdrasilmod.IDMod;
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import fr.augma.iggdrasilmod.packet.PacketClasseChoice;
/*    */ import java.io.File;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ 
/*    */ public class IDMServer
/*    */   extends IDMCommon
/*    */ {
/*    */   public void preInit(File configFile) {
/* 17 */     System.out.println("préinit server side");
/*    */ 
/*    */     
/* 20 */     super.preInit(configFile);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init() {
/* 25 */     super.init();
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
/* 30 */     if (PlayerPropertiesIggDrasil.get(event.player).isNew()) {
/* 31 */       IDMod.NETWORK.sendTo((IMessage)new PacketClasseChoice(), (EntityPlayerMP)event.player);
/* 32 */       PlayerPropertiesIggDrasil.get(event.player).New();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\common\IDMServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package fr.augma.iggdrasilmod.packet;
/*    */ 
/*    */ import cpw.mods.fml.common.network.ByteBufUtils;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import fr.augma.iggdrasilmod.event.PlayerEventHandlerServer;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ public class PacketSkillUp implements IMessage {
/*    */   private String category;
/*    */   
/*    */   public PacketSkillUp() {}
/*    */   
/*    */   public PacketSkillUp(String category) {
/* 19 */     this.category = category;
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 24 */     this.category = ByteBufUtils.readUTF8String(buf);
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 29 */     ByteBufUtils.writeUTF8String(buf, this.category);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<PacketSkillUp, IMessage>
/*    */   {
/*    */     public IMessage onMessage(PacketSkillUp message, MessageContext ctx) {
/* 36 */       EntityPlayerMP player = (ctx.getServerHandler()).field_147369_b;
/* 37 */       PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get((EntityPlayer)player);
/* 38 */       if (props.hasPoint()) {
/* 39 */         if (message.category.equalsIgnoreCase("force")) {
/* 40 */           props.addStrength(1);
/* 41 */           PlayerEventHandlerServer.refreshStrength((EntityPlayer)player);
/* 42 */         } else if (message.category.equalsIgnoreCase("vitalite")) {
/* 43 */           props.addHealth(1);
/* 44 */           PlayerEventHandlerServer.refreshHealth((EntityPlayer)player);
/* 45 */         } else if (message.category.equalsIgnoreCase("agilite")) {
/* 46 */           props.addAgility(1);
/* 47 */           PlayerEventHandlerServer.refreshSpeed((EntityPlayer)player);
/* 48 */         } else if (message.category.equalsIgnoreCase("chance")) {
/* 49 */           props.addChance(1);
/* 50 */         } else if (message.category.equalsIgnoreCase("intelligence")) {
/* 51 */           props.addIntelligence(1);
/* 52 */         } else if (message.category.equalsIgnoreCase("sagesse")) {
/* 53 */           props.addWisdom(1);
/*    */         } 
/*    */       }
/* 56 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\packet\PacketSkillUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
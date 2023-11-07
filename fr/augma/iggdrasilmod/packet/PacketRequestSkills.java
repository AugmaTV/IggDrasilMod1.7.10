/*    */ package fr.augma.iggdrasilmod.packet;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketRequestSkills
/*    */   implements IMessage
/*    */ {
/*    */   public void fromBytes(ByteBuf buf) {}
/*    */   
/*    */   public void toBytes(ByteBuf buf) {}
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<PacketRequestSkills, PacketSkills>
/*    */   {
/*    */     public PacketSkills onMessage(PacketRequestSkills message, MessageContext ctx) {
/* 29 */       return new PacketSkills(PlayerPropertiesIggDrasil.get((EntityPlayer)(ctx.getServerHandler()).field_147369_b));
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\packet\PacketRequestSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
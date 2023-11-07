/*    */ package fr.augma.iggdrasilmod.packet;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import fr.augma.iggdrasilmod.gui.screen.GuiClassesChoice;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketClasseChoice
/*    */   implements IMessage
/*    */ {
/*    */   public void fromBytes(ByteBuf buf) {}
/*    */   
/*    */   public void toBytes(ByteBuf buf) {}
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<PacketClasseChoice, IMessage>
/*    */   {
/*    */     @SideOnly(Side.CLIENT)
/*    */     public IMessage onMessage(PacketClasseChoice message, MessageContext ctx) {
/* 30 */       System.out.println("Packet received");
/* 31 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiClassesChoice());
/* 32 */       System.out.println("Action performed");
/* 33 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\packet\PacketClasseChoice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
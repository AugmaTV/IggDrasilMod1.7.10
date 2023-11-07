/*    */ package fr.augma.iggdrasilmod.packet;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class PacketCriticParticle
/*    */   implements IMessage
/*    */ {
/*    */   public double X;
/*    */   public double Y;
/*    */   public double Z;
/*    */   
/*    */   public PacketCriticParticle() {}
/*    */   
/*    */   public PacketCriticParticle(Entity entity) {
/* 22 */     this.X = entity.field_70165_t;
/* 23 */     this.Y = entity.field_70163_u;
/* 24 */     this.Z = entity.field_70161_v;
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 29 */     this.X = buf.readDouble();
/* 30 */     this.Y = buf.readDouble();
/* 31 */     this.Z = buf.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 36 */     buf.writeDouble(this.X);
/* 37 */     buf.writeDouble(this.Y);
/* 38 */     buf.writeDouble(this.Z);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<PacketCriticParticle, IMessage>
/*    */   {
/*    */     @SideOnly(Side.CLIENT)
/*    */     public IMessage onMessage(PacketCriticParticle message, MessageContext ctx) {
/* 46 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X + 0.5D, message.Y + 1.0D, message.Z + 0.5D, 0.0D, 0.0D, 0.0D);
/* 47 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X + 0.5D, message.Y + 1.0D, message.Z - 0.5D, 0.0D, 0.0D, 0.0D);
/* 48 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X - 0.5D, message.Y, message.Z + 0.5D, 0.0D, 0.0D, 0.0D);
/* 49 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X - 0.5D, message.Y + 1.0D, message.Z - 0.5D, 0.0D, 0.0D, 0.0D);
/* 50 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X + 0.5D, message.Y + 1.5D, message.Z + 0.5D, 0.0D, 0.0D, 0.0D);
/* 51 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X + 0.5D, message.Y + 1.2D, message.Z - 0.5D, 0.0D, 0.0D, 0.0D);
/* 52 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X - 0.5D, message.Y + 0.8D, message.Z + 0.5D, 0.0D, 0.0D, 0.0D);
/* 53 */       (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_72869_a("happyVillager", message.X - 0.5D, message.Y + 1.8D, message.Z - 0.5D, 0.0D, 0.0D, 0.0D);
/* 54 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\packet\PacketCriticParticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
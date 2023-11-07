/*    */ package fr.augma.iggdrasilmod.packet;
/*    */ 
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import fr.augma.iggdrasilmod.gui.screen.GuiSkills;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ 
/*    */ public class PacketSkills implements IMessage {
/*    */   public int strength;
/*    */   public int health;
/*    */   public int agility;
/*    */   public int chance;
/*    */   public int intelligence;
/*    */   public int wisdom;
/*    */   public int availablePoint;
/*    */   public int maxAgility;
/*    */   
/*    */   public PacketSkills() {}
/*    */   
/*    */   public PacketSkills(PlayerPropertiesIggDrasil props) {
/* 27 */     this.strength = props.strength;
/* 28 */     this.health = props.health;
/* 29 */     this.agility = props.agility;
/* 30 */     this.chance = props.chance;
/* 31 */     this.intelligence = props.intelligence;
/* 32 */     this.wisdom = props.wisdom;
/* 33 */     this.availablePoint = props.availablePoint;
/* 34 */     props.getClass(); this.maxAgility = 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 39 */     this.strength = buf.readInt();
/* 40 */     this.health = buf.readInt();
/* 41 */     this.agility = buf.readInt();
/* 42 */     this.chance = buf.readInt();
/* 43 */     this.intelligence = buf.readInt();
/* 44 */     this.wisdom = buf.readInt();
/* 45 */     this.availablePoint = buf.readInt();
/* 46 */     this.maxAgility = buf.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 51 */     buf.writeInt(this.strength);
/* 52 */     buf.writeInt(this.health);
/* 53 */     buf.writeInt(this.agility);
/* 54 */     buf.writeInt(this.chance);
/* 55 */     buf.writeInt(this.intelligence);
/* 56 */     buf.writeInt(this.wisdom);
/* 57 */     buf.writeInt(this.availablePoint);
/* 58 */     buf.writeInt(this.maxAgility);
/*    */   }
/*    */   
/*    */   public static class Handler
/*    */     implements IMessageHandler<PacketSkills, IMessage>
/*    */   {
/*    */     @SideOnly(Side.CLIENT)
/*    */     public IMessage onMessage(PacketSkills message, MessageContext ctx) {
/* 66 */       int[] info = { message.strength, message.health, message.agility, message.chance, message.intelligence, message.wisdom, message.availablePoint, message.maxAgility };
/* 67 */       Minecraft.func_71410_x().func_147108_a((GuiScreen)new GuiSkills(info));
/* 68 */       return null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\packet\PacketSkills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
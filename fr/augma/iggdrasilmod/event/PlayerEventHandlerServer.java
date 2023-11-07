/*    */ package fr.augma.iggdrasilmod.event;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*    */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraftforge.event.entity.EntityEvent;
/*    */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*    */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*    */ import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerEventHandlerServer
/*    */ {
/* 27 */   private static final UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
/*    */   
/*    */   public static void refreshStrength(EntityPlayer player) {
/* 30 */     IAttributeInstance attribute = player.func_110148_a(SharedMonsterAttributes.field_111264_e);
/* 31 */     PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/* 32 */     if (attribute.func_111127_a(uuid) != null) attribute.func_111124_b(attribute.func_111127_a(uuid)); 
/* 33 */     AttributeModifier modifier = new AttributeModifier(uuid, "attack", props.strength, 0);
/* 34 */     attribute.func_111121_a(modifier);
/*    */   }
/*    */   
/*    */   public static void refreshSpeed(EntityPlayer player) {
/* 38 */     IAttributeInstance attribute = player.func_110148_a(SharedMonsterAttributes.field_111263_d);
/* 39 */     PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/* 40 */     if (attribute.func_111127_a(uuid) != null) attribute.func_111124_b(attribute.func_111127_a(uuid)); 
/* 41 */     props.getClass(); double speed = 0.1D / 20.0D * props.agility;
/* 42 */     AttributeModifier modifier = new AttributeModifier(uuid, "speed", speed, 0);
/* 43 */     attribute.func_111121_a(modifier);
/*    */   }
/*    */   
/*    */   public static void refreshHealth(EntityPlayer player) {
/* 47 */     IAttributeInstance attribute = player.func_110148_a(SharedMonsterAttributes.field_111267_a);
/* 48 */     PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/* 49 */     if (attribute.func_111127_a(uuid) != null) attribute.func_111124_b(attribute.func_111127_a(uuid)); 
/* 50 */     double health = 2.0D * props.health;
/* 51 */     AttributeModifier modifier = new AttributeModifier(uuid, "health", health, 0);
/* 52 */     attribute.func_111121_a(modifier);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.SERVER)
/*    */   public void onEntityConstructing(EntityEvent.EntityConstructing event) {
/* 58 */     if (!event.entity.field_70170_p.field_72995_K && event.entity instanceof EntityPlayer && PlayerPropertiesIggDrasil.get((EntityPlayer)event.entity) == null)
/* 59 */       PlayerPropertiesIggDrasil.register((EntityPlayer)event.entity); 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   @SideOnly(Side.SERVER)
/*    */   public void onEntityJoin(EntityJoinWorldEvent event) {
/* 65 */     if (!event.entity.field_70170_p.field_72995_K && event.entity instanceof EntityPlayer && PlayerPropertiesIggDrasil.get((EntityPlayer)event.entity) == null) {
/* 66 */       PlayerPropertiesIggDrasil.register((EntityPlayer)event.entity);
/*    */     }
/* 68 */     if (event.entity instanceof EntityPlayer) {
/* 69 */       refreshStrength((EntityPlayer)event.entity);
/* 70 */       refreshSpeed((EntityPlayer)event.entity);
/* 71 */       refreshHealth((EntityPlayer)event.entity);
/*    */     } 
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onClone(PlayerEvent.Clone event) {
/* 77 */     if (event.wasDeath && 
/* 78 */       PlayerPropertiesIggDrasil.has(event.original)) {
/* 79 */       PlayerPropertiesIggDrasil old = PlayerPropertiesIggDrasil.get(event.original);
/* 80 */       PlayerPropertiesIggDrasil news = PlayerPropertiesIggDrasil.get(event.entityPlayer);
/* 81 */       news.set(old);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onRespawn(PlayerEvent.PlayerRespawnEvent e) {
/* 88 */     refreshStrength(e.player);
/* 89 */     refreshSpeed(e.player);
/* 90 */     refreshHealth(e.player);
/*    */   }
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onLevelUp(PlayerPickupXpEvent event) {
/* 95 */     float exp = event.entityPlayer.func_71050_bK() * event.entityPlayer.field_71106_cc;
/* 96 */     if (event.entityPlayer.func_71050_bK() <= exp + event.orb.field_70530_e) {
/* 97 */       event.entityPlayer.func_145747_a((IChatComponent)new ChatComponentText("Tu vien de monter d'un niveau et réçu 2 point d'attribut"));
/* 98 */       PlayerPropertiesIggDrasil.get(event.entityPlayer).addPoint(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\event\PlayerEventHandlerServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
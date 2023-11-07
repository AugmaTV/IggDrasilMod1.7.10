/*     */ package fr.augma.iggdrasilmod.event;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*     */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import fr.augma.iggdrasilmod.IDMod;
/*     */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*     */ import fr.augma.iggdrasilmod.packet.PacketCriticParticle;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraftforge.event.entity.EntityEvent;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerEvent;
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
/*     */ 
/*     */ public class PlayerEventHandlerServer
/*     */ {
/*  40 */   private static final UUID uuid = UUID.fromString("123e4567-e89b-12d3-a456-556642440000");
/*     */   
/*     */   public static void refreshStrength(EntityPlayer player) {
/*  43 */     IAttributeInstance attribute = player.func_110148_a(SharedMonsterAttributes.field_111264_e);
/*  44 */     PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/*  45 */     if (attribute.func_111127_a(uuid) != null) attribute.func_111124_b(attribute.func_111127_a(uuid)); 
/*  46 */     AttributeModifier modifier = new AttributeModifier(uuid, "attack", props.strength, 0);
/*  47 */     attribute.func_111121_a(modifier);
/*     */   }
/*     */   
/*     */   public static void refreshSpeed(EntityPlayer player) {
/*  51 */     IAttributeInstance attribute = player.func_110148_a(SharedMonsterAttributes.field_111263_d);
/*  52 */     PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/*  53 */     if (attribute.func_111127_a(uuid) != null) attribute.func_111124_b(attribute.func_111127_a(uuid)); 
/*  54 */     props.getClass(); double speed = 0.1D / 20.0D * props.agility;
/*  55 */     AttributeModifier modifier = new AttributeModifier(uuid, "speed", speed, 0);
/*  56 */     attribute.func_111121_a(modifier);
/*     */   }
/*     */   
/*     */   public static void refreshHealth(EntityPlayer player) {
/*  60 */     IAttributeInstance attribute = player.func_110148_a(SharedMonsterAttributes.field_111267_a);
/*  61 */     PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/*  62 */     if (attribute.func_111127_a(uuid) != null) attribute.func_111124_b(attribute.func_111127_a(uuid)); 
/*  63 */     double health = 2.0D * props.health;
/*  64 */     AttributeModifier modifier = new AttributeModifier(uuid, "health", health, 0);
/*  65 */     attribute.func_111121_a(modifier);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.SERVER)
/*     */   public void onEntityConstructing(EntityEvent.EntityConstructing event) {
/*  71 */     if (!event.entity.field_70170_p.field_72995_K && event.entity instanceof EntityPlayer && PlayerPropertiesIggDrasil.get((EntityPlayer)event.entity) == null)
/*  72 */       PlayerPropertiesIggDrasil.register((EntityPlayer)event.entity); 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   @SideOnly(Side.SERVER)
/*     */   public void onEntityJoin(EntityJoinWorldEvent event) {
/*  78 */     if (!event.entity.field_70170_p.field_72995_K && event.entity instanceof EntityPlayer && PlayerPropertiesIggDrasil.get((EntityPlayer)event.entity) == null) {
/*  79 */       PlayerPropertiesIggDrasil.register((EntityPlayer)event.entity);
/*     */     }
/*  81 */     if (event.entity instanceof EntityPlayer) {
/*  82 */       refreshStrength((EntityPlayer)event.entity);
/*  83 */       refreshSpeed((EntityPlayer)event.entity);
/*  84 */       refreshHealth((EntityPlayer)event.entity);
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onClone(PlayerEvent.Clone event) {
/*  90 */     if (event.wasDeath && 
/*  91 */       PlayerPropertiesIggDrasil.has(event.original)) {
/*  92 */       PlayerPropertiesIggDrasil old = PlayerPropertiesIggDrasil.get(event.original);
/*  93 */       PlayerPropertiesIggDrasil news = PlayerPropertiesIggDrasil.get(event.entityPlayer);
/*  94 */       news.set(old);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onHit(LivingHurtEvent event) {
/* 101 */     if (event.source.func_76364_f() instanceof EntityPlayer) {
/* 102 */       EntityPlayer player = (EntityPlayer)event.source.func_76364_f();
/* 103 */       PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/* 104 */       float crit = props.chance * 0.5F;
/* 105 */       Random r = new Random();
/* 106 */       if (r.nextInt(100) <= crit) {
/* 107 */         event.ammount *= 1.5F + r.nextFloat() / 2.0F;
/* 108 */         IDMod.NETWORK.sendTo((IMessage)new PacketCriticParticle(event.entity), (EntityPlayerMP)player);
/* 109 */         player.func_145747_a((IChatComponent)new ChatComponentText("Critical !"));
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRespawn(PlayerEvent.PlayerRespawnEvent e) {
/* 116 */     refreshStrength(e.player);
/* 117 */     refreshSpeed(e.player);
/* 118 */     refreshHealth(e.player);
/*     */   }
/*     */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\event\PlayerEventHandlerServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
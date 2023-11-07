/*    */ package fr.augma.iggdrasilmod.command;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.ChatComponentText;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.world.WorldServer;
/*    */ 
/*    */ public class CommandResetSkillPlayer extends CommandBase {
/*    */   public String func_71517_b() {
/* 15 */     return "resetskill";
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 20 */     return "/resetskill <player>";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] args) {
/* 25 */     if (args.length != 0) {
/* 26 */       WorldServer[] w = (FMLCommonHandler.instance().getMinecraftServerInstance()).field_71305_c;
/*    */       
/* 28 */       for (WorldServer world : w) {
/* 29 */         if (world.func_72924_a(args[0]) != null) {
/* 30 */           EntityPlayerMP player = (EntityPlayerMP)world.func_72924_a(args[0]);
/* 31 */           PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get((EntityPlayer)player);
/* 32 */           props.reset();
/* 33 */           player.func_145747_a((IChatComponent)new ChatComponentText("Vous venez d'�tre reset de vos point de skill !"));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\command\CommandResetSkillPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
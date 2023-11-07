/*    */ package fr.augma.iggdrasilmod.command;
/*    */ 
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import fr.augma.iggdrasilmod.event.PlayerEventHandlerServer;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandAddSkill
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 15 */     return "addskill";
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 20 */     return "/addskill <force|vitalite|agilite|chance|intelligence|sagesse>";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] args) {
/* 25 */     if (func_71519_b(sender) && 
/* 26 */       args.length != 0) {
/* 27 */       EntityPlayer player = (EntityPlayer)sender;
/* 28 */       PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/* 29 */       if (props.hasPoint())
/* 30 */         if (args[0].equalsIgnoreCase("force")) {
/* 31 */           props.addStrength(1);
/* 32 */           PlayerEventHandlerServer.refreshStrength(player);
/* 33 */         } else if (args[0].equalsIgnoreCase("vitalite")) {
/* 34 */           props.addHealth(1);
/* 35 */           PlayerEventHandlerServer.refreshHealth(player);
/* 36 */         } else if (args[0].equalsIgnoreCase("agilite")) {
/* 37 */           props.addAgility(1);
/* 38 */           PlayerEventHandlerServer.refreshSpeed(player);
/* 39 */         } else if (args[0].equalsIgnoreCase("chance")) {
/* 40 */           props.addChance(1);
/* 41 */         } else if (args[0].equalsIgnoreCase("intelligence")) {
/* 42 */           props.addIntelligence(1);
/* 43 */         } else if (args[0].equalsIgnoreCase("sagesse")) {
/* 44 */           props.addWisdom(1);
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\command\CommandAddSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
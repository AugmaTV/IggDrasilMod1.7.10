/*    */ package fr.augma.iggdrasilmod.command;
/*    */ 
/*    */ import fr.augma.iggdrasilmod.PlayerExtendedProperties.PlayerPropertiesIggDrasil;
/*    */ import fr.augma.iggdrasilmod.event.PlayerEventHandlerServer;
/*    */ import net.minecraft.command.CommandBase;
/*    */ import net.minecraft.command.ICommandSender;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class CommandAddSkill
/*    */   extends CommandBase
/*    */ {
/*    */   public String func_71517_b() {
/* 13 */     return "addskill";
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_71518_a(ICommandSender p_71518_1_) {
/* 18 */     return "/addskill <force|vitalite|agilite|chance|intelligence|sagesse>";
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_82362_a() {
/* 23 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_71519_b(ICommandSender p_71519_1_) {
/* 28 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_71515_b(ICommandSender sender, String[] args) {
/* 33 */     if (func_71519_b(sender) && 
/* 34 */       args.length != 0) {
/* 35 */       EntityPlayer player = (EntityPlayer)sender;
/* 36 */       PlayerPropertiesIggDrasil props = PlayerPropertiesIggDrasil.get(player);
/* 37 */       if (props.hasPoint())
/* 38 */         if (args[0].equalsIgnoreCase("force")) {
/* 39 */           props.addStrength(1);
/* 40 */           PlayerEventHandlerServer.refreshStrength(player);
/* 41 */         } else if (args[0].equalsIgnoreCase("vitalite")) {
/* 42 */           props.addHealth(1);
/* 43 */           PlayerEventHandlerServer.refreshHealth(player);
/* 44 */         } else if (args[0].equalsIgnoreCase("agilite")) {
/* 45 */           props.addAgility(1);
/* 46 */           PlayerEventHandlerServer.refreshSpeed(player);
/* 47 */         } else if (args[0].equalsIgnoreCase("chance")) {
/* 48 */           props.addChance(1);
/* 49 */         } else if (args[0].equalsIgnoreCase("intelligence")) {
/* 50 */           props.addIntelligence(1);
/* 51 */         } else if (args[0].equalsIgnoreCase("sagesse")) {
/* 52 */           props.addWisdom(1);
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\command\CommandAddSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
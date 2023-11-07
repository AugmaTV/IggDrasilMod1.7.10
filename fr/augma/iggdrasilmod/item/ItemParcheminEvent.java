/*    */ package fr.augma.iggdrasilmod.item;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import fr.augma.iggdrasilmod.IDMod;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemParcheminEvent
/*    */   extends Item
/*    */ {
/*    */   public String name;
/*    */   
/*    */   public ItemParcheminEvent(String name) {
/* 16 */     this.name = name;
/* 17 */     func_77637_a(IDMod.IggDrasilTab);
/* 18 */     func_77655_b(name);
/* 19 */     func_111206_d("idm:" + name);
/* 20 */     func_77625_d(1);
/* 21 */     GameRegistry.registerItem(this, name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconregister) {
/* 27 */     this.field_77791_bV = iconregister.func_94245_a("idm:" + this.name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\item\ItemParcheminEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package fr.augma.iggdrasilmod.item;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import fr.augma.iggdrasilmod.IDMod;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemParcheminRare
/*    */   extends Item {
/*    */   public String name;
/*    */   
/*    */   public ItemParcheminRare(String name) {
/* 13 */     this.name = name;
/* 14 */     func_77637_a(IDMod.IggDrasilTab);
/* 15 */     func_77655_b(name);
/* 16 */     func_111206_d("idm:" + name);
/* 17 */     func_77625_d(1);
/* 18 */     GameRegistry.registerItem(this, name);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconregister) {
/* 24 */     this.field_77791_bV = iconregister.func_94245_a("idm:" + this.name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\item\ItemParcheminRare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
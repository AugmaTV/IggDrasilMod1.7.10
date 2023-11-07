/*    */ package fr.augma.iggdrasilmod.item.food;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import fr.augma.iggdrasilmod.IDMod;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemFood;
/*    */ 
/*    */ public class ItemFood
/*    */   extends ItemFood {
/*    */   public ItemFood(int faim, float saturation, boolean loup, String name) {
/* 12 */     super(faim, saturation, loup);
/* 13 */     this.name = name;
/* 14 */     func_77655_b(name);
/* 15 */     func_77637_a(IDMod.IggDrasilTab);
/* 16 */     func_111206_d("idm:" + name);
/* 17 */     GameRegistry.registerItem((Item)this, name);
/*    */   }
/*    */   private String name;
/*    */   
/*    */   public void func_94581_a(IIconRegister iconregister) {
/* 22 */     this.field_77791_bV = iconregister.func_94245_a("idm:" + this.name);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\item\food\ItemFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
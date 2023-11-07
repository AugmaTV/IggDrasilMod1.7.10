/*    */ package fr.augma.iggdrasilmod.item;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import fr.augma.iggdrasilmod.IDMod;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemParcheminEvent
/*    */   extends Item {
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
/*    */ 
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
/* 32 */     if (!p_77659_2_.field_72995_K) {
/* 33 */       System.out.println(p_77659_1_.func_82833_r());
/*    */     }
/* 35 */     return super.func_77659_a(p_77659_1_, p_77659_2_, p_77659_3_);
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0.jar!\fr\augma\iggdrasilmod\item\ItemParcheminEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
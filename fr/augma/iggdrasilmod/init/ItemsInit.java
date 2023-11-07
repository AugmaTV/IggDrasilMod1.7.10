/*    */ package fr.augma.iggdrasilmod.init;
/*    */ 
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminCommun;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminEvent;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminLegendaire;
/*    */ import fr.augma.iggdrasilmod.item.ItemParcheminRare;
/*    */ import fr.augma.iggdrasilmod.item.food.ItemFood;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemsInit {
/*    */   public static Item parcheminCommun;
/*    */   public static Item parcheminRare;
/*    */   public static Item parcheminLegendaire;
/*    */   public static Item parcheminEvent;
/*    */   public static Item bonbon_bleu;
/*    */   public static Item bonbon_jaune;
/*    */   public static Item bonbon_rouge;
/*    */   public static Item bonbon_special;
/*    */   public static Item pwa_elixir;
/*    */   public static Item pwa_elixir2;
/*    */   public static Item pwa_encens;
/*    */   public static Item pwa_encre;
/*    */   public static Item pwa_pomme_blanche;
/*    */   public static Item pwa_pomme_bleu;
/*    */   public static Item pwa_pomme_jaune;
/*    */   public static Item pwa_pomme_rouge;
/*    */   public static Item pwa_pomme_verte;
/*    */   
/*    */   public static void init() {
/* 30 */     parcheminCommun = (Item)new ItemParcheminCommun("parchemin_commun");
/* 31 */     parcheminRare = (Item)new ItemParcheminRare("parchemin_rare");
/* 32 */     parcheminRare = (Item)new ItemParcheminLegendaire("parchemin_legendaire");
/* 33 */     parcheminRare = (Item)new ItemParcheminEvent("parchemin_event");
/* 34 */     bonbon_bleu = (Item)new ItemFood(0, 0.0F, false, "bonbon_bleu");
/* 35 */     bonbon_jaune = (Item)new ItemFood(0, 0.0F, false, "bonbon_jaune");
/* 36 */     bonbon_rouge = (Item)new ItemFood(0, 0.0F, false, "bonbon_rouge");
/* 37 */     bonbon_special = (Item)new ItemFood(0, 0.0F, false, "bonbon_special");
/* 38 */     pwa_elixir = (Item)new ItemFood(0, 0.0F, false, "pwa_elixir");
/* 39 */     pwa_elixir2 = (Item)new ItemFood(0, 0.0F, false, "pwa_elixir2");
/* 40 */     pwa_pomme_blanche = (Item)new ItemFood(0, 0.0F, false, "pwa_pomme_blanche");
/* 41 */     pwa_pomme_bleu = (Item)new ItemFood(0, 0.0F, false, "pwa_pomme_bleu");
/* 42 */     pwa_pomme_jaune = (Item)new ItemFood(0, 0.0F, false, "pwa_pomme_jaune");
/* 43 */     pwa_pomme_rouge = (Item)new ItemFood(0, 0.0F, false, "pwa_pomme_rouge");
/* 44 */     pwa_pomme_verte = (Item)new ItemFood(0, 0.0F, false, "pwa_pomme_verte");
/* 45 */     pwa_encens = (Item)new ItemFood(0, 0.0F, false, "pwa_encens");
/* 46 */     pwa_encre = (Item)new ItemFood(0, 0.0F, false, "pwa_encre");
/*    */   }
/*    */ }


/* Location:              C:\Users\Augma\Downloads\IDM-1.0 (1).jar!\fr\augma\iggdrasilmod\init\ItemsInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {


    //Scenario 1
    @Test
    public void addSpecificItemToCartTest() {
        landingPagePO.goToLandingPage();
        landingPagePO.goToCategory();
        ItemPagePO itemPagePO = landingPagePO.openRandomItem();
        itemPagePO.selectRandomColor();
        itemPagePO.selectRandomSize();
        String itemColor = itemPagePO.getSelectedColor();
        String itemSize = itemPagePO.getSelectedSize();
        String itemPrice = itemPagePO.getItemPrice();
        String itemTitle = itemPagePO.getItemTitle();
        itemPagePO.addToCartButtonClick();
        itemPagePO.goToCart();
        ShoppingCartPagePO shoppingCartPagePO = itemPagePO.goToViewAndEditCart();
        String itemColorInCart = shoppingCartPagePO.getItemColor();
        String itemSizeInCart = shoppingCartPagePO.getItemSize();
        String itemPriceInCart = shoppingCartPagePO.getItemPrice();
        String itemTitleInCart = shoppingCartPagePO.getItemTitle();

//        System.out.println("ITEM PAGE:");
//        System.out.println(itemColor);
//        System.out.println(itemSize);
//        System.out.println(itemPrice);
//        System.out.println(itemTitle);
//        System.out.println("CART PAGE");
//        System.out.println(itemColorInCart);
//        System.out.println(itemSizeInCart);
//        System.out.println(itemPrice);
//        System.out.println(itemTitle);

        Assert.assertEquals(itemColorInCart, itemColor);
        Assert.assertEquals(itemSizeInCart, itemSize);
        Assert.assertEquals(itemPriceInCart, itemPrice);
        Assert.assertEquals(itemTitleInCart, itemTitle);

    }


    //Scenario 2
    @Test
    public void updateQtyInShoppingCart() {
        int qty = 2;
        landingPagePO.goToLandingPage();
        landingPagePO.goToCategory();
        ItemPagePO itemPagePO = landingPagePO.openRandomItem();
        itemPagePO.selectRandomColor();
        itemPagePO.selectRandomSize();
        String itemPrice = itemPagePO.getItemPrice();
        itemPagePO.addToCartButtonClick();
        itemPagePO.goToCart();
        ShoppingCartPagePO shoppingCartPagePO = itemPagePO.goToViewAndEditCart();
        shoppingCartPagePO.setQty(qty);
        shoppingCartPagePO.updateShoppingCart();
        int subtotalPrice = shoppingCartPagePO.getSubtotalPrice();
        int itemPriceInCart = shoppingCartPagePO.getItemPriceInt();

        Assert.assertEquals(itemPriceInCart * qty, subtotalPrice);

    }


}

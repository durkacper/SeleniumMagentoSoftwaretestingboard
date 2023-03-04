import org.testng.annotations.Test;

public class AddSpecificItemToCartTest extends TestBase {


    @Test
    public void addSpecificItemToCartTest() {
        landingPagePO.goToLandingPage();
        landingPagePO.goToCategory();
        ItemPagePO itemPagePO = landingPagePO.openRandomItem();
        itemPagePO.selectRandomColor();
        itemPagePO.selectRandomSize();
        String selectedColor = itemPagePO.getSelectedColor();
        String selectedSize = itemPagePO.getSelectedSize();
        String itemPrice = itemPagePO.getItemPrice();
        String itemTitle = itemPagePO.getItemTitle();
//        System.out.println(selectedColor);
//        System.out.println(selectedSize);

        itemPagePO.addToCartButtonClick();
        //wait until addToCartButton / or cart counter is loaded
        //go to cart - view and edit cart
        //assert that title, price, size and color are correct

    }
}

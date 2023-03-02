import org.testng.annotations.Test;

public class AddHotSellerToCartTest extends TestBase {


    @Test
    public void addHotSellerToCartTest() {
    landingPagePO.goToLandingPage();
    //go to Women->Tops->Jackets
    //open random item

    ItemPagePO itemPagePO = new ItemPagePO(driver);
    itemPagePO.getItemTitle();
    itemPagePO.getItemPrice();
    itemPagePO.selectSize("M");
    itemPagePO.selectColor("Blue");



    //select random color
    //get selected color
    //select random size
    //get selected size
    }
}

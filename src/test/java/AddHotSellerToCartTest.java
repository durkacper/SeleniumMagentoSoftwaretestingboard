import org.testng.annotations.Test;

public class AddHotSellerToCartTest extends TestBase {


    @Test
    public void addHotSellerToCartTest() {
    landingPagePO.goToLandingPage();
    landingPagePO.addRandomItemToCart();
    }
}

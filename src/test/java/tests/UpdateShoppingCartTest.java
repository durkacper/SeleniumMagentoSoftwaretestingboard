package tests;

import data.ExcelDataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ShoppingCartPage;
import testComponents.TestBase;

public class UpdateShoppingCartTest extends TestBase {

    //Test002
    @Test(dataProvider = "testData")
    public void updateShoppingCartTest(String url, String qty) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        landingPage.goToLandingPage(url)
                .goToWomenJacketsCategory()
                .openRandomItem()
                .selectRandomSize()
                .selectRandomColor()
                .addToCartButtonClick()
                .goToCart()
                .goToViewAndEditCart()
                .setQty(Integer.parseInt(qty))
                .updateShoppingCart();
        int itemPriceInCart = shoppingCartPage.getItemPriceInt();
        int subtotalPrice = shoppingCartPage.getSubtotalPrice();

        Assert.assertEquals(itemPriceInCart * Integer.parseInt(qty), subtotalPrice);
    }

    @DataProvider
    public Object[][] testData() throws Exception {
        Object[][] testData = ExcelDataReader.getExcelData(System.getProperty("user.dir") + "/data.xlsx", "Test002");
        return testData;
    }
}

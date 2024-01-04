package tests;

import data.ExcelDataReader;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;
import testComponents.TestBase;
import pageObjects.ItemPage;
import pageObjects.ShoppingCartPage;
import org.testng.annotations.Test;

public class AddItemToCartTest extends TestBase {

    //Test001
    @Test(dataProvider = "testData")
    public void addSpecificItemToCartTest(String url) {
        ItemPage itemPage = new ItemPage(driver);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        landingPage.goToLandingPage(url)
                .goToWomenJacketsCategory()
                .openRandomItem()
                .selectRandomSize()
                .selectRandomColor();
        String itemColor = itemPage.getSelectedColor();
        String itemSize = itemPage.getSelectedSize();
        String itemPrice = itemPage.getItemPrice();
        String itemTitle = itemPage.getItemTitle();
        itemPage.addToCartButtonClick()
                .goToCart()
                .goToViewAndEditCart();
        String itemColorInCart = shoppingCartPage.getItemColor();
        String itemSizeInCart = shoppingCartPage.getItemSize();
        String itemPriceInCart = shoppingCartPage.getItemPrice();
        String itemTitleInCart = shoppingCartPage.getItemTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(itemColorInCart, itemColor);
        softAssert.assertEquals(itemSizeInCart, itemSize);
        softAssert.assertEquals(itemPriceInCart, itemPrice);
        softAssert.assertEquals(itemTitleInCart, itemTitle);
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] testData() throws Exception {
        Object[][] testData = ExcelDataReader.getExcelData(System.getProperty("user.dir") + "/data.xlsx", "Test001");
        return testData;
    }
}

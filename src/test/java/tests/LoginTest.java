package tests;

import com.beust.ah.A;
import data.ExcelDataReader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.TestBase;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends TestBase {

    //Test004
    @Test(dataProvider = "testData004")
    public void loginWithCorrectCredentials(String url, String email, String password, String firstName, String lastName) throws InterruptedException {
        String loggedInUserName = landingPage.goToLandingPage(url)
                .goToLoginPage()
                .logIn(email, password)
                .getLoggedInUserName();

        Assert.assertEquals(loggedInUserName, firstName + " " + lastName + "!");
    }

    //Test005
    @Test(dataProvider = "getInvalidLoginData")
    public void loginWithInvalidCredentials(HashMap<String, String> input) throws InterruptedException {
        String loggedInUserName = landingPage.goToLandingPage(input.get("url"))
                .goToLoginPage()
                .logIn(input.get("invalidEmail"), input.get("invalidPassword"))
                .getLoggedInUserName();

        Assert.assertEquals(loggedInUserName, input.get("firstName") + " " + input.get("lastName") + "!");
    }

    @DataProvider
    public Object[][] testData004() throws Exception {
        Object[][] testData = ExcelDataReader.getExcelData(System.getProperty("user.dir") + "/data.xlsx", "Test004");
        return testData;
    }

    @DataProvider
    public Object[][] getInvalidLoginData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/data/loginData.json");
        return new Object[][]{{data.get(0)}};
    }
}

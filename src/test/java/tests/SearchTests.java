package tests;

import data.ExcelDataReader;
import org.testng.annotations.DataProvider;
import testComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends TestBase {

    //Test003
    @Test(dataProvider = "testData003")
    public void advancedSearchTest(String url, String productName) {
        String productNameAdvancedSearchResults = landingPage.goToLandingPage(url)
                .goToAdvancedSearch()
                .setProductName(productName)
                .advancedSearchResults()
                .getProductName();

        Assert.assertEquals(productNameAdvancedSearchResults, productName);
    }

    //Test006
    @Test(dataProvider = "testData006")
    public void searchFiltersTest(String url, String eco, String size, String color) {
        List<String> currentFilters = landingPage.goToLandingPage(url)
                .goToWomenJacketsCategory()
                .selectSizeFilter(size)
                .selectColorFilter(color)
                .selectEcoCollectionFilter(eco)
                .getCurrentFilters();

        Assert.assertTrue(currentFilters.contains("Yes"));
        Assert.assertTrue(currentFilters.contains("M"));
        Assert.assertTrue(currentFilters.contains("Blue"));
    }

    @DataProvider
    public Object[][] testData003() throws Exception {
        Object[][] testData = ExcelDataReader.getExcelData(System.getProperty("user.dir") + "/data.xlsx", "Test003");
        return testData;
    }

    @DataProvider
    public Object[][] testData007() throws Exception {
        Object[][] testData = ExcelDataReader.getExcelData(System.getProperty("user.dir") + "/data.xlsx", "Test006");
        return testData;
    }
}

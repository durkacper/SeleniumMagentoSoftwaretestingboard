import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchFiltersTest extends TestBase {

    @Test
    public void searchFiltersTest() {
        landingPagePO.goToLandingPage();
        landingPagePO.goToCategory();
        JacketsPage jacketsPagePO = new JacketsPage(driver);
        jacketsPagePO.selectStyleFilter("Jacket");
        jacketsPagePO.selectSizeFilter("M");
        jacketsPagePO.selectColorFilter("Blue");
        List<String> currentFilters = jacketsPagePO.getCurrentFilters();

        Assert.assertTrue(currentFilters.contains("Jacket"));
        Assert.assertTrue(currentFilters.contains("M"));
        Assert.assertTrue(currentFilters.contains("Blue"));
    }

}

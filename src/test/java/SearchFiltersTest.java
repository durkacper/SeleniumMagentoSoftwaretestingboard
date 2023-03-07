import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFiltersTest extends TestBase {

    @Test
    public void searchFiltersTest() {
        landingPagePO.goToLandingPage();
        landingPagePO.goToCategory();
        JacketsPagePO jacketsPagePO = new JacketsPagePO(driver);
        jacketsPagePO.selectStyleFilter("Jacket");
        jacketsPagePO.selectSizeFilter("M");
        jacketsPagePO.selectColorFilter("Blue");
        jacketsPagePO.getCurrentFilters();

        //Assert.
    }

}

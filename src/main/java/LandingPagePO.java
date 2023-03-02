import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPagePO extends BasePO{

    WebDriver driver;

    public LandingPagePO(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }






    public void goToLandingPage(){
        driver.get("https://magento.softwaretestingboard.com/");
    }
}

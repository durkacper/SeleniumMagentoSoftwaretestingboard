import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    WebDriver driver;
    LandingPagePO landingPagePO;

    public WebDriver initializeWebDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


    @BeforeMethod
    public LandingPagePO launchApp(){
        driver = initializeWebDriver();
        landingPagePO = new LandingPagePO(driver);
        landingPagePO.goToLandingPage();
        return landingPagePO;
    }

}

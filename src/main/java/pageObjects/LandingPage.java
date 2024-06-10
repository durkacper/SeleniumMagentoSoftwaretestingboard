package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageComponents.BasePage;

public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[2]")
    private WebElement womenCategory;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[2]/ul/li[1]")
    private WebElement womenTopsCategory;

    @FindBy(xpath = "//ul[@id='ui-id-2']/li[2]/ul/li[1]/ul/li[1]")
    private WebElement womenJacketsCategory;

    @FindBy(css = "div.footer.content a[data-action='advanced-search']")
    private WebElement advancedSearch;

    @FindBy(xpath = "//div[@class='panel header']/ul[@class='header links']/li[@class='authorization-link']/a")
    private WebElement signInButton;

    @FindBy(css = "div.panel.header li.greet.welcome")
    private WebElement userMenuButton;

    public String getLoggedInUserName() throws InterruptedException {
        Thread.sleep(2000);
        String userNameText = userMenuButton.getText().substring(9);
        return userNameText;
    }

    public LoginPage goToLoginPage(){
        waitUntilElementIsVisible(signInButton);
        signInButton.click();
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;
    }

    public AdvancedSearchPage goToAdvancedSearch(){
        waitUntilElementIsVisible(advancedSearch);
        advancedSearch.click();
        AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
        return advancedSearchPage;
    }

    public ResultsPage goToWomenJacketsCategory() {
        waitUntilElementIsVisible(womenCategory);
        Actions actions = new Actions(driver);
        actions.moveToElement(womenCategory).moveToElement(womenTopsCategory).moveToElement(womenJacketsCategory).build().perform();
        womenJacketsCategory.click();
        ResultsPage resultsPage = new ResultsPage(driver);
        return resultsPage;
    }

    public LandingPage goToLandingPage(String url){
        driver.get(url);
        return this;
    }
}

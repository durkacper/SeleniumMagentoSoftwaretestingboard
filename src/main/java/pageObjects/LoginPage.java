package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageComponents.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "pass")
    private WebElement passwordBox;

    @FindBy(id = "send2")
    private WebElement signInButton;

    public LandingPage logIn(String email, String password){
        waitUntilElementIsVisible(emailBox);
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        signInButton.click();
        LandingPage landingPage = new LandingPage(driver);
        return landingPage;
    }
}

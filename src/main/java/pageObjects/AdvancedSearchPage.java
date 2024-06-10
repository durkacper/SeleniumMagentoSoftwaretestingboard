package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageComponents.BasePage;

public class AdvancedSearchPage extends BasePage {

    public AdvancedSearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[title='Product Name']")
    private WebElement productNameBox;

    @FindBy(css = "button.action.search.primary")
    private WebElement searchButton;

    public AdvancedSearchPage setProductName(String productName){
        waitUntilElementIsVisible(productNameBox);
        productNameBox.sendKeys(productName);
        return this;
    }

    public ResultsPage advancedSearchResults(){
        searchButton.click();
        ResultsPage resultsPage = new ResultsPage(driver);
        return resultsPage;
    }
}

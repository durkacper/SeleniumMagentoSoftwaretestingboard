package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageComponents.BasePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.filter-options-item")
    private List<WebElement> shoppingOptionsList;

    @FindBy(xpath = "//div[@class='filter-options-content']/ol/li/a")
    private List<WebElement> styleNamesList;

    @FindBy(css = "div.filter-options-content a div")
    private List<WebElement> sizeNamesList;

    @FindBy(css = "div.filter-options-content a div")
    private List<WebElement> colorNamesList;

    @FindBy(css = "div.filter-current ol.items li span.filter-value")
    private List<WebElement> currentFilters;

    @FindBy(css = "li.product-item div.product-item-info a.product")
    private List<WebElement> itemsList;

    @FindBy(css = "strong.product-item-name a")
    private WebElement productName;

    public String getProductName(){
        waitUntilElementIsVisible(productName);
        String productNameText = productName.getText();
        return productNameText;
    }

    public ItemPage openRandomItem() {
        Random random = new Random();
        int randomValue = random.nextInt(itemsList.size());
        itemsList.get(randomValue).click();
        ItemPage itemPage = new ItemPage(driver);
        return itemPage;
    }

    public List<String> getCurrentFilters() {
        List<String> filters = new ArrayList<>();
        for (int i = 0; i < currentFilters.size(); i++) {
            filters.add(currentFilters.get(i).getText());
        }
        //System.out.println(filters);
        return filters;
    }

    public ResultsPage selectEcoCollectionFilter(String eco) {
        for (int i = 0; i < shoppingOptionsList.size(); i++) {
            String optionName = shoppingOptionsList.get(i).getText();
            if (optionName.equalsIgnoreCase("ECO COLLECTION")) {
                shoppingOptionsList.get(i).click();
                for (int j = 0; j < styleNamesList.size(); j++) {
                    String styleName = styleNamesList.get(j).getText();
                    if (styleName.contains(eco)) {
                        styleNamesList.get(j).click();
                    }
                }
            }
        }
        return this;
    }

    public ResultsPage selectSizeFilter(String size) {
        for (int i = 0; i < shoppingOptionsList.size(); i++) {
            String optionName = shoppingOptionsList.get(i).getText();
            if (optionName.equalsIgnoreCase("SIZE")) {
                shoppingOptionsList.get(i).click();
                for (int j = 0; j < sizeNamesList.size(); j++) {
                    String sizeName = sizeNamesList.get(j).getText();
                    if (sizeName.equalsIgnoreCase(size)) {
                        sizeNamesList.get(j).click();
                    }
                }
            }
        }
        return this;
    }

    public ResultsPage selectColorFilter(String color) {
        for (int i = 0; i < shoppingOptionsList.size(); i++) {
            String optionName = shoppingOptionsList.get(i).getText();
            if (optionName.equalsIgnoreCase("COLOR")) {
                shoppingOptionsList.get(i).click();
                for (int j = 0; j < colorNamesList.size(); j++) {
                    String colorName = colorNamesList.get(j).getAttribute("option-label");
                    if (colorName.equalsIgnoreCase(color)) {
                        colorNamesList.get(j).click();
                    }
                }
            }
        }
        return this;
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ItemPagePO extends BasePO {

    public ItemPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "h1.page-title")
    WebElement itemTitle;

    @FindBy(css = "div.product-info-main div.product-info-price span.price")
    WebElement itemPrice;

    @FindBy(css = "div.swatch-option.swatch-option.text")
    List<WebElement> sizesList;

    @FindBy(css = "div.swatch-option.swatch-option.color")
    List<WebElement> colorsList;




    public void selectColor(String color){
        for (int i = 0; i < colorsList.size(); i++) {
            String sizeText = colorsList.get(i).getText();
            if(sizeText.equalsIgnoreCase(color)){
                colorsList.get(i).click();
            }
        }
    }


    public void selectSize(String size){
        for (int i = 0; i < sizesList.size(); i++) {
            String sizeText = sizesList.get(i).getText();
            if(sizeText.equalsIgnoreCase(size)){
                sizesList.get(i).click();
            }
        }
    }

    public void getItemPrice(){
        itemPrice.getText();
    }

    public void getItemTitle() {
        itemTitle.getText();
    }


}

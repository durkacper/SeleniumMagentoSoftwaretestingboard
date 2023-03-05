import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPagePO extends BasePO {

    public ShoppingCartPagePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/dl/dd[1]")
    WebElement itemSize;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/dl/dd[2]")
    WebElement itemColor;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[1]/div/strong/a")
    WebElement itemTitle;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr[1]/td[2]//span[@class='price']")
    WebElement itemPrice;


    public String getItemPrice() {
        return itemPrice.getText();
    }

    public String getItemTitle() {
        return itemTitle.getText();
    }

    public String getItemSize() {
        return itemSize.getText();
    }

    public String getItemColor() {
        return itemColor.getText();
    }

}

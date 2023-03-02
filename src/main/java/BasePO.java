import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BasePO {

    WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='product-item']/div/a")
    List<WebElement> itemsList;

    @FindBy
    WebElement womenCategory;

    public ItemPagePO openRandomItem() {
        Random random = new Random();
        int randomValue = random.nextInt(itemsList.size());
        itemsList.get(randomValue).click();
        ItemPagePO itemPagePO = new ItemPagePO(driver);
        return itemPagePO;
    }
}

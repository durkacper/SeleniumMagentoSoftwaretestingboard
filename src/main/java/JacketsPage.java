import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JacketsPage extends BasePage {

    public JacketsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JacketsPagePO extends BasePO{

    public JacketsPagePO (WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}

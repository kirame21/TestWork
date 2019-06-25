import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public class AutoTest {

    private WebDriver driver;
    public WebDriverWait wait;
    public Randomizer randomizer;
    public Helpers helper;
    public JavascriptExecutor jse;

    @DataProvider
    public Object[][] routes(){
        return new Object[][]{
                {"https://www.pkwteile.de/ "},
        };
    }

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver,15);
        helper = new Helpers(driver);
        jse = (JavascriptExecutor) driver;
        randomizer = new Randomizer();
    }


    @Test (dataProvider = "routes")
    public void test(String route) throws InterruptedException{

        driver.get(route);

        //register with random email and password
        String new_email =  randomizer.generateEmail();
        String new_password =  randomizer.generatePass();
        helper.register(new_email, new_password);

        //navigate to mail and open received email
        driver.navigate().to("https://www.mailinator.com/v3/index.jsp?zone=public&query=" + new_email.substring(0, 14) + "#/#inboxpane");
        driver.findElement(AutoTestLocators.fldЕmailRegistration).click();

        //can't find link to pkw, open new tab - navigate to site, closed the old one
        jse.executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.navigate().to("https://www.pkwteile.de/ ");
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));

        //logout and login again
        helper.logout();
        helper.login(new_email, new_password);

        //select car
        helper.selectCar("BMW","3 Coupe (E36) (03.1992 - 04.1999)","325i 2.5 (141 KW / 192 PS) (03.1992 - 04.1999)");
        helper.findElement(AutoTestLocators.btnSearch).click();

        //go to category
        helper.findElement(AutoTestLocators.txtCategoryNameBremsanlage).click();
        helper.findElement(AutoTestLocators.txtCategoryNameBremsbelage).click();

        // check prices and product to cart
        helper.checkPrices();
        helper.addToCart(3);

        //create order with already added product
        helper.createOrder();

    }

    @AfterTest
    public  void quit(){
        driver.quit();
    }

}

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class Helpers {

    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor javaExecutor;

    public Helpers(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        javaExecutor = (JavascriptExecutor) driver;
    }

    public WebElement findElement (By locator){
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator);
    }

    public void register(String email, String password){
        findElement(HelpersLocators.popupProfile).click();
        findElement(HelpersLocators.linkRegister).click();
        findElement(HelpersLocators.fldEmail).sendKeys(email);
        findElement(HelpersLocators.fldPassword).sendKeys(password);
        findElement(HelpersLocators.fldConfirmPassword).sendKeys(password);
        findElement(HelpersLocators.chkGDPR).click();
        findElement(HelpersLocators.btnSubmitRegister).click();
    }

    public void logout(){
        findElement(HelpersLocators.btnLogout).click();
    }

    public void login(String email, String password){
        findElement(HelpersLocators.popupProfile).click();
        findElement(HelpersLocators.fldEmailLogin).sendKeys(email);
        findElement(HelpersLocators.fldPasswordLogin).click();
        driver.findElement(HelpersLocators.fldPasswordLogin).sendKeys(password);
        findElement(HelpersLocators.btnLogin).click();
        findElement(HelpersLocators.btnCloseLoginPopup).click();
    }

    public void selectCar(String maker, String model, String motor ){
        Select maker2 = new Select(findElement(HelpersLocators.slctrMaker));
        maker2.selectByVisibleText(maker);
        Select model2 = new Select(findElement(HelpersLocators.slctrModel));
        model2.selectByVisibleText(model);
        Select motor2 = new Select(findElement(HelpersLocators.slctrMotor));
        motor2.selectByVisibleText(motor);
    }

    public void checkPrices(){
        List<WebElement> productPricesElementsList = driver.findElements(HelpersLocators.txtPrices);
        List<Double> productPricesList = new ArrayList<Double>();
        for (WebElement price : productPricesElementsList){
            Double dprice = Double.parseDouble(price.getText().substring(0,5).replace(",", "."));
            productPricesList.add(dprice);
        }
        Double prevPrice = 0.00;
        for (Double price : productPricesList){
            if(price >= prevPrice){
                System.out.println(price);
                prevPrice = price;
            }
            else{
                System.out.println("prices aren't ascending!");
            }
        }
    }

    public void addToCart( Integer productNumber){
        List<WebElement> btnAddToCartList = driver.findElements(HelpersLocators.btnAddToCart);
        do {
            btnAddToCartList.get(productNumber).click();
        }
        while (findElement(HelpersLocators.txtCountProductsInCart).getText() == "0");
    }

    public void createOrder (){
        findElement(HelpersLocators.blockGoToCart).click();
        findElement(HelpersLocators.btnGoAdressStepCart).click();
        findElement(HelpersLocators.fldSurname).sendKeys("test");
        findElement(HelpersLocators.fldName).sendKeys("test");
        findElement(HelpersLocators.fldStreet).sendKeys("test");
        findElement(HelpersLocators.fldHouse).sendKeys("12");
        findElement(HelpersLocators.fldPostcode).sendKeys("12345");
        findElement(HelpersLocators.fldPosition).sendKeys("1234");
        findElement(HelpersLocators.fldPhone).sendKeys("200+002");
        findElement(HelpersLocators.btnGoNextStepCart).click();
        findElement(HelpersLocators.blockVorkasse).click();
        findElement(HelpersLocators.btnGoNextStepCart).click();
        findElement(HelpersLocators.btnCompleteOrder).click();
        findElement(HelpersLocators.btnClosePopupAfterOrder).click();
        System.out.println("Order: " + findElement(HelpersLocators.txtOrder).getText());

    }

}

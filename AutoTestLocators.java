import org.openqa.selenium.By;

public class AutoTestLocators {

    public static By fldЕmailRegistration = By.xpath("//td[contains(text(),'Ihre Registrierung bei Pkwteile.de')]");
//    public static By linkHome = By.linkText("https://www.pkwteile.de");
    public static By btnSearch = By.xpath("//div[@id='selector-wrapper']//div[@class='mainblock-search__button']");
    public static By txtCategoryNameBremsanlage = By.xpath("//span[@class='name'][contains(text(),'Bremsanlage')]");
    public static By txtCategoryNameBremsbelage = By.linkText("Bremsbeläge");



}
import org.openqa.selenium.By;

public class HelpersLocators {

    public static By popupProfile = By.xpath("//div[@class='header__login-status sign']");
    public static By linkRegister = By.xpath("//a[@id='reg_pop']");
    public static By fldEmail = By.xpath("//input[@id='email']");
    public static By fldPassword = By.xpath("//input[@id='Password']");
    public static By fldConfirmPassword = By.xpath("//input[@id='new_pass_confirm']");
    public static By chkGDPR = By.xpath("//div[@class='login_panel_modals']//div[@class='privacy_policy_checkbox']");
    public static By btnSubmitRegister = By.xpath("//a[@class='register_submit']");
    public static By btnLogout = By.xpath("//div[6]/header[1]/div[2]/div[1]/div[3]/div[1]/span[1]/img[1]");
    public static By fldEmailLogin = By.xpath("//input[@id='login_top_email']");
    public static By fldPasswordLogin = By.xpath("//input[@name='Password_fake']");
    public static By btnLogin = By.xpath("//a[contains(text(),'Einloggen')]");
    public static By btnCloseLoginPopup = By.xpath("//div[@id='login_complete']//a[@class='close']");
    public static By slctrMaker = By.xpath("//select[@id='form_maker_id']");
    public static By slctrModel = By.xpath("//select[@id='form_model_id']");
    public static By slctrMotor = By.xpath("//select[@id='form_car_id']");
    public static By txtPrices = By.cssSelector("span[itemprop = price]");
    public static By btnAddToCart = By.xpath("//a[@class='indenwarenkorb'][contains(text(),'In den Warenkorb')]");
    public static By txtCountProductsInCart = By.xpath("//span[@class='header__cart-count-qty count']");
    public static By blockGoToCart = By.xpath("//a[@id='cart_block_link']");
    public static By btnGoAdressStepCart = By.xpath("//a[@class='next-step basket_submit ga-click']");
    public static By fldSurname = By.xpath("//input[@id='form_lVorname']");
    public static By fldName = By.xpath("//input[@id='form_lName']");
    public static By fldStreet = By.xpath("//input[@id='form_lStrasse']");
    public static By fldHouse = By.xpath("//input[@id='form_delivery_house']");
    public static By fldPostcode = By.xpath("//input[@id='form_lPlz']");
    public static By fldPosition = By.xpath("//input[@id='form_lOrt']");
    public static By fldPhone = By.xpath("//input[@id='form_lTelefon']");
    public static By btnGoNextStepCart = By.xpath("//a[contains(text(),'Weiter')]");
    public static By blockVorkasse = By.xpath("//div[contains(text(),'Vorkasse')]");
    public static By btnCompleteOrder = By.xpath("//div[@class='alldata-bottom']//a[@class='next-step'][contains(text(),'Jetzt kaufen')]");
    public static By btnClosePopupAfterOrder = By.xpath("//span[@class='popup-after-order__close']");
    public static By txtOrder = By.xpath("//div[@class='success-order__info']/span");

}

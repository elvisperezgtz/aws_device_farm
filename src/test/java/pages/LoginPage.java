package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;

    /**
     * A base constructor that sets the page's driver
     * <p>
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     * <p>
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     *
     * @param driver the appium driver created in the beforesuite method.
     */


    @AndroidFindBy(xpath = "//*[@text='AHORA NO']")
    private MobileElement ahoraNoButton;
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text,'INGRESAR CON CORREO')] | //*[@resource-id=\"goToLogin\"]")
    private MobileElement ingresarConCorreoButton;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private MobileElement campoCorreo;
    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private MobileElement campoPassword;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='enterOk']")
    private MobileElement botonIngresar;
    @AndroidFindBy(xpath ="//*[@text='Mis Servicios']")
    private MobileElement tituloMisServicios;


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean login(String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOf(ahoraNoButton));
//        if (ahoraNoButton.isDisplayed()){
//            ahoraNoButton.click();
//        }

        ingresarConCorreoButton.click();
        boolean usernameStatus = sendKeysToElement(username, campoCorreo,false);
        campoPassword.click();
        Thread.sleep(KEYBOARD_ANIMATION_DELAY);
        campoPassword.sendKeys(password);
        botonIngresar.click();
        return usernameStatus;
    }
    public boolean getTitleServices(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(tituloMisServicios));
        return tituloMisServicios.isDisplayed();
    }

}

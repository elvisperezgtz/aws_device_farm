package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    @AndroidFindBy(xpath = "//*[@text='Mis Servicios']")
    private MobileElement tituloMisServicios;
    @AndroidFindBy(xpath = "//*[@text='SALTAR']")
    private MobileElement biometricoEnOtroMomento;
//    @AndroidFindBy(xpath = "//*[@text='EN OTRO MOMENTO']")
//    private MobileElement biometricoEnOtroMomento;

    /**
     * Navigation elements
     *
     * @param driver
     */
    @AndroidFindBy(xpath = "//*[contains(@text,'3044591227')]")
    private MobileElement linea;
    @AndroidFindBy(xpath = "//*[@text='selectTab1']")
    private MobileElement tabFactura;
    @AndroidFindBy(xpath = "//*[@text='selectTab2']")
    private MobileElement tabConsumos;
    @AndroidFindBy(xpath = "//*[@text='selectTab3']")
    private MobileElement tabServicios;
    @AndroidFindBy(xpath = "//*[@text='selectTab4']")
    private MobileElement tabCompras;

    /**
     * shop tabs
     *
     * @param driver
     */

    @AndroidFindBy(xpath = "//*[@text='internet']")
    private MobileElement tabInternetCompras;

    @AndroidFindBy(xpath = "//*[@text='Voz y SMS']")
    private MobileElement tabVozCompras;
    @AndroidFindBy(xpath = "//*[@text='Recargas']")
    private MobileElement tabRecargasCompras;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }


    public boolean login(String username, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.elementToBeClickable(ahoraNoButton));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ahoraNoButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ingresarConCorreoButton.click();
        boolean usernameStatus = sendKeysToElement(username, campoCorreo, false);
        campoPassword.click();
        Thread.sleep(KEYBOARD_ANIMATION_DELAY);
        campoPassword.sendKeys(password);
        botonIngresar.click();
        wait.until(ExpectedConditions.elementToBeClickable(biometricoEnOtroMomento));
        biometricoEnOtroMomento.click();
        return usernameStatus;
    }

    public void seleccionarLinea() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(linea));
        linea.click();
    }

    public void navigationMenuServices() {
        seleccionarLinea();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tabFactura.click();
        esperar();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tabConsumos.click();
        esperar();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tabServicios.click();
        esperar();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tabCompras.click();
        esperar();
        navegarEnCompras();

    }

    public boolean getTitleServices() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(tituloMisServicios));
        return tituloMisServicios.isDisplayed();
    }

    public void navegarEnCompras() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        tabInternetCompras.click();
        esperar();
        tabVozCompras.click();
        esperar();
        tabRecargasCompras.click();
        esperar();


    }
    public void esperar(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

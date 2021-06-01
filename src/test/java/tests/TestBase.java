package tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import pages.NavigationPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    public static AndroidDriver<MobileElement> driver;

    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
    public abstract String getName();

    /**
     * A page containing the navigation drawer
     */


    /**
     * Method to initialize the test's page
     */
    @BeforeTest
    public abstract void setUpPage();


    @BeforeSuite
    public void setUpAppium() throws MalformedURLException {

        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("automationName", "uiautomator2");
//        capabilities.setCapability("platformName", "Android");
//        capabilities.setCapability("platformVersion", "10");
//        capabilities.setCapability("deviceName", "emulator-5554");
  //      capabilities.setCapability("appPackage", "com.mobiquityinc.mitigo");
//        capabilities.setCapability("app", "C:\\indra backup\\REPO\\tigo_colombia\\mobile\\oneapp\\src\\test\\resources\\app\\app-debug_UAT_5.1.0 (709).apk");
      //  capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
//        capabilities.setCapability("noReset", false);

        driver = new AndroidDriver<MobileElement>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
    }

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium() {
        driver.quit();
    }

    /**
     *
     *  Creates a navigation page and navigates to the Class' category
     *  within the navigation drawer
     *
     */

    /**
     * Restart the app after every test class to go back to the main
     * screen and to reset the behavior
     */
    @AfterClass
    public void restartApp() {
        driver.resetApp();
    }
}

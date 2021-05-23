package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NavigationPage extends BasePage {
    private final int TRIES = 5;

    /**
     * Get the toggle button
     */
    @AndroidFindBy(accessibility = "ReferenceApp")
    private WebElement toggle;

    public NavigationPage(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Go to a specific category within the navigation drawer
     *
     * @param categoryName category
     */
    public void gotoCategory(String categoryName) {
        int counter = 0;
        toggle.click();
        try {
            Thread.sleep(WaitConfig.DRAWER_ANIMATION_WAIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement categoryElement = null;
        List<WebElement> categoryElements;

        while (categoryElement == null) {
            counter++;
            if (counter == TRIES)
                return;
            categoryElements = driver.findElementsById("com.amazonaws.devicefarm.android.referenceapp:id/drawer_row_title");
            for (WebElement categoryTitleElement: categoryElements){
                String titleText = categoryTitleElement.getText();
                if (titleText.equalsIgnoreCase(categoryName)) categoryElement = categoryTitleElement;

            }
            if (categoryElement == null) {
                driver.scrollTo(categoryName);
            }
        }

        categoryElement.click();
    }
}

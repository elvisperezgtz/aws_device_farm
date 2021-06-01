package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestBase{
    private static final String LOGIN_SUCCESS_MESSAGE = "You are logged on as admin";
    private static final String LOGIN_FAIL_MESSAGE = "You gave me the wrong username and password";
    private static final String CORRECT_USER_NAME = "automatizacionmicuenta@gmail.com";
    private static final String CORRECT_PASSWORD = "Tigo2019";
    private static final String FAIL_USER_NAME = "Wrong User";
    private static final String FAIL_PASSWORD = "12345";
    private static final String BAD_TEXT_ENTRY_MSG = "Username sent to text field incorrectly";

    private LoginPage loginPage;

    @Override
    public String getName() {
        return "Login Page";
    }

    /**
     * Creates a login
     */
    @BeforeTest
    @Override
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     */
    @Test
    public void loginSuccess() throws InterruptedException {
        Assert.assertTrue(loginPage.login(CORRECT_USER_NAME, CORRECT_PASSWORD), BAD_TEXT_ENTRY_MSG);
        loginPage.navigationMenuServices();
//        Assert.assertEquals(loginPage.getTitleServices(), true);
    }

    /**
     * Tests logging in with invalid credentials by verifying if the error message is correct
     */
//    @Test
//    public void loginFail() throws InterruptedException {
//        Assert.assertTrue(loginPage.login(FAIL_USER_NAME, FAIL_PASSWORD), BAD_TEXT_ENTRY_MSG);
//        Assert.assertEquals(loginPage.getMessage(), LOGIN_FAIL_MESSAGE);
//    }

}

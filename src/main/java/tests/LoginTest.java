package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;



public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {
        // Step 1: Navigate to the login page
        LoginPage loginPage = new LoginPage(driver);

        // Step 2: Perform login with valid credentials
        loginPage.login("standard_user", "secret_sauce");

        // Step 3: Verify the login was successful by checking the URL
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login was not successful.");
    }

    @Test  //valid user and password
    public void testInvalidLogin() {
        //Attempt login with invalid credentials
        loginPage.login("invalid_user", "wrong_password");
        // Verify the error message is displayed
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Epic sadface: Username and password do not match any user in this service"),
                "Expected error message was not displayed.");
    }

}

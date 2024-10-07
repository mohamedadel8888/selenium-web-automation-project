package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTest extends BaseTest {

    @Test
    public void testProductPageLoadCorrectly(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        int numberOfProducts = productsPage.getNumberOfProducts();
        Assert.assertEquals(6, numberOfProducts , "Incorrect number of products");
    }
}

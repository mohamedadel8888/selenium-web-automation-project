package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;


public class CartTest extends BaseTest {
    LoginPage loginPage;

    @Test // add all items in cart
    public void testAllItemsPlacedInCart() {
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        int numberOfProducts = productsPage.getNumberOfProducts();
        for (int i = 0; i < numberOfProducts; i++) {
            productsPage.addProductToCart(i);
        }
        productsPage.clickOnCartIcon();
        Assert.assertEquals(cartPage.getNumberOfItemsInCart(),numberOfProducts);
    }
    @Test // add 2 items and delete all items
    public void testAddAndRemoveAllItemsFromCart() {
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCart(0);
        productsPage.addProductToCart(3);
        CartPage cartPage = new CartPage(driver);
        productsPage.clickOnCartIcon();
        while (cartPage.getNumberOfItemsInCart()!=0) {
            cartPage.removeItemByIndex(0);
        }
        Assert.assertEquals(cartPage.getNumberOfItemsInCart(),0);
    }
}

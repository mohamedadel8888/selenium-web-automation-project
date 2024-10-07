package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    // Locators for the product items and add to cart buttons
    @FindBy(className = "inventory_item")
    List<WebElement> productItems;

    @FindBy(css = ".btn_inventory")
    List<WebElement> addToCartButtons;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;

    @FindBy(css = ".product_sort_container")
    WebElement sortIcon;

    @FindBy(id="react-burger-menu-btn")
    WebElement MenuBtn;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Add a product to the cart by index
    public void addProductToCart(int index) {
        addToCartButtons.get(index).click();
    }
    //get number of products in cart
    public int getNumberOfProducts() {
        return productItems.size();
    }
    // Click on the cart icon to go to the cart page
    public void clickOnCartIcon() {
            cartIcon.click();
    }

}

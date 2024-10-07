package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    @FindBy(css = ".inventory_item_name")
    List<WebElement> productNames;

    @FindBy(css = ".cart_button")
    List<WebElement> removeButtons;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Get the number of items in the cart
    public int getNumberOfItemsInCart() {
        return productNames.size();
    }

    // Get the product name by index
    public String getProductNameByIndex(int index) {
        return productNames.get(index).getText();
    }
    // Remove an item from the cart by index
    public void removeItemByIndex(int index) {
        removeButtons.get(index).click();
    }
    // Proceed to checkout
    public void clickProceedToCheckout() {
        checkoutButton.click();
    }
}

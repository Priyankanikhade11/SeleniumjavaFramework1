package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;

    private By cartItemCount = By.cssSelector(".cart-count");
    private By checkoutSummary = By.cssSelector(".checkout-summary-total");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyItemCount(int expectedCount) {
        int actualCount = Integer.parseInt(driver.findElement(cartItemCount).getText());
        Assert.assertEquals(actualCount, expectedCount, "Cart count mismatch!");
    }

    public void verifyCheckoutSummary(String expectedTotal) {
        String actualTotal = driver.findElement(checkoutSummary).getText();
        Assert.assertEquals(actualTotal, expectedTotal, "Checkout summary mismatch!");
    }
}

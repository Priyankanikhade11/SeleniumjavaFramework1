package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;

    private By bagButton = By.xpath("//span[@id='cartCount']"); 
    private By itemCount = By.xpath("//span[@class='bag-item-count']");
    private By checkoutSummaryPrice = By.xpath("//div[@class='card-summary p-3 mb-3']//span[contains(text(),'₹')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void BagButton() {
        driver.findElement(bagButton).click();
        System.out.println(" Opened Cart.");
    }

    public void verifyItemCount(int expectedCount) {
        String countText = driver.findElement(itemCount).getText().trim();
        int actualCount = Integer.parseInt(countText);
        System.out.println(" Cart Item Count Displayed: " + actualCount);
        Assert.assertEquals(actualCount, expectedCount, "Item count mismatch in cart!");
    }

    public String getCheckoutSummaryPrice() {
        String actualPrice = driver.findElement(checkoutSummaryPrice).getText().trim();
        System.out.println(" Checkout Summary Price in Cart: " + actualPrice);
        return actualPrice;
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage {
    private WebDriver driver;

    private By bagIcon = By.xpath("//span[@id='cartCount']"); 
    private By itemCount = By.xpath("//span[@class='ms-2']");
    private By checkoutSummaryPrice = By.xpath("//div[@class='card-summary p-3 mb-3']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void BagButton() {
        driver.findElement(bagIcon).click();
    }

    public void verifyItemCount(int expectedCount) {
        String countText = driver.findElement(itemCount).getText().trim();
        // Clean string: remove everything except digits
        countText = countText.replaceAll("[^0-9]", "");
        int actualCount = Integer.parseInt(countText);
        Assert.assertEquals(actualCount, expectedCount, "Item count mismatch in cart!");
    }

    public void verifyCheckoutSummary(String expectedPrice) {
        String actualPrice = driver.findElement(checkoutSummaryPrice).getText().trim();
        Assert.assertEquals(actualPrice, expectedPrice, "Price mismatch in checkout summary!");
    }
    
}

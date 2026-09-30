package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPage {
    private WebDriver driver;

    private By productPrice = By.cssSelector(".product-price");
    private By addToCartButton = By.xpath("//button[contains(text(),'Add to Cart')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyPrice(String expectedPrice) {
        String actualPrice = driver.findElement(productPrice).getText();
        Assert.assertEquals(actualPrice, expectedPrice, "Price mismatch!");
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;

public class ProductPage {
    private WebDriver driver;

    // Locators
    private By FirstProduct = By.xpath("//span[@class='header-search-product-title'][1]");
    private By Productprice = By.xpath("//span[@class='pro-price text-black fw-bold']");
    private By addToCartButton = By.xpath("//button[@class='btn-add-bag']");
    private By sizeOptions = By.xpath("//button[contains(@class,'size-btn')]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnFirstProduct() {
        driver.findElement(FirstProduct).click();
    }

    public String getProductPrice() {
        return driver.findElement(Productprice).getText().trim();
    }

    public void verifyPrice(String expectedPrice) {
        String actualPrice = getProductPrice();
        Assert.assertEquals(actualPrice, expectedPrice, "Price mismatch!");
    }

    public void selectSize() {
        List<WebElement> sizes = driver.findElements(sizeOptions);
        if (!sizes.isEmpty()) {
            sizes.get(0).click();  // click the first available size
        }
    }

    public void addToCartButton() {
        driver.findElement(addToCartButton).click();
    }
}

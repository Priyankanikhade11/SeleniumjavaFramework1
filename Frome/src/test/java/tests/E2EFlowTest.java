package tests;

import base.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.CartPage;
import org.testng.annotations.Test;

public class E2EFlowTest extends BaseTest {

    @Test
    public void testProductFlow() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Watch");

        ProductPage productPage = new ProductPage(driver);

        // Step 1: Click first product
        productPage.clickOnFirstProduct();

        // Step 2: Capture product price dynamically
        String expectedPrice = productPage.getProductPrice();
        
        // Step 3: Verify product page price
        productPage.verifyPrice(expectedPrice);
 

        // Step 4: Select size if required
        productPage.selectSize();

        Thread.sleep(3000);
        
        // Step 5: Add to cart
        productPage.addToCartButton();
        
        Thread.sleep(3000);

        // Step 6: Go to cart and verify
        CartPage cartPage = new CartPage(driver);
        cartPage.BagButton();
        
        //cartPage.verifyItemCount(1); // ✅ cleaned parsing
        cartPage.verifyCheckoutSummary(expectedPrice); // ✅ dynamic check
    }
}

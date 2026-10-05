package tests;

import base.BaseTest;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2EFlowTest extends BaseTest {

    @Test
    public void testProductPriceVerification() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Watch");

        ProductPage productPage = new ProductPage(driver);

        // Step 1: Click first product
        productPage.clickOnFirstProduct();

        // Step 2: Capture product price from details page
        String productMRP = productPage.getProductPrice();

        // Step 3: Select size if required
        productPage.selectSize();
        Thread.sleep(2000);

        // Step 4: Add to cart
        productPage.addToCartButton();
        Thread.sleep(2000);

        // Step 5: Go to cart
        CartPage cartPage = new CartPage(driver);
        cartPage.BagButton();

        // Step 6: Capture cart price
        String cartPrice = cartPage.getCheckoutSummaryPrice();

        // Step 7: Compare product detail price with cart price
        Assert.assertEquals(cartPrice, productMRP,
            "❌ Price mismatch! Product detail page MRP and Cart page price are different.");

        // Final console log
        System.out.println(" Verification Complete: Product MRP (" + productMRP +
                           ") matches Cart Price (" + cartPrice + ")");
    }
}

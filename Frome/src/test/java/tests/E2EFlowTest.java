package tests;

import base.BaseTest;
import Pages.LoginPage;
import Pages.HomePage;
import Pages.ProductPage;
import Pages.CartPage;
import org.testng.annotations.Test;

public class E2EFlowTest extends BaseTest {

    @Test
    public void testProductFlow() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testuser@example.com", "password123");

        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Watch");

        ProductPage productPage = new ProductPage(driver);
        productPage.verifyPrice("₹ 12,995.00");
        productPage.addToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.verifyItemCount(1);
        cartPage.verifyCheckoutSummary("₹ 12,995.00");
    }
}

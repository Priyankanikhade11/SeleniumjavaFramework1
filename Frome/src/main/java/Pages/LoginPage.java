package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators (adjust after inspecting the actual modal)
    private By signInLink = By.xpath("//button[@class='login-trigger-btn']") ;  // header "Sign In" link
    private By mobileField = By.xpath("//input[@id='phoneInput']");            // mobile number input field
    private By continueButton = By.xpath("//button[contains(@class,'prime-yellow-btn')]");     // "Continue" button

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Open the login modal
    public void openLoginForm() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }

    // First-time login with mobile number
    public void loginWithMobile(String mobileNumber) {
        openLoginForm();
     // Wait for mobile field, click it, then type
        WebElement mobileInput = wait.until(ExpectedConditions.visibilityOfElementLocated(mobileField));
        mobileInput.click();  // ✅ explicitly click into the text box
        mobileInput.sendKeys(mobileNumber);
        
        
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}

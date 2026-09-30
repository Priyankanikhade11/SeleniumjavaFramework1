package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By emailField = By.id("login-email");
    private By passwordField = By.id("login-password");
    private By loginButton = By.xpath("//button[@class='login-trigger-btn']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // ✅ FIX: Selenium 4 requires Duration instead of int
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void login(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}

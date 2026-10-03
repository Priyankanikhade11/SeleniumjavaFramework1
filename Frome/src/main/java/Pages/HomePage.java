package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By searchBox = By.xpath("//button[@class='search-form-trigger d-block']");      ////button[@class='search-form-trigger d-block']
    //private By searchButton = By.xpath("//button[@type='submit']");
   // private By okbutton = By.xpath("//button[@class='tracking-consent-module__NVOBpW__affirmButton']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String productName) {
    	driver.findElement(searchBox).click();
        //driver.findElement(searchBox).sendKeys(productName);
        //driver.findElement(searchButton).click();
    }
    
//    public void okbutton() {
//    	driver.findElement(okbutton).click();
//    }
}

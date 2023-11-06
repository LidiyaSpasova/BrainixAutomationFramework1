import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UnsuccessfulLogin {
    public WebDriver driver;

    @BeforeMethod
    private void setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    private void tearDown(){
        driver.quit();
    }
    @Test
    public void UnsuccessfulLogin(){
        driver.get("https://brainix.5ea68fd9571344d0b183.germanywestcentral.aksapp.io/login");

        WebElement userNameInput = driver.findElement(By.id("loginPage-email-authValidatedInput"));
        //WebElement userNameInput = driver.findElement(By.cssSelector("#loginPage-email-authValidatedInput"));

        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("valid username");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type = password]"));

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("valid password");

        WebElement logInButton = driver.findElement(By.id("loginPage-primary-button-primaryButton-button"));

        logInButton.click();

        //Thread.sleep(1000); we shall never use this!!!
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement invalidLoginErrorMessage = driver.findElement(By.id("loginPage-invalid-login"));

        wait.until(ExpectedConditions.visibilityOf(invalidLoginErrorMessage));
        Assert.assertTrue(invalidLoginErrorMessage.isDisplayed());
        Assert.assertTrue(invalidLoginErrorMessage.isEnabled());
    }
}

package org.brainix.initial;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SuccessfulLogin {
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

    //Annotation - from TestNG
    @Test
    public void successfulLogin(){
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

        WebElement logoutButton = driver.findElement(By.id("foldersNavigationMenu-logout"));

        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertTrue(logoutButton.isEnabled());
    }
}

package org.brainix.tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulLogin extends TestUtil {
    @Test
    public void successfulLogin(){
        WebElement userNameInput = driver.findElement(By.id("loginPage-email-authValidatedInput"));
        //WebElement userNameInput = driver.findElement(By.cssSelector("#loginPage-email-authValidatedInput"));

        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("ibro@mittel");

        WebElement passwordInput = driver.findElement(By.cssSelector("[type = password]"));

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("Pa$$w0rd");

        WebElement logInButton = driver.findElement(By.id("loginPage-primary-button-primaryButton-button"));

        logInButton.click();

        WebElement logoutButton = driver.findElement(By.id("foldersNavigationMenu-logout"));

        Assert.assertTrue(logoutButton.isDisplayed());
        Assert.assertTrue(logoutButton.isEnabled());
    }
    }


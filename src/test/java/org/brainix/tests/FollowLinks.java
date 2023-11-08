package org.brainix.tests;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FollowLinks extends TestUtil {
    private String elementLocator = "//*[text()[contains(.,'%s')]]";
    @Test
    public void followRegisterLink(){
        WebElement registerLink = driver.findElement(By.id("loginPage-redirect-flatButton-0"));
        registerLink.click();

        WebElement registerButton = driver.findElement(By.id("registerForm-primary-button-primaryButton-button"));

        Assert.assertTrue(registerButton.isDisplayed());
    }
    @Test
    public void followForgotPasswordLink(){
        WebElement forgotPasswordLink = driver.findElement(By.id("loginPage-forgotten-code-link-flatButton-0"));
        forgotPasswordLink.click();

        WebElement sendRecoveryEmailButton = driver.findElement(By.id("recoverPasswordFormContent-primary-button-primaryButton-button"));

        Assert.assertTrue(sendRecoveryEmailButton.isDisplayed());
    }

    @Test
    public void followLinkText(){
        //case1 - follow register
        String xPathElement = createXpathLocator("Kostenlos registrieren");
        WebElement registerLink = driver.findElement(By.xpath(xPathElement));

        registerLink.click();
        WebElement registerButton = driver.findElement(By.id("registerForm-primary-button-primaryButton-button"));

        Assert.assertTrue(registerButton.isDisplayed());

    }
    @Test
    public void followLinkText2(){
        //case2 - follow register
        String xPathElement = createXpathLocator("Passwort vergessen?");
        WebElement registerLink = driver.findElement(By.xpath(xPathElement));

        registerLink.click();
        WebElement sendRecoveryEmailButton = driver.findElement(By.id("recoverPasswordFormContent-primary-button-primaryButton-button"));

        Assert.assertTrue(sendRecoveryEmailButton.isDisplayed());

    }
    private String createXpathLocator(String value){
        return String.format(elementLocator,value);
    }

}

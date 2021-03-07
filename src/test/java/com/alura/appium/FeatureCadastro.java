package com.alura.appium;

import com.alura.appium.pageObjects.CadastroPage;
import com.alura.appium.pageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;
import java.util.NoSuchElementException;

public class FeatureCadastro {
    @Test
    public void notPossibleToRegisterUserWithDifferentPasswords() {
        AppiumDriver driver = AppiumDriverConfig.getAppiumDriverSingleton().driver;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.findElementsOnPage();
        CadastroPage registerPage = loginPage.goToRegisterPage();
        registerPage.findElementsOnPage();
        registerPage.Register("Alexsandro","123","456");

        Assert.assertEquals(registerPage.errorMessage(), "Senhas não conferem");
    }

    @Test
    public void canRegisterSucessfully() throws NoSuchElementException {
        AppiumDriver driver = AppiumDriverConfig.getAppiumDriverSingleton().driver;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.findElementsOnPage();
        CadastroPage registerPage = loginPage.goToRegisterPage();
        registerPage.findElementsOnPage();
        registerPage.Register("Alexsandro","123","123");
    }
}

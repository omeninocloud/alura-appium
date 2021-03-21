package com.alura.appium;

import com.alura.appium.pageObjects.CadastroPage;
import com.alura.appium.pageObjects.ListaDeProdutosPage;
import com.alura.appium.pageObjects.LoginPage;
import io.appium.java_client.AppiumDriver;
import org.junit.*;

import java.util.NoSuchElementException;

public class FeatureCadastro {
    private static AppiumDriver driver;

    @BeforeClass
    public static void setup(){
         driver = AppiumDriverConfig.getAppiumDriverSingleton().driver;
    }

    @Test
    public void notPossibleToRegisterUserWithDifferentPasswords() {
        LoginPage loginPage = new LoginPage(driver);
        CadastroPage registerPage = loginPage.goToRegisterPage();
        registerPage.Register("Alexsandro","123","456");
        Assert.assertEquals(registerPage.errorMessage(), "Senhas não conferem");
    }

    @Test
    public void canRegisterSucessfully() throws NoSuchElementException {
        driver = AppiumDriverConfig.getAppiumDriverSingleton().driver;
        LoginPage loginPage = new LoginPage(driver);
        CadastroPage registerPage = loginPage.goToRegisterPage();
        registerPage.Register("Alexsandro","123","123");
    }

    @Test
    public void doLoginAfterRegisterSucessfully(){
        driver = AppiumDriverConfig.getAppiumDriverSingleton().driver;
        LoginPage loginPage = new LoginPage(driver);
        ListaDeProdutosPage produtosPage = loginPage.Login("Alexsandro", "123");
        produtosPage.SairDoApp();
    }

    @AfterClass
    public static void TearDown(){
        driver.quit();
    }
}
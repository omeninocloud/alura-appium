package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private MobileElement registerButton;

    private final By registerButtonId;

    public LoginPage(AppiumDriver driver){
        super(driver);
        registerButtonId = By.id("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
    }

    @Override
    public void findElementsOnPage(){
        registerButton = (MobileElement) super.driver.findElement(registerButtonId);
    }

    public CadastroPage goToRegisterPage(){
        registerButton.click();
        return new CadastroPage(super.driver);
    }
}
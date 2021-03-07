package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage extends BasePage {
    private MobileElement myName;
    private MobileElement password;
    private MobileElement register;
    private MobileElement confirmPassword;
    private MobileElement errorMessageOnRegister;

    private final By myNameId;
    private final By passwordId;
    private final By confirmPasswordId;
    private final By registerId;

    public CadastroPage(AppiumDriver driver){
        super(driver);
        myNameId = By.id("br.com.alura.aluraesporte:id/input_nome");
        passwordId = By.id("br.com.alura.aluraesporte:id/input_senha");
        confirmPasswordId = By.id("br.com.alura.aluraesporte:id/input_confirmar_senha");
        registerId = By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");
    }

    @Override
    public void findElementsOnPage(){
        myName = (MobileElement) super.driver.findElement(myNameId);
        password = (MobileElement) super.driver.findElement(passwordId);
        confirmPassword = (MobileElement) super.driver.findElement(confirmPasswordId);
        register = (MobileElement) super.driver.findElement(registerId);
    }

    private void fillFieldsOnForm(String myNameText, String passwordText, String confirmPasswordText){
        myName.setValue(myNameText);
        password.setValue(passwordText);
        confirmPassword.setValue(confirmPasswordText);
    }

    public void Register(String myNameText, String passwordText, String confirmPasswordText){
        fillFieldsOnForm(myNameText, passwordText, confirmPasswordText);
        register.click();
    }

    public String errorMessage(){
        By errorId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");
        WebDriverWait wait = new WebDriverWait(super.driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(errorId));
        errorMessageOnRegister = (MobileElement) super.driver.findElement(errorId);
        return errorMessageOnRegister.getText();
    }
}

package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPage extends BasePage {
    private MobileElement errorMessageOnRegister;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_nome")
    private MobileElement myName;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
    private MobileElement password;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")
    private MobileElement register;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_confirmar_senha")
    private MobileElement confirmPassword;


    public CadastroPage(AppiumDriver driver){
        super(driver);
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

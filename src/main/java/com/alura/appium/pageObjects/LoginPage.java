package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {

    //Testing decorate form of find by
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_usuario")
    private MobileElement fieldName;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/input_senha")
    private MobileElement fieldPassword;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_logar")
    private MobileElement loginButton;
    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario")
    private MobileElement registerButton;

    public LoginPage(AppiumDriver driver){
        super(driver);
    }

    public CadastroPage goToRegisterPage(){
        registerButton.click();
        return new CadastroPage(this.driver);
    }

    public ListaDeProdutosPage Login(String name, String password) {
        fieldName.setValue(name);
        fieldPassword.setValue(password);
        loginButton.click();
        return new ListaDeProdutosPage(this.driver);
    }
}
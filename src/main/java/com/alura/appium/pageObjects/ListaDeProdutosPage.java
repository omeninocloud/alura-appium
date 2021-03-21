package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListaDeProdutosPage extends BasePage {

    @AndroidFindBy(id = "br.com.alura.aluraesporte:id/menu_principal_deslogar")
    MobileElement botaoSair;

    protected ListaDeProdutosPage(AppiumDriver driver) {
        super(driver);
    }

    public void SairDoApp(){
        botaoSair.click();
    }
}

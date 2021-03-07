package com.alura.appium.pageObjects;

import io.appium.java_client.AppiumDriver;

public abstract class BasePage {
    protected final AppiumDriver driver;

    protected BasePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public abstract void findElementsOnPage();
}

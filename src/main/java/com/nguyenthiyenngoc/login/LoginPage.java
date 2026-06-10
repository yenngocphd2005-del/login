package com.nguyenthiyenngoc.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    WebElement errorMessage;
    
    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String username, String password) {

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLogin() {

        loginButton.click();
    }

    public boolean isLoginSuccessful() {

        return driver.getCurrentUrl().contains("inventory.html");
    }
}

package com.nguyenthiyenngoc.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nguyenthiyenngoc.login.LoginPage;

import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin1() {

        loginPage.enterCredentials(
                "standard_user",
                "secret_sauce"
        );

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isLoginSuccessful()
        );
    }

    @Test
    public void testInvalidLogin() {

        loginPage.enterCredentials(
                "wrong_user",
                "wrong_password"
        );

        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageDisplayed()
        );
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}

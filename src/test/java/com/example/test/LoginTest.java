package com.example.test;

import com.example.page.AdminPage;
import com.example.page.LoginPage;
import com.example.util.ConfigReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private AdminPage adminPage;

    @BeforeEach
    void init() {
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }

    @Test
    void testLogin() {
        loginPage.enterEmail(ConfigReader.get("login.email"))
                .enterPassword(ConfigReader.get("login.password"))
                .clickLogin();
        adminPage.waitForPageToLoad();

        Assertions.assertTrue(adminPage.isHeaderVisible(), "Header is not visible");
        Assertions.assertTrue(adminPage.isHappyBoxVisible(), "Happy Folder is not visible");
    }
}

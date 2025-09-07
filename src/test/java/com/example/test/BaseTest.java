package com.example.test;

import com.example.util.ConfigReader;
import com.example.util.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("admin.url"));
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }
}

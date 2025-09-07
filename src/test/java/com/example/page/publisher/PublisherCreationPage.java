package com.example.page.publisher;

import com.example.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublisherCreationPage extends BasePage<PublisherCreationPage> {
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveButton;

    @Override
    public PublisherCreationPage waitForPageToLoad() {
        return new PublisherCreationPage(driver);
    }

    public PublisherCreationPage(WebDriver driver) {
        super(driver);
    }

    public PublisherCreationPage enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
        return this;
    }

    public PublisherCreationPage enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    public void saveData() {
        saveButton.click();
    }
}

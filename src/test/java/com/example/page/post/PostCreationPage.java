package com.example.page.post;

import com.example.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostCreationPage extends BasePage<PostCreationPage> {
    @FindBy(id = "title")
    private WebElement titleField;

    @FindBy(id = "content")
    private WebElement contentField;

    @FindBy(xpath = "//label[@for=\"status\"]/following::div")
    private WebElement statusDropdown;

    @FindBy(xpath = "//div[text()=\"ACTIVE\"]")
    private WebElement activeStatusOption;

    @FindBy(xpath = "//input[@id=\"published\"]/following::a")
    private WebElement publishedCheckbox;

    @FindBy(xpath = "//label[@for=\"publisher\"]/following::div")
    private WebElement publisherDropdown;

    @FindBy(xpath = "//label[contains(@for, \"publisher\")]/following::div[contains(text(), \"@\")]")
    private WebElement publisherOption;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveButton;

    @Override
    public PostCreationPage waitForPageToLoad() {
        waitForVisibility(titleField);
        return new PostCreationPage(driver);
    }

    public PostCreationPage(WebDriver driver) {
        super(driver);
    }

    public PostCreationPage enterTitle(String title) {
        titleField.clear();
        titleField.sendKeys(title);
        return this;
    }

    public PostCreationPage enterContent(String content) {
        contentField.clear();
        contentField.sendKeys(content);
        return this;
    }

    public PostCreationPage chooseActiveStatus() {
        statusDropdown.click();
        activeStatusOption.click();
        return this;
    }

    public PostCreationPage checkPublished() {
        publishedCheckbox.click();
        return this;
    }

    public PostCreationPage choosePublisher() {
        publisherDropdown.click();
        publisherOption.click();
        return this;
    }

    public void saveData() {
        saveButton.click();
    }
}

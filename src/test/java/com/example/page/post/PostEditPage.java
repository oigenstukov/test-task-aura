package com.example.page.post;

import com.example.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostEditPage extends BasePage<PostEditPage> {
    @FindBy(id = "title")
    private WebElement titleField;

    @FindBy(xpath = "//label[@for=\"status\"]/following::div")
    private WebElement statusDropdown;

    @FindBy(xpath = "//div[text()=\"REMOVED\"]")
    private WebElement removedStatusOption;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement saveButton;

    @Override
    public PostEditPage waitForPageToLoad() {
        waitForVisibility(titleField);
        return new PostEditPage(driver);
    }

    public PostEditPage(WebDriver driver) {
        super(driver);
    }

    public PostEditPage chooseRemovedStatus() {
        statusDropdown.click();
        removedStatusOption.click();
        return this;
    }

    public void saveData() {
        saveButton.click();
    }
}

package com.example.page.post;

import com.example.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostDescriptionPage extends BasePage<PostDescriptionPage> {
    @FindBy(xpath = "//a[@data-testid=\"action-edit\"]")
    private WebElement editButton;

    @FindBy(xpath = "//section[@data-testid=\"property-show-title\"]")
    private WebElement titleElement;

    @Override
    public PostDescriptionPage waitForPageToLoad() {
        waitForVisibility(editButton);
        return new PostDescriptionPage(driver);
    }

    public PostDescriptionPage(WebDriver driver) {
        super(driver);
    }

    public void editPost() {
        editButton.click();
    }
}

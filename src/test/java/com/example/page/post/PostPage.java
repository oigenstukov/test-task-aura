package com.example.page.post;

import com.example.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends BasePage<PostPage> {
    @FindBy(xpath = "//a[contains(@href, \"new\")]")
    private WebElement createNewButton;

    @FindBy(xpath = "//section[@data-testid=\"property-list-title\"]")
    private WebElement createdPostTitle;

    @FindBy(xpath = "//section[@data-testid=\"property-list-status\"]")
    private WebElement createdPostStatus;

    @FindBy(xpath = "//section[@data-testid=\"property-list-published\"]")
    private WebElement createdPostPublished;

    @Override
    public PostPage waitForPageToLoad() {
        waitForVisibility(createNewButton);
        return new PostPage(driver);
    }

    public PostPage(WebDriver driver) {
        super(driver);
    }

    public void createNewButtonClick() {
        createNewButton.click();
    }

    public Boolean isCreatedPostVisible() {
        return waitForVisibility(createdPostStatus) && waitForVisibility(createdPostStatus);
    }

    public String getCreatedPostTitle() {
        return createdPostTitle.getText();
    }

    public String getCreatedPostStatus() {
        return createdPostStatus.getText();
    }

    public void goToCreatedPost() {
        createdPostTitle.click();
    }
}

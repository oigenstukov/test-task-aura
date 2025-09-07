package com.example.page.publisher;

import com.example.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PublisherPage extends BasePage<PublisherPage> {
    @FindBy(xpath = "//li/a[contains(@href, \"Publisher\")]")
    private WebElement publisherItem;

    @FindBy(xpath = "//a[contains(@href, \"new\")]")
    private WebElement createNewButton;

    @FindBy(xpath = "//section[@data-testid=\"property-list-name\"]")
    private WebElement createdPublisherName;

    @FindBy(xpath = "//section[@data-testid=\"property-list-email\"]")
    private WebElement createdPublisherEmail;

    @Override
    public PublisherPage waitForPageToLoad() {
        waitForVisibility(publisherItem);
        waitForVisibility(createNewButton);
        return new PublisherPage(driver);
    }

    public PublisherPage(WebDriver driver) {
        super(driver);
    }

    public void createNewButtonClick() {
        createNewButton.click();
    }

    public Boolean isCreatedPublisherVisible() {
        return waitForVisibility(createdPublisherName) && waitForVisibility(createdPublisherEmail);
    }

    public String getCreatedPublisherName() {
        return createdPublisherName.getText();
    }

    public String getCreatedPublisherEmail() {
        return createdPublisherEmail.getText();
    }
}

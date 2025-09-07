package com.example.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePage<AdminPage> {

    @FindBy(xpath = "//*[contains(@class, \"Header\")]")
    private WebElement header;

    @FindBy(xpath = "//span[contains(@class, \"icon-box\")]")
    private WebElement happyBoxSpan;

    @FindBy(xpath = "//li/a[contains(@href, \"Publisher\")]")
    private WebElement publisherItem;

    @FindBy(xpath = "//li/a[contains(@href, \"Post\")]")
    private WebElement postItem;

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AdminPage waitForPageToLoad() {
        waitForVisibility(header);
        waitForVisibility(happyBoxSpan);
        return new AdminPage(driver);
    }

    public Boolean isHeaderVisible() {
        return isElementVisible(header);
    }

    public Boolean isHappyBoxVisible() {
        return isElementVisible(happyBoxSpan);
    }

    public AdminPage openHappyBoxSpan() {
        if (!isElementVisible(publisherItem)) {
            happyBoxSpan.click();
        }
        return this;
    }

    public void goToPublisher() {
        publisherItem.click();
    }

    public void goToPost() {
        postItem.click();
    }
}

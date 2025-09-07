package com.example.test;

import com.example.page.AdminPage;
import com.example.page.LoginPage;
import com.example.page.post.PostCreationPage;
import com.example.page.post.PostDescriptionPage;
import com.example.page.post.PostEditPage;
import com.example.page.post.PostPage;
import com.example.page.publisher.PublisherCreationPage;
import com.example.page.publisher.PublisherPage;
import com.example.util.ApiClient;
import com.example.util.ConfigReader;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UITest extends BaseTest {
    private AdminPage adminPage;

    @BeforeEach
    void init() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogin();
        adminPage = new AdminPage(driver);
        adminPage.openHappyBoxSpan()
                .waitForPageToLoad();
    }

    @Test
    @Order(1)
    void testPublisherCreation() {
        adminPage.goToPublisher();

        PublisherPage publisherPage = new PublisherPage(driver);
        publisherPage.waitForPageToLoad()
                .createNewButtonClick();

        PublisherCreationPage publisherCreationPage = new PublisherCreationPage(driver);
        publisherCreationPage.waitForPageToLoad()
                .enterName(ConfigReader.get("publisher.name"))
                .enterEmail(ConfigReader.get("publisher.email"))
                .saveData();

        publisherPage = new PublisherPage(driver);
        publisherPage.waitForPageToLoad();

        Assertions.assertTrue(publisherPage.isCreatedPublisherVisible(), "Publisher is not visible");
        Assertions.assertEquals(ConfigReader.get("publisher.name"), publisherPage.getCreatedPublisherName());
        Assertions.assertEquals(ConfigReader.get("publisher.email"), publisherPage.getCreatedPublisherEmail());
    }

    @Test
    @Order(2)
    void testPostCreation() {
        adminPage.goToPost();

        PostPage postPage = new PostPage(driver);
        postPage.waitForPageToLoad()
                .createNewButtonClick();

        PostCreationPage postCreationPage = new PostCreationPage(driver);
        postCreationPage.waitForPageToLoad()
                .enterTitle(ConfigReader.get("post.title"))
                .enterContent(ConfigReader.get("post.content"))
                .chooseActiveStatus()
                .checkPublished()
                .choosePublisher()
                .saveData();

        postPage = new PostPage(driver);
        postPage.waitForPageToLoad();

        Assertions.assertTrue(postPage.isCreatedPostVisible(), "Post is not visible");
        Assertions.assertEquals(ConfigReader.get("post.title"), postPage.getCreatedPostTitle());
        Assertions.assertEquals(ConfigReader.get("post.status.active"), postPage.getCreatedPostStatus());
    }

    @Test
    @Order(3)
    void testPostEditing() {
        adminPage.waitForPageToLoad()
                .goToPost();

        PostPage postPage = new PostPage(driver);
        postPage.waitForPageToLoad()
                .goToCreatedPost();

        PostDescriptionPage postDescriptionPage = new PostDescriptionPage(driver);
        postDescriptionPage.waitForPageToLoad()
                .editPost();

        PostEditPage postEditPage = new PostEditPage(driver);
        postEditPage.waitForPageToLoad()
                .chooseRemovedStatus()
                .saveData();

        postPage = new PostPage(driver);
        postPage.waitForPageToLoad();

        Assertions.assertTrue(postPage.isCreatedPostVisible(), "Post is not visible");
        Assertions.assertEquals(ConfigReader.get("post.title"), postPage.getCreatedPostTitle());
        Assertions.assertEquals(ConfigReader.get("post.status.removed"), postPage.getCreatedPostStatus());
    }

    @AfterAll
    void cleanUp() {
        ApiClient api = new ApiClient();
        api.deleteAllPublishers();
        api.deleteAllPosts();
    }
}

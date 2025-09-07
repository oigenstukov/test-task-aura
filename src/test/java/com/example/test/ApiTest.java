package com.example.test;

import com.example.dto.Post;
import com.example.dto.Publisher;
import com.example.util.ApiClient;
import com.example.util.ConfigReader;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ApiTest {
    private final ApiClient api = new ApiClient();
    private int createdPostId;
    Publisher publisher;
    Post post;

    @Test
    @Order(1)
    void testCreatePublisher() {
        publisher = new Publisher(ConfigReader.get("publisher.name"), ConfigReader.get("publisher.email"));
        api.createPublisher(publisher);
    }

    @Test
    @Order(2)
    void testCreatePost() {
        post = new Post(ConfigReader.get("post.title"), ConfigReader.get("post.status.active"), true, publisher);
        Response response = api.createPost(post);
        createdPostId = response.jsonPath().getInt("id");
    }

    @Test
    @Order(3)
    void testEditPost() {
        Post removedPost = new Post(ConfigReader.get("post.title"), ConfigReader.get("post.status.removed"), true, publisher);
        String status = api.editPost(removedPost, createdPostId).jsonPath().getString("status");
        Assertions.assertEquals(ConfigReader.get("post.status.removed"), status);
    }

    @AfterAll
    void cleanUp() {
        api.deleteAllPublishers();
        api.deleteAllPosts();
    }
}

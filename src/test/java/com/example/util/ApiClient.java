package com.example.util;

import com.example.dto.Post;
import com.example.dto.Publisher;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ApiClient {
    private final String baseUrl = ConfigReader.get("base.url");

    public Response createPublisher(Publisher publisher) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(publisher)
                .post(baseUrl + "/Publisher/actions/new");
    }

    public Response createPost(Post post) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(post)
                .post(baseUrl + "/Post/actions/new");
    }

    public Response editPost(Post post, int postId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(post)
                .post(baseUrl + "/Post/records/" + postId + "/edit");
    }

    public Response deleteAllPublishers() {
        return RestAssured.given()
                .post(baseUrl + "/Publisher/bulk/bulkDelete");
    }

    public Response deleteAllPosts() {
        return RestAssured.given()
                .post(baseUrl + "/Post/bulk/bulkDelete");
    }
}

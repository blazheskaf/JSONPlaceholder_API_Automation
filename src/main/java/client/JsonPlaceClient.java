package client;
//This class contains API Request methods and returns responses

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.JsonRequestModelPOSTPUT;

import static utils.Configuration.BASE_URL_JSONPLACE;

public class JsonPlaceClient {

    public Response createPost(JsonRequestModelPOSTPUT requestBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(BASE_URL_JSONPLACE)
                .thenReturn();
    }

    public Response updatePost(JsonRequestModelPOSTPUT requestBody, String id) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all().body(requestBody)
                .put(BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }

    public Response getAllPost() {
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL_JSONPLACE)
                .thenReturn();
    }

    public Response getSinglePost(String id) {
        return RestAssured
                .given()
                .when().log().all()
                .get(BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }
    public Response deletePost (String id) {
        return RestAssured
                .given()
                .when().log().all()
                .delete(BASE_URL_JSONPLACE + "/" + id)
                .thenReturn();
    }
}

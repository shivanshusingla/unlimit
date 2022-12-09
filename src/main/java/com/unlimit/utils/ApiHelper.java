package com.unlimit.utils;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {

    private static Config config;
    private static Response response;

    public static Response getResponse(String apiUrl) {
        config.log.info("Getting response of GET api :- '{}'", apiUrl);
        response = given()
                .headers("Content-Type", ContentType.JSON, "Accept",
                        ContentType.JSON).when().get(apiUrl).then().statusCode(200).extract().response();
        config.log.info("Response is :- '{}'", response.asString());
        return response;
    }

    public static String getValue(String key) {
        String value = response.path(key).toString();
        config.log.info("Value of Key - '{}' :- '{}'", key, value);
        return value;
    }
}

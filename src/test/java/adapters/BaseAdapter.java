package test.java.adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();
    public String post(String body, int statusCode, String url) {

    return given().
                log().all().
                header("Token", "ba396de293da58a07bcb8cd8ff7a43a12f7a1d8c").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(body).

                when().
                post("https://api.qase.io/v1/" + url).
                then().
                log().all().
                statusCode(statusCode).
                extract().body().asString();

    }


    public String get (int statusCode, String url) {
        return given().
                log().all().
                header("Token", "ba396de293da58a07bcb8cd8ff7a43a12f7a1d8c").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
        when().
                get("https://api.qase.io/v1/" + url).
        then().
                log().all().
                statusCode(statusCode).
                extract().body().asString();

    }
}

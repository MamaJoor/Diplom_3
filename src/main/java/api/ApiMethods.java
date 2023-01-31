package api;

import io.restassured.response.Response;
import user.AuthUser;
import user.CreateUser;

import static io.restassured.RestAssured.given;

public class ApiMethods {
    private final String REGISTER = "/auth/register";
    private final String USER = "/auth/user";
    private final String LOGIN = "/auth/login";

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/api";


    public Response createUser (CreateUser createUser) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(createUser)
                .post(REGISTER);
        response.then();
        return response;
    }

    public Response authUser(AuthUser authUser) {
        Response response = given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(authUser)
                .post(LOGIN);
        response.then();
        return response;
    }

    public Response removeUser(String accessToken) {
        Response response = given()
                .header("Authorization", accessToken)
                .baseUri(BASE_URL)
                .when()
                .delete(USER);
        return response;
    }
}
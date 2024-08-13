package org.example.client.module;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.example.client.RestClient;

public class ReqresClient extends RestClient {

    private static final String GET_USER_BY_ID = "/api/users/{userId}";
    private static final String GET_USER_LIST = "/api/users";

    @Step("Get user by id: {userId}")
    public Response getUserById(int userId) {
        return basicRequestSpecification()
                .pathParam("userId", userId)
                .get(GET_USER_BY_ID);
    }

    @Step("Get user list by page: {page}")
    public Response getUsersListByPage(int page) {
        return basicRequestSpecification()
                .queryParam("page", page)
                .get(GET_USER_LIST);
    }

}

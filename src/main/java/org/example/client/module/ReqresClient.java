package org.example.client.module;

import io.restassured.response.Response;
import org.example.client.RestClient;

public class ReqresClient extends RestClient {

    private static final String GET_SINGLE_USER = "/api/users/{userId}";

    public Response getUserById(int userId) {
        return basicRequestSpecification()
                .pathParam("userId", userId)
                .get(GET_SINGLE_USER);
    }

}

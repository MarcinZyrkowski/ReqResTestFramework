package org.example.mapper;

import io.restassured.response.Response;
import org.example.model.UserListResponse;
import org.example.model.UserResponse;

public class ResponseMapper {

    public static UserResponse mapToUserResponse(Response response) {
        return response.as(UserResponse.class);
    }

    public static UserListResponse mapToUserListResponse(Response response) {
        return response.as(UserListResponse.class);
    }

}

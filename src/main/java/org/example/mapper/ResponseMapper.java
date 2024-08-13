package org.example.mapper;

import io.restassured.response.Response;
import org.example.model.SingleUserResponse;

public class ResponseMapper {

    public static SingleUserResponse mapToSingleUserResponse(Response response) {
        return response.as(SingleUserResponse.class);
    }

}

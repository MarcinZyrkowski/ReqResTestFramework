package org.example.verification.assertion.user;

import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.mapper.ResponseMapper;
import org.example.model.SingleUserResponse;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseAssertion {

    private SingleUserResponse singleUserResponse;

    public static UserResponseAssertion assertThat(Response response) {
        SingleUserResponse userResponse = ResponseMapper.mapToSingleUserResponse(response);
        return new UserResponseAssertion(userResponse);
    }

    public void isEqualTo(SingleUserResponse expectedResponse) {
        Assertions.assertThat(singleUserResponse)
                .isEqualTo(expectedResponse);
    }

}

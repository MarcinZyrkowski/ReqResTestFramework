package org.example.verification.assertion.user;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.mapper.ResponseMapper;
import org.example.model.UserResponse;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseAssertion {

    private UserResponse userResponse;

    public static UserResponseAssertion assertThat(Response response) {
        return new UserResponseAssertion(ResponseMapper.mapToUserResponse(response));
    }

    public void isEqualTo(UserResponse expectedResponse) {
        Allure.step("Response is equal to: expected response ", () -> {
            Assertions.assertThat(userResponse)
                    .isEqualTo(expectedResponse);

            Allure.addAttachment("Expected response body", JsonConverter.serializePojo(expectedResponse));
        });
    }

}

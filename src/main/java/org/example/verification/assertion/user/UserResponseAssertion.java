package org.example.verification.assertion.user;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.mapper.ResponseMapper;
import org.example.model.SingleUserResponse;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseAssertion {

    private SingleUserResponse singleUserResponse;

    public static UserResponseAssertion assertThat(Response response) {
        SingleUserResponse userResponse = ResponseMapper.mapToSingleUserResponse(response);
        return new UserResponseAssertion(userResponse);
    }

    public void isEqualTo(SingleUserResponse expectedResponse) {
        Allure.step("Response is equal to: expected response ", () -> {
            Assertions.assertThat(singleUserResponse)
                    .isEqualTo(expectedResponse);

            Allure.addAttachment("Expected response body:", JsonConverter.serializePojo(expectedResponse));
        });

    }

}

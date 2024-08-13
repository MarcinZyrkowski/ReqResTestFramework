package org.example.verification.assertion.user;

import io.qameta.allure.Allure;
import io.restassured.response.Response;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.example.mapper.ResponseMapper;
import org.example.model.UserListResponse;
import org.example.utils.JsonConverter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserListResponseAssertion {

    private UserListResponse userListResponse;

    public static UserListResponseAssertion assertThat(Response response) {
        return new UserListResponseAssertion(ResponseMapper.mapToUserListResponse(response));
    }

    public void isEqualTo(UserListResponse expectedUserListResponse) {
        Allure.step("Response is equal to: expected response ", () -> {
            Assertions.assertThat(userListResponse)
                    .isEqualTo(expectedUserListResponse);

            Allure.addAttachment("Expected response body", JsonConverter.serializePojo(expectedUserListResponse));
        });
    }

}

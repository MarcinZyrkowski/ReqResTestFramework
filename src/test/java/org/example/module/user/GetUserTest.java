package org.example.module.user;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.model.UserResponse;
import org.example.verification.assertion.HttpAssertion;
import org.example.verification.assertion.user.UserResponseAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Epic: User")
@Feature("Get User Feature")
@DisplayName("Get User Test")
public class GetUserTest extends BaseTest {

    @DisplayName("Get single user:")
    @ParameterizedTest(name = "for user with ID: 2")
    @MethodSource("org.example.dataprovider.UserResponseProvider#provideUserResponseForUserWithId2")
    public void getSingleUser(UserResponse expectedResponse) {
        int userId = 2;

        Response response = reqresClient.getUserById(userId);
        HttpAssertion.assertThat(response)
                .statusIsOk();
        UserResponseAssertion.assertThat(response)
                .isEqualTo(expectedResponse);
    }

}

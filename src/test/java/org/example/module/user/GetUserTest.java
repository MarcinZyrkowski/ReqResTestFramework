package org.example.module.user;

import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.model.SingleUserResponse;
import org.example.model.Support;
import org.example.model.User;
import org.example.verification.assertion.HttpAssertion;
import org.example.verification.assertion.user.UserResponseAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetUserTest extends BaseTest {

    @Test
    @DisplayName("Get single user")
    public void getSingleUser() {
        int userId = 2;

        SingleUserResponse expectedResponse = SingleUserResponse.builder()
                .data(User.builder()
                        .id(userId)
                        .email("janet.weaver@reqres.in")
                        .firstName("Janet")
                        .lastName("Weaver")
                        .avatar("https://reqres.in/img/faces/2-image.jpg")
                        .build())
                .support(Support.builder()
                        .url("https://reqres.in/#support-heading")
                        .text("To keep ReqRes free, contributions towards server costs are appreciated!")
                        .build())
                .build();

        Response response = reqresClient.getUserById(userId);
        HttpAssertion.assertThat(response)
                .statusIsOk();
        UserResponseAssertion.assertThat(response)
                .isEqualTo(expectedResponse);
    }

}

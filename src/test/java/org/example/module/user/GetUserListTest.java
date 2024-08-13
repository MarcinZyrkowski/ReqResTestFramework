package org.example.module.user;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;
import org.example.BaseTest;
import org.example.model.UserListResponse;
import org.example.verification.assertion.HttpAssertion;
import org.example.verification.assertion.user.UserListResponseAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@Epic("Epic: User")
@Feature("Get User List Feature")
@DisplayName("Get User List Test")
public class GetUserListTest extends BaseTest {

    @DisplayName("Get user list:")
    @ParameterizedTest(name = "with page = 2")
    @MethodSource("org.example.dataprovider.UserListResponseProvider#provideUserListResponseForPage2")
    public void getUserList(UserListResponse userListResponse) {
        int page = 2;

        Response response = reqresClient.getUsersListByPage(page);
        HttpAssertion.assertThat(response)
                .statusIsOk();
        UserListResponseAssertion.assertThat(response)
                .isEqualTo(userListResponse);
    }

}

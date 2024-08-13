package org.example.dataprovider;

import org.example.model.UserResponse;
import org.example.model.Support;
import org.example.model.User;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class UserResponseProvider {

    public static Stream<Arguments> provideUserResponseForUserWithId2() {
        return Stream.of(Arguments.of(UserResponse.builder()
                .data(User.builder()
                        .id(2)
                        .email("janet.weaver@reqres.in")
                        .firstName("Janet")
                        .lastName("Weaver")
                        .avatar("https://reqres.in/img/faces/2-image.jpg")
                        .build())
                .support(Support.builder()
                        .url("https://reqres.in/#support-heading")
                        .text("To keep ReqRes free, contributions towards server costs are appreciated!")
                        .build())
                .build()));
    }

}

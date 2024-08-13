package org.example.dataprovider;

import org.example.model.Support;
import org.example.model.User;
import org.example.model.UserListResponse;
import org.junit.jupiter.params.provider.Arguments;

import java.util.List;
import java.util.stream.Stream;

public class UserListResponseProvider {

    public static Stream<Arguments> provideUserListResponseForPage2() {

        List<User> users = List.of(
                User.builder()
                        .id(7)
                        .email("michael.lawson@reqres.in")
                        .firstName("Michael")
                        .lastName("Lawson")
                        .avatar("https://reqres.in/img/faces/7-image.jpg")
                        .build(),
                User.builder()
                        .id(8)
                        .email("lindsay.ferguson@reqres.in")
                        .firstName("Lindsay")
                        .lastName("Ferguson")
                        .avatar("https://reqres.in/img/faces/8-image.jpg")
                        .build(),
                User.builder()
                        .id(9)
                        .email("tobias.funke@reqres.in")
                        .firstName("Tobias")
                        .lastName("Funke")
                        .avatar("https://reqres.in/img/faces/9-image.jpg")
                        .build(),
                User.builder()
                        .id(10)
                        .email("byron.fields@reqres.in")
                        .firstName("Byron")
                        .lastName("Fields")
                        .avatar("https://reqres.in/img/faces/10-image.jpg")
                        .build(),
                User.builder()
                        .id(11)
                        .email("george.edwards@reqres.in")
                        .firstName("George")
                        .lastName("Edwards")
                        .avatar("https://reqres.in/img/faces/11-image.jpg")
                        .build(),
                User.builder()
                        .id(12)
                        .email("rachel.howell@reqres.in")
                        .firstName("Rachel")
                        .lastName("Howell")
                        .avatar("https://reqres.in/img/faces/12-image.jpg")
                        .build()
        );

        return Stream.of(Arguments.of(UserListResponse.builder()
                .page(2)
                .perPage(6)
                .total(12)
                .totalPages(2)
                .data(users)
                .support(Support.builder()
                        .url("https://reqres.in/#support-heading")
                        .text("To keep ReqRes free, contributions towards server costs are appreciated!")
                        .build())
                .build()));
    }

}

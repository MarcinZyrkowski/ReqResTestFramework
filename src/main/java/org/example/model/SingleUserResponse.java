package org.example.model;

import lombok.Builder;

@Builder
public record SingleUserResponse(User data,
                                 Support support) {
}

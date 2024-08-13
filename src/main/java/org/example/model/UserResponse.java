package org.example.model;

import lombok.Builder;

@Builder
public record UserResponse(User data,
                           Support support) {
}

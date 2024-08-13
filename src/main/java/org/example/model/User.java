package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record User(Integer id,
                   String email,
                   @JsonProperty("first_name") String firstName,
                   @JsonProperty("last_name") String lastName,
                   String avatar) {
}

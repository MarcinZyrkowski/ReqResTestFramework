package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record UserListResponse(Integer page,
                               @JsonProperty("per_page") Integer perPage,
                               Integer total,
                               @JsonProperty("total_pages") Integer totalPages,
                               List<User> data,
                               Support support) {
}

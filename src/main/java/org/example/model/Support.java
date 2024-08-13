package org.example.model;

import lombok.Builder;

@Builder
public record Support(String url,
                      String text) {
}

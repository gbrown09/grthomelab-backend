package com.grthomelab.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class MessageResponse {
    @Getter
    @Setter
    String message;
}

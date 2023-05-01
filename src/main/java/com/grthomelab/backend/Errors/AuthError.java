package com.grthomelab.backend.Errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthError extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    public AuthError(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}

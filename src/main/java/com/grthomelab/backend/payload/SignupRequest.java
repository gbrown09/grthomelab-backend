package com.grthomelab.backend.payload;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    String username;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    String password;
}

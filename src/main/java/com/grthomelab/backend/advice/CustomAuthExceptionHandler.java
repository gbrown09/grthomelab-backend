package com.grthomelab.backend.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grthomelab.backend.Errors.AuthError;

@ControllerAdvice
public class CustomAuthExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ AuthenticationException.class })
  @ResponseBody
  public ResponseEntity<AuthError> handleAuthenticationException(Exception ex) {

    AuthError re = new AuthError(HttpStatus.UNAUTHORIZED.toString(),
        "Authentication failed");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(re);
  }

}

package com.phucviet.authorizationserver.controller;

import com.phucviet.authorizationserver.model.request.SignUpRequest;
import com.phucviet.authorizationserver.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/user")
public class UserController {

  @Autowired private AuthenticationService authenticationService;

  @PostMapping("/sing-up")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
    return authenticationService.singUpAccount(signUpRequest);
  }
}

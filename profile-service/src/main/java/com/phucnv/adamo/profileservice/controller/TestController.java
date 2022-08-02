package com.phucnv.adamo.profileservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("/message/{text}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public ResponseEntity<?> showMessage(@PathVariable String text) {
    return ResponseEntity.status(HttpStatus.OK).body(text);
  }

  @GetMapping(value = "/send/{message}")
  @PreAuthorize("hasAuthority('READ_PROFILE')")
  public ResponseEntity<?> send(@PathVariable String message) {
    return ResponseEntity.status(HttpStatus.OK).body(message);
  }
}

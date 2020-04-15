package com.dzmitrykamarou.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController extends BaseController {

  @GetMapping("/healthcheck")
  public String getHealthCheck() {
    // TODO: add DB check
    return "OK";
  }
}

package com.dzmitrykamarou.diamond.controller;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController implements HealthIndicator {

  @Autowired
  DataSource postgresDataSource;

  @GetMapping("/healthcheck")
  public String getHealthCheck() {
    return "OK!!!";
  }

  @Override
  public Health health() {
    DataSourceHealthIndicator indicator = new DataSourceHealthIndicator(postgresDataSource);
    return indicator.health();
  }
}

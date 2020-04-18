package com.dzmitrykamarou.diamond.controller;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.jdbc.DataSourceHealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
public class HealthCheckController implements HealthIndicator {

  @Autowired
  DataSource postgresDataSource;

  @GetMapping("/healthcheck")
  public HashMap<String, Object> healthCheck() {
    HashMap<String, Object> healthStatus = new HashMap<>();
    healthStatus.put("API", "UP");
    healthStatus.put("DB", health().getStatus().getCode());
    return healthStatus;
  }

  @Override
  public Health health() {
    DataSourceHealthIndicator indicator = new DataSourceHealthIndicator(postgresDataSource);
    return indicator.health();
  }
}

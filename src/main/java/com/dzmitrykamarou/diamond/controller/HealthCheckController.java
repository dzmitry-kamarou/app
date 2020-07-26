package com.dzmitrykamarou.diamond.controller;

import static com.dzmitrykamarou.diamond.controller.BaseController.API_ENDPOINT;
import static com.dzmitrykamarou.diamond.controller.BaseController.API_VERSION;

import java.util.HashMap;
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

  @GetMapping(path = API_ENDPOINT + API_VERSION + "/healthcheck", produces = {"application/json"})
  public HashMap<String, Object> getHealthCheck() {
    HashMap<String, Object> healthStatuses = new HashMap<>();
    healthStatuses.put("API", "UP");
    healthStatuses.put("DB", health().getStatus().getCode());
    return healthStatuses;
  }

  @Override
  public Health health() {
    return new DataSourceHealthIndicator(postgresDataSource).health();
  }
}

package com.dzmitrykamarou.diamond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Diamond {

  public static void main(String[] args) {
    SpringApplication.run(Diamond.class, args);
  }
}

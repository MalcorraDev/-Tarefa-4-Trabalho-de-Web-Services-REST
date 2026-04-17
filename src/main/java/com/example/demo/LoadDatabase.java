package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(CarsRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Cars("Ford", "Fucion", 2010, 19000)));
      log.info("Preloading " + repository.save(new Cars("Chevrolet", "Mondeo", 2020, 5000)));
      log.info("Preloading " + repository.save(new Cars("Fiat", "Toro", 2025, 25000)));
      log.info("Preloading " + repository.save(new Cars("Citroen", "Captus", 2026, 19990)));
    };
  }
}
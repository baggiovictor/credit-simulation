package com.baggiovictor.creditsimulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.baggiovictor.creditsimulation")
public class CreditSimulationApplication {

  public static void main(String[] args) {
    SpringApplication.run(CreditSimulationApplication.class, args);
  }

}

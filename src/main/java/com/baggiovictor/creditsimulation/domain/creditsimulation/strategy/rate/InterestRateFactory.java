package com.baggiovictor.creditsimulation.domain.creditsimulation.strategy.rate;

public class InterestRateFactory {
  public static InterestRateStrategy getRateStrategy(int age) {
    if (age <= 25) return new YoungRateStrategy();

    if (age <= 40) return new AdultRateStrategy();

    if (age <= 60) return new MatureRateStrategy();

    return new SeniorRateStrategy();
  }
}
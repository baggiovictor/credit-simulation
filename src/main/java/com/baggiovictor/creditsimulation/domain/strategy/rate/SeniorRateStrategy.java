package com.baggiovictor.creditsimulation.domain.strategy.rate;

import java.math.BigDecimal;

public class SeniorRateStrategy implements InterestRateStrategy {

  @Override
  public BigDecimal getRate() {
    return new BigDecimal("0.04");
  }
}

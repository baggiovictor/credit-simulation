package com.baggiovictor.creditsimulation.domain.strategy.rate;

import java.math.BigDecimal;

public class AdultRateStrategy implements InterestRateStrategy {

  @Override
  public BigDecimal getRate() {
    return new BigDecimal("0.03");
  }
}

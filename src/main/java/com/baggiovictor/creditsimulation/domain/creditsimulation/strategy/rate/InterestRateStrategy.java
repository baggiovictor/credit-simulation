package com.baggiovictor.creditsimulation.domain.creditsimulation.strategy.rate;

import java.math.BigDecimal;

public interface InterestRateStrategy {

  BigDecimal getRate();
}

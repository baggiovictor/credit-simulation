package com.baggiovictor.creditsimulation.domain.strategy.rate;

import java.math.BigDecimal;

public interface InterestRateStrategy {

  BigDecimal getRate();
}

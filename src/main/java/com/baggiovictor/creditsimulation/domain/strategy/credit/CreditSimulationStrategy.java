package com.baggiovictor.creditsimulation.domain.strategy.credit;

import java.math.BigDecimal;

public interface CreditSimulationStrategy {

  SimulationResult simulate(
      BigDecimal amount,
      BigDecimal interestRate,
      int termInMonths);

  record SimulationResult(
      BigDecimal totalPayment,
      BigDecimal monthlyInstallment,
      BigDecimal totalInterest) {
  }
}

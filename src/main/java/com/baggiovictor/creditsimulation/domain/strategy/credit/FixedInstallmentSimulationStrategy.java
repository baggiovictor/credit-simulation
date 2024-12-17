package com.baggiovictor.creditsimulation.domain.strategy.credit;

import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;

public class FixedInstallmentSimulationStrategy implements CreditSimulationStrategy {

  @Override
  public SimulationResult simulate(
      BigDecimal amount,
      BigDecimal interestRate,
      int termInMonths
  ) {

    BigDecimal totalInterest = amount.multiply(interestRate).setScale(2, HALF_UP);

    BigDecimal totalPayment = amount.add(totalInterest).setScale(2, HALF_UP);

    BigDecimal monthlyInstallment =
        totalPayment.divide(BigDecimal.valueOf(termInMonths), 2, HALF_UP);

    return new SimulationResult(totalPayment, monthlyInstallment, totalInterest);
  }
}

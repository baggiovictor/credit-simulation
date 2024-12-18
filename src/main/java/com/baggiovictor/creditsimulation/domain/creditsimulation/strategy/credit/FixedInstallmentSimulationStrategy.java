package com.baggiovictor.creditsimulation.domain.creditsimulation.strategy.credit;

import static java.math.RoundingMode.HALF_EVEN;
import static java.math.RoundingMode.HALF_UP;

import java.math.BigDecimal;
import java.math.MathContext;

public class FixedInstallmentSimulationStrategy implements CreditSimulationStrategy {

  @Override
  public SimulationResult simulate(
      BigDecimal principalAmount,
      BigDecimal annualInterestRate,
      int loanTermInMonths
  ) {
    final var monthlyInterestRate =
        annualInterestRate.divide(BigDecimal.valueOf(12), 10, HALF_UP);

    final var fixedMonthlyPayment = calculateFixedMonthlyPayment(principalAmount,
        monthlyInterestRate, loanTermInMonths);

    final var totalLoanRepayment = calculateTotalPayment(fixedMonthlyPayment, loanTermInMonths);

    final var totalInterestPaid = calculateTotalInterestPaid(principalAmount, totalLoanRepayment);

    return new SimulationResult(totalLoanRepayment, fixedMonthlyPayment, totalInterestPaid);
  }

  /**
   * Calcula o pagamento mensal fixo baseado na fórmula PRICE.
   *
   * @param principalAmount     Valor principal do empréstimo (PV)
   * @param monthlyInterestRate Taxa de juros mensal (r)
   * @param loanTermInMonths    Prazo do empréstimo em meses (n)
   * @return Valor fixo da parcela mensal (PMT)
   */
  public static BigDecimal calculateFixedMonthlyPayment(
      BigDecimal principalAmount,
      BigDecimal monthlyInterestRate,
      int loanTermInMonths
  ) {
    final var onePlusMonthlyRate = BigDecimal.ONE.add(monthlyInterestRate);

    final var rateExponentiation =
        onePlusMonthlyRate.pow(loanTermInMonths, new MathContext(20, HALF_EVEN));

    final var denominator = rateExponentiation.subtract(BigDecimal.ONE);

    return principalAmount.multiply(monthlyInterestRate).multiply(rateExponentiation)
        .divide(denominator, 2, HALF_EVEN);
  }

  /**
   * Calcula o total pago ao longo do empréstimo.
   *
   * @param fixedMonthlyPayment Parcela mensal fixa (PMT)
   * @param loanTermInMonths    Prazo do empréstimo em meses (n)
   * @return Valor total pago ao longo do empréstimo
   */
  private static BigDecimal calculateTotalPayment(BigDecimal fixedMonthlyPayment,
      int loanTermInMonths) {
    return fixedMonthlyPayment.multiply(BigDecimal.valueOf(loanTermInMonths));
  }

  /**
   * Calcula o total de juros pagos durante o prazo do empréstimo.
   *
   * @param principalAmount    Valor principal do empréstimo (PV)
   * @param totalLoanRepayment Valor total pago ao longo do empréstimo
   * @return Total de juros pagos
   */
  private static BigDecimal calculateTotalInterestPaid(BigDecimal principalAmount,
      BigDecimal totalLoanRepayment) {
    return totalLoanRepayment.subtract(principalAmount);
  }
}
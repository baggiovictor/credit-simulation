package com.baggiovictor.creditsimulation.domain.model;

import static com.baggiovictor.creditsimulation.domain.strategy.credit.CreditSimulationStrategyFactory.getCreditStrategy;
import static com.baggiovictor.creditsimulation.domain.strategy.rate.InterestRateFactory.getRateStrategy;
import static java.time.Instant.now;
import static java.util.UUID.randomUUID;

import java.math.BigDecimal;
import java.time.Instant;
import lombok.Getter;

@Getter
public class CreditSimulation {

  private final String id;

  private final String customerName;

  private final String customerEmail;

  private final BigDecimal amount;

  private final BigDecimal interestRate;

  private final int termInMonths;

  private final BigDecimal monthlyInstallment;

  private final BigDecimal totalPayment;

  private final BigDecimal totalInterest;

  private Instant createdAt;

  private Instant updatedAt;

  private Instant deletedAt;

  protected CreditSimulation(
      final String anId,
      final String aCustomerEmail,
      final String aCustomerName,
      final BigDecimal aAmount,
      final BigDecimal anInterestRate,
      final int aTermInMonths,
      final BigDecimal aMonthlyInstallment,
      final BigDecimal aTotalPayment,
      final BigDecimal aTotalInterest,
      final Instant aCreatedAt,
      final Instant aUpdatedAt,
      final Instant aDeletedAt) {
    this.id = anId;
    this.customerEmail = aCustomerEmail;
    this.customerName = aCustomerName;
    this.amount = aAmount;
    this.interestRate = anInterestRate;
    this.termInMonths = aTermInMonths;
    this.monthlyInstallment = aMonthlyInstallment;
    this.totalPayment = aTotalPayment;
    this.totalInterest = aTotalInterest;
    this.createdAt = aCreatedAt;
    this.updatedAt = aUpdatedAt;
    this.deletedAt = aDeletedAt;
  }

  public static CreditSimulation newCreditSimulation(
      final BigDecimal aAmount,
      final int aTermInMonths,
      final int anAge,
      final CreditSimulationEnum type,
      final String aCustomerEmail,
      final String aCustomerName
  ) {

    final var id = randomUUID().toString();
    final var now = now();

    final var aInterestRate = getRateStrategy(anAge).getRate();

    final var aSimulation = getCreditStrategy(type)
        .simulate(
            aAmount,
            aInterestRate,
            aTermInMonths);

    return new CreditSimulation(
        id,
        aCustomerEmail,
        aCustomerName,
        aAmount,
        aInterestRate,
        aTermInMonths,
        aSimulation.monthlyInstallment(),
        aSimulation.totalPayment(),
        aSimulation.totalInterest(),
        now,
        now,
        null);
  }

  public static CreditSimulation with(
      final String anId,
      final String aCustomerEmail,
      final String aCustomerName,
      final BigDecimal aAmount,
      final BigDecimal anInterestRate,
      final int aTermInMonths,
      final BigDecimal aMonthlyInstallment,
      final BigDecimal aTotalPayment,
      final BigDecimal aTotalInterest,
      final Instant aCreatedAt,
      final Instant aUpdatedAt,
      final Instant aDeletedAt) {
    return new CreditSimulation(
        anId,
        aCustomerEmail,
        aCustomerName,
        aAmount,
        anInterestRate,
        aTermInMonths,
        aMonthlyInstallment,
        aTotalPayment,
        aTotalInterest,
        aCreatedAt,
        aUpdatedAt,
        aDeletedAt);
  }

}

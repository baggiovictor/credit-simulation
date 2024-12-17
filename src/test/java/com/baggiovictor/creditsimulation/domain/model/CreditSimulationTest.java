package com.baggiovictor.creditsimulation.domain.model;

import static com.baggiovictor.creditsimulation.domain.model.CreditSimulation.*;
import static com.baggiovictor.creditsimulation.domain.model.CreditSimulationEnum.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CreditSimulationTest {

  @Test
  void givenCreditSimulationWith5Percent_whenCreate_thenSuccess() {
    final var expectedAmount = new BigDecimal("1000.00");
    final var expectedTermInMonths = 12;
    final var expectedCustomerAge = 21;
    final var expectedMonthlyInstallment = new BigDecimal("87.50");
    final var expectedInterestRate = new BigDecimal("0.05");
    final var expectedTotalPayment = new BigDecimal("1050.00");
    final var expectedTotalInterest = new BigDecimal("50.00");
    final var expectedEmail = "baggiovictor@gmail.com";
    final var expectedName = "Victor Baggio";

    final var actualCreditSimulation = newCreditSimulation(
        expectedAmount,
        expectedTermInMonths,
        expectedCustomerAge,
        FIXED_INSTALLMENT,
        expectedEmail,
        expectedName
    );

    assertNotNull(actualCreditSimulation);
    assertNotNull(actualCreditSimulation.getId());
    assertEquals(expectedAmount, actualCreditSimulation.getAmount());
    assertEquals(expectedInterestRate, actualCreditSimulation.getInterestRate());
    assertEquals(expectedTermInMonths, actualCreditSimulation.getTermInMonths());
    assertEquals(expectedMonthlyInstallment, actualCreditSimulation.getMonthlyInstallment());
    assertEquals(expectedTotalPayment, actualCreditSimulation.getTotalPayment());
    assertEquals(expectedTotalInterest, actualCreditSimulation.getTotalInterest());
    assertNotNull(actualCreditSimulation.getCreatedAt());
    assertNotNull(actualCreditSimulation.getUpdatedAt());
    assertNull(actualCreditSimulation.getDeletedAt());
  }

  @Test
  void givenCreditSimulationWith4Percent_whenCreate_thenSuccess() {
    final var expectedAmount = new BigDecimal("1000.00");
    final var expectedTermInMonths = 12;
    final var expectedCustomerAge = 62;
    final var expectedMonthlyInstallment = new BigDecimal("86.67");
    final var expectedInterestRate = new BigDecimal("0.04");
    final var expectedTotalPayment = new BigDecimal("1040.00");
    final var expectedTotalInterest = new BigDecimal("40.00");
    final var expectedEmail = "baggiovictor@gmail.com";
    final var expectedName = "Victor Baggio";

    final var actualCreditSimulation = newCreditSimulation(
        expectedAmount,
        expectedTermInMonths,
        expectedCustomerAge,
        FIXED_INSTALLMENT,
        expectedEmail,
        expectedName);

    assertNotNull(actualCreditSimulation);
    assertNotNull(actualCreditSimulation.getId());
    assertEquals(expectedAmount, actualCreditSimulation.getAmount());
    assertEquals(expectedInterestRate, actualCreditSimulation.getInterestRate());
    assertEquals(expectedTermInMonths, actualCreditSimulation.getTermInMonths());
    assertEquals(expectedMonthlyInstallment, actualCreditSimulation.getMonthlyInstallment());
    assertEquals(expectedTotalPayment, actualCreditSimulation.getTotalPayment());
    assertEquals(expectedTotalInterest, actualCreditSimulation.getTotalInterest());
    assertNotNull(actualCreditSimulation.getCreatedAt());
    assertNotNull(actualCreditSimulation.getUpdatedAt());
    assertNull(actualCreditSimulation.getDeletedAt());
  }

  @Test
  void givenCreditSimulationWith3Percent_whenCreate_thenSuccess() {
    final var expectedAmount = new BigDecimal("1000.00");
    final var expectedTermInMonths = 12;
    final var expectedCustomerAge = 40;
    final var expectedMonthlyInstallment = new BigDecimal("85.83");
    final var expectedInterestRate = new BigDecimal("0.03");
    final var expectedTotalPayment = new BigDecimal("1030.00");
    final var expectedTotalInterest = new BigDecimal("30.00");
    final var expectedEmail = "baggiovictor@gmail.com";
    final var expectedName = "Victor Baggio";

    final var actualCreditSimulation = newCreditSimulation(
        expectedAmount,
        expectedTermInMonths,
        expectedCustomerAge,
        FIXED_INSTALLMENT,
        expectedEmail,
        expectedName);

    assertNotNull(actualCreditSimulation);
    assertNotNull(actualCreditSimulation.getId());
    assertEquals(expectedAmount, actualCreditSimulation.getAmount());
    assertEquals(expectedInterestRate, actualCreditSimulation.getInterestRate());
    assertEquals(expectedTermInMonths, actualCreditSimulation.getTermInMonths());
    assertEquals(expectedMonthlyInstallment, actualCreditSimulation.getMonthlyInstallment());
    assertEquals(expectedTotalPayment, actualCreditSimulation.getTotalPayment());
    assertEquals(expectedTotalInterest, actualCreditSimulation.getTotalInterest());
    assertNotNull(actualCreditSimulation.getCreatedAt());
    assertNotNull(actualCreditSimulation.getUpdatedAt());
    assertNull(actualCreditSimulation.getDeletedAt());
  }

  @Test
  void givenCreditSimulationWith2Percent_whenCreate_thenSuccess() {
    final var expectedAmount = new BigDecimal("1000.00");
    final var expectedTermInMonths = 12;
    final var expectedCustomerAge = 55;
    final var expectedMonthlyInstallment = new BigDecimal("85.00");
    final var expectedInterestRate = new BigDecimal("0.02");
    final var expectedTotalPayment = new BigDecimal("1020.00");
    final var expectedTotalInterest = new BigDecimal("20.00");
    final var expectedEmail = "baggiovictor@gmail.com";
    final var expectedName = "Victor Baggio";

    final var actualCreditSimulation = newCreditSimulation(
        expectedAmount,
        expectedTermInMonths,
        expectedCustomerAge,
        FIXED_INSTALLMENT,
        expectedEmail,
        expectedName);

    assertNotNull(actualCreditSimulation);
    assertNotNull(actualCreditSimulation.getId());
    assertEquals(expectedAmount, actualCreditSimulation.getAmount());
    assertEquals(expectedInterestRate, actualCreditSimulation.getInterestRate());
    assertEquals(expectedTermInMonths, actualCreditSimulation.getTermInMonths());
    assertEquals(expectedMonthlyInstallment, actualCreditSimulation.getMonthlyInstallment());
    assertEquals(expectedTotalPayment, actualCreditSimulation.getTotalPayment());
    assertEquals(expectedTotalInterest, actualCreditSimulation.getTotalInterest());
    assertNotNull(actualCreditSimulation.getCreatedAt());
    assertNotNull(actualCreditSimulation.getUpdatedAt());
    assertNull(actualCreditSimulation.getDeletedAt());
  }

}

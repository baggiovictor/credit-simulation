package com.baggiovictor.creditsimulation.domain.creditsumulation.model;

import static com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation.*;
import static com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulationEnum.*;
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
    final var expectedMonthlyInstallment = new BigDecimal("85.61");
    final var expectedInterestRate = new BigDecimal("0.05");
    final var expectedTotalPayment = new BigDecimal("1027.32");
    final var expectedTotalInterest = new BigDecimal("27.32");
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
    final var expectedMonthlyInstallment = new BigDecimal("85.15");
    final var expectedInterestRate = new BigDecimal("0.04");
    final var expectedTotalPayment = new BigDecimal("1021.80");
    final var expectedTotalInterest = new BigDecimal("21.80");
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
    final var expectedMonthlyInstallment = new BigDecimal("84.69");
    final var expectedInterestRate = new BigDecimal("0.03");
    final var expectedTotalPayment = new BigDecimal("1016.28");
    final var expectedTotalInterest = new BigDecimal("16.28");
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
    final var expectedMonthlyInstallment = new BigDecimal("84.24");
    final var expectedInterestRate = new BigDecimal("0.02");
    final var expectedTotalPayment = new BigDecimal("1010.88");
    final var expectedTotalInterest = new BigDecimal("10.88");
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

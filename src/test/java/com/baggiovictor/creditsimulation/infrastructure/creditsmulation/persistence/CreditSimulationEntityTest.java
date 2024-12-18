package com.baggiovictor.creditsimulation.infrastructure.creditsmulation.persistence;

import static java.time.Instant.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CreditSimulationEntityTest {

  @Test
  void givenAllArgsConstructor_whenCreated_thenFieldsAreInitialized() {
    final var id = "123";
    final var amount = new BigDecimal("1000.00");
    final var termInMonths = 12;
    final var monthlyInstallment = new BigDecimal("100.00");
    final var totalPayment = new BigDecimal("1200.00");
    final var totalInterest = new BigDecimal("200.00");
    final var interestRate = new BigDecimal("0.02");
    final var customerEmail = "baggiovictor@gmail.com";
    final var customerName = "Victor Baggio";
    final var createdAt = now();
    final var updatedAt = now();

    CreditSimulationEntity entity = new CreditSimulationEntity(
        id,
        customerEmail,
        customerName,
        amount,
        termInMonths,
        monthlyInstallment,
        totalPayment,
        totalInterest,
        interestRate,
        createdAt,
        updatedAt,
        null
    );

    assertNotNull(entity);
    assertEquals(id, entity.getId());
    assertEquals(customerEmail, entity.getCustomerEmail());
    assertEquals(customerName, entity.getCustomerName());
    assertEquals(amount, entity.getAmount());
    assertEquals(termInMonths, entity.getTermInMonths());
    assertEquals(monthlyInstallment, entity.getMonthlyInstallment());
    assertEquals(totalPayment, entity.getTotalPayment());
    assertEquals(totalInterest, entity.getTotalInterest());
    assertEquals(createdAt, entity.getCreatedAt());
    assertEquals(updatedAt, entity.getUpdatedAt());
    assertNull(entity.getDeletedAt());
  }

  @Test
  void givenNoArgsConstructor_whenCreated_thenFieldsAreNull() {
    CreditSimulationEntity entity = new CreditSimulationEntity();

    assertNull(entity.getId());
    assertNull(entity.getAmount());
    assertEquals(0, entity.getTermInMonths());
    assertNull(entity.getMonthlyInstallment());
    assertNull(entity.getTotalPayment());
    assertNull(entity.getTotalInterest());
    assertNull(entity.getCreatedAt());
    assertNull(entity.getUpdatedAt());
    assertNull(entity.getDeletedAt());
  }
}

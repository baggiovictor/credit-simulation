package com.baggiovictor.creditsimulation.infrastructure.persistence;

import com.baggiovictor.creditsimulation.domain.model.CreditSimulation;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Entity(name = "credit_simulation")
public class CreditSimulationEntity {

  @Id
  @Column(name = "id", nullable = false)
  private final String id;

  @Column(name = "customer_email", nullable = false)
  private final String customerEmail;

  @Column(name = "customer_name", nullable = false)
  private final String customerName;

  @Column(name = "amount", nullable = false)
  private final BigDecimal amount;

  @Column(name = "term_in_months", nullable = false)
  private final int termInMonths;

  @Column(name = "monthly_installment", nullable = false)
  private final BigDecimal monthlyInstallment;

  @Column(name = "total_payment", nullable = false)
  private final BigDecimal totalPayment;

  @Column(name = "total_interest", nullable = false)
  private final BigDecimal totalInterest;

  @Column(name = "interest_rate", nullable = false)
  private final BigDecimal interestRate;

  @Column(name = "created_at", nullable = false)
  private Instant createdAt;

  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  @Column(name = "deleted_at")
  private Instant deletedAt;

  public static CreditSimulationEntity from(final CreditSimulation aCredit) {
    return new CreditSimulationEntity(
        aCredit.getId(),
        aCredit.getCustomerEmail(),
        aCredit.getCustomerName(),
        aCredit.getAmount(),
        aCredit.getTermInMonths(),
        aCredit.getMonthlyInstallment(),
        aCredit.getTotalPayment(),
        aCredit.getTotalInterest(),
        aCredit.getInterestRate(),
        aCredit.getCreatedAt(),
        aCredit.getUpdatedAt(),
        aCredit.getDeletedAt());
  }

  public CreditSimulation toAggregate() {
    return CreditSimulation.with(
        getId(),
        getCustomerEmail(),
        getCustomerName(),
        getAmount(),
        getInterestRate(),
        getTermInMonths(),
        getMonthlyInstallment(),
        getTotalPayment(),
        getTotalInterest(),
        getCreatedAt(),
        getUpdatedAt(),
        getDeletedAt()
    );
  }
}

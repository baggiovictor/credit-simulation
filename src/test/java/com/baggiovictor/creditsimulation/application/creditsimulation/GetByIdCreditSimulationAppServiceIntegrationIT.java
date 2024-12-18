package com.baggiovictor.creditsimulation.application.creditsimulation;

import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import com.baggiovictor.creditsimulation.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class GetByIdCreditSimulationAppServiceIntegrationIT {

  @Autowired
  private CreditSimulationRepository repository;

  private GetByIdCreditSimulationAppService service;

  private CreditSimulationEntity savedEntity;

  @BeforeEach
  void setUp() {
    service = new GetByIdCreditSimulationAppService(repository);
    repository.deleteAll();
    savedEntity = populateDatabase();
  }

  @Test
  void givenExistingId_whenExecute_thenReturnCreditSimulation() {
    CreditSimulation result = service.execute(savedEntity.getId());

    assertNotNull(result);
    assertEquals(savedEntity.getId(), result.getId());
    assertEquals(savedEntity.getCustomerName(), result.getCustomerName());
    assertEquals(savedEntity.getAmount(), result.getAmount());
  }

  @Test
  void givenNonExistingId_whenExecute_thenThrowNotFoundException() {
    assertThrows(NotFoundException.class, () -> service.execute("non-existing-id"));
  }

  private CreditSimulationEntity populateDatabase() {
    CreditSimulationEntity entity = new CreditSimulationEntity(
        "1",
        "victor.baggio@gmail.com",
        "Victor Baggio",
        new BigDecimal("1000.00"),
        12,
        new BigDecimal("100.00"),
        new BigDecimal("1200.00"),
        new BigDecimal("200.00"),
        new BigDecimal("0.01"),
        Instant.now(),
        Instant.now(),
        null
    );
    return repository.save(entity);
  }
}

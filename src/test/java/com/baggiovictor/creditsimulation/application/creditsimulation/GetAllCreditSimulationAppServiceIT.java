package com.baggiovictor.creditsimulation.application.creditsimulation;

import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class GetAllCreditSimulationAppServiceIT {

  @Autowired
  private CreditSimulationRepository repository;

  private GetAllCreditSimulationAppService service;

  @BeforeEach
  void setup() {
    service = new GetAllCreditSimulationAppService(repository);
    repository.deleteAll();
    populateDatabase();
  }

  @Test
  void givenExistingSimulations_whenExecute_thenReturnPaginatedSimulations() {
    var pageable = PageRequest.of(0, 2);

    Slice<CreditSimulation> simulations = service.execute(pageable);

    assertNotNull(simulations);
    assertEquals(2, simulations.getSize());
    assertTrue(simulations.hasNext());

    var simulation = simulations.getContent().get(0);
    assertEquals("John Doe", simulation.getCustomerName());
    assertEquals(new BigDecimal("10000.00"), simulation.getAmount());
  }

  private void populateDatabase() {
    repository.save(new CreditSimulationEntity(
        "1",
        "john.doe@example.com",
        "John Doe",
        new BigDecimal("10000.00"),
        12,
        new BigDecimal("850.00"),
        new BigDecimal("10200.00"),
        new BigDecimal("200.00"),
        new BigDecimal("0.02"),
        Instant.now(),
        Instant.now(),
        null
    ));

    repository.save(new CreditSimulationEntity(
        "2",
        "jane.doe@example.com",
        "Jane Doe",
        new BigDecimal("20000.00"),
        24,
        new BigDecimal("920.00"),
        new BigDecimal("22080.00"),
        new BigDecimal("2080.00"),
        new BigDecimal("0.01"),
        Instant.now(),
        Instant.now(),
        null
    ));

    repository.save(new CreditSimulationEntity(
        "3",
        "mark.smith@example.com",
        "Mark Smith",
        new BigDecimal("5000.00"),
        6,
        new BigDecimal("870.00"),
        new BigDecimal("5220.00"),
        new BigDecimal("220.00"),
        new BigDecimal("0.03"),
        Instant.now(),
        Instant.now(),
        null
    ));
  }
}

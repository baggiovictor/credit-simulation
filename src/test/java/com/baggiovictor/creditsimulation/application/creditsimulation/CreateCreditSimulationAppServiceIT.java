package com.baggiovictor.creditsimulation.application.creditsimulation;

import static com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulationEnum.FIXED_INSTALLMENT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.CreateCreditSimulationUseCase.CreateCreditSimulationCommand;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

@DataJpaTest
public class CreateCreditSimulationAppServiceIT {

  @Autowired
  private CreditSimulationRepository repository;

  private CreateCreditSimulationAppService service;

  @BeforeEach
  void setUp() {
    service = new CreateCreditSimulationAppService(repository);
    repository.deleteAll();
  }

  @Test
  void givenValidCommand_whenExecute_thenSimulationIsPersistedAndReturned() {
    final var expectedAge = 30;
    final var expectedAmount = new BigDecimal("1000.00");
    final var expectedTerm = 12;
    final var expectedEmail = "baggiovictor@gmail.com";
    final var expectedName = "Victor Baggio";

    final var command = new CreateCreditSimulationCommand(
        expectedAmount,
        LocalDate.now().minusYears(expectedAge),
        expectedTerm,
        FIXED_INSTALLMENT,
        expectedEmail,
        expectedName
    );

    final var result = service.execute(command);

    assertNotNull(result);

    var savedEntity = repository.findById(result).orElse(null);
    assertNotNull(savedEntity);
    assertEquals(expectedEmail, savedEntity.getCustomerEmail());
    assertEquals(expectedName, savedEntity.getCustomerName());
    assertEquals(expectedAmount, savedEntity.getAmount());
    assertEquals(expectedTerm, savedEntity.getTermInMonths());
  }


  @Test
  void givenMultipleValidCommands_whenExecute_thenAllSimulationsArePersisted() {
    final var command1 = new CreateCreditSimulationCommand(
        new BigDecimal("5000.00"),
        LocalDate.now().minusYears(25),
        24,
        FIXED_INSTALLMENT,
        "john.doe@example.com",
        "John Doe"
    );

    final var command2 = new CreateCreditSimulationCommand(
        new BigDecimal("15000.00"),
        LocalDate.now().minusYears(40),
        36,
        FIXED_INSTALLMENT,
        "jane.doe@example.com",
        "Jane Doe"
    );

    service.execute(command1);
    service.execute(command2);

    var simulations = repository.findAll(PageRequest.of(0, 10));
    assertEquals(2, simulations.getContent().size());
  }
}

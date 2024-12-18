package com.baggiovictor.creditsimulation.application.creditsimulation;

import static com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulationEnum.FIXED_INSTALLMENT;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.CreateInLotCreditSimulationUseCase.CreateInLotCreditSimulationCommand;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CreateInLotCreditSimulationAppServiceIT {

  @Autowired
  private CreditSimulationRepository repository;

  private CreateInLotCreditSimulationAppService service;

  @BeforeEach
  void setUp() {
    service = new CreateInLotCreditSimulationAppService(repository);
    repository.deleteAll();
  }

  @Test
  void givenValidBatch_whenExecute_thenSimulationsAreSaved() throws InterruptedException {
    List<CreateInLotCreditSimulationCommand> commandList = createSampleCommands(200);

    service.execute(commandList);

    Thread.sleep(2000);

    assertEquals(200, repository.count());
  }

  @Test
  void givenEmptyBatch_whenExecute_thenNoSimulationsAreSaved() {
    List<CreateInLotCreditSimulationCommand> commandList = new ArrayList<>();

    service.execute(commandList);

    assertEquals(0, repository.count());
  }

  @Test
  void givenBatchWithInvalidData_whenExecute_thenSimulationsAreNotSaved() {
    List<CreateInLotCreditSimulationCommand> commandList = new ArrayList<>();
    commandList.add(new CreateInLotCreditSimulationCommand(
        new BigDecimal("-1000.00"),
        LocalDate.now().minusYears(30),
        12,
        FIXED_INSTALLMENT,
        "Invalid Customer",
        "invalid.email@example.com"
    ));

    service.execute(commandList);

    assertEquals(0, repository.count());
  }

  private List<CreateInLotCreditSimulationCommand> createSampleCommands(int count) {
    List<CreateInLotCreditSimulationCommand> commandList = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      commandList.add(new CreateInLotCreditSimulationCommand(
          new BigDecimal("1000.00"),
          LocalDate.now().minusYears(30),
          12,
          FIXED_INSTALLMENT,
          "Customer " + i,
          "customer" + i + "@example.com"
      ));
    }
    return commandList;
  }
}


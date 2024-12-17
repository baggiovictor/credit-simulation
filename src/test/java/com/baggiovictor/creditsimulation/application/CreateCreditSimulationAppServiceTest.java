package com.baggiovictor.creditsimulation.application;

import static com.baggiovictor.creditsimulation.domain.model.CreditSimulationEnum.FIXED_INSTALLMENT;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.baggiovictor.creditsimulation.application.usecases.CreateCreditSimulationUseCase.CreateCreditSimulationCommand;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CreateCreditSimulationAppServiceTest {

  @InjectMocks
  private CreateCreditSimulationAppService service;

  @Mock
  private CreditSimulationRepository repository;

  @BeforeEach
  void setUp() {
  }

  @Test
  void givenValidCommand_whenExecute_thenSimulationIdIsReturned() {
    final var expectedAge = 30;
    final var expectedAmount = new BigDecimal("1000.00");
    final var expectedTerm = 12;

    final var command = new CreateCreditSimulationCommand(
        expectedAmount,
        LocalDate.now().minusYears(expectedAge),
        expectedTerm,
        FIXED_INSTALLMENT
    );

    final var result = service.execute(command);

    assertNotNull(result);

    verify(repository).save(any(CreditSimulationEntity.class));
  }
}

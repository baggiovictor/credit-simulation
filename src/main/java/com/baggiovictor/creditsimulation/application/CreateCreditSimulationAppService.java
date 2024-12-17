package com.baggiovictor.creditsimulation.application;

import static com.baggiovictor.creditsimulation.domain.model.CreditSimulation.newCreditSimulation;
import static java.time.LocalDate.now;

import com.baggiovictor.creditsimulation.application.usecases.CreateCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationRepository;
import java.time.Period;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCreditSimulationAppService implements CreateCreditSimulationUseCase {

  private final CreditSimulationRepository repository;

  @Override
  public String execute(CreateCreditSimulationCommand command) {
    final var anAge = Period.between(command.customerBirthDate(), now()).getYears();
    final var aAmount = command.amount();
    final var aTermInMonths = command.termInMonths();
    final var aType = command.type();

    final var aCreditSimulation = newCreditSimulation(
        aAmount,
          aTermInMonths,
        anAge,
        aType
    );

    repository.save(CreditSimulationEntity.from(aCreditSimulation));

    return aCreditSimulation.getId();
  }
}
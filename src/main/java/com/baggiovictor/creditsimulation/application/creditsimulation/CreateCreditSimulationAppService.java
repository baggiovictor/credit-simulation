package com.baggiovictor.creditsimulation.application.creditsimulation;

import static com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation.newCreditSimulation;
import static java.time.LocalDate.now;

import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.CreateCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.validation.handler.Notification;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
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
    final var aName = command.name();
    final var anEmail = command.email();

    final var notification = Notification.create();

    final var aCreditSimulation = newCreditSimulation(
        aAmount,
        aTermInMonths,
        anAge,
        aType,
        anEmail,
        aName
    );

    aCreditSimulation.validate(notification);

    repository.save(CreditSimulationEntity.from(aCreditSimulation));

    return aCreditSimulation.getId();
  }
}
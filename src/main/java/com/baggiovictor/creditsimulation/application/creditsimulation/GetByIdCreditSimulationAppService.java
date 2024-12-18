package com.baggiovictor.creditsimulation.application.creditsimulation;

import static java.util.Objects.isNull;

import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.GetByIdCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import com.baggiovictor.creditsimulation.domain.exceptions.NotFoundException;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetByIdCreditSimulationAppService implements GetByIdCreditSimulationUseCase {

  private final CreditSimulationRepository repository;

  @Override
  public CreditSimulation execute(String id) {
    return repository
        .findById(id)
        .map(CreditSimulationEntity::toAggregate)
        .orElseThrow(this::notFound);
  }

  private NotFoundException notFound() {
    return NotFoundException.with(CreditSimulation.class);
  }


}

package com.baggiovictor.creditsimulation.application;

import static java.util.Objects.isNull;

import com.baggiovictor.creditsimulation.application.usecases.GetByIdCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetByIdCreditSimulationAppService implements GetByIdCreditSimulationUseCase {

  private final CreditSimulationRepository repository;

  @Override
  public Optional<CreditSimulation> execute(String id) {
    if (isNull(id)) {
      throw new IllegalArgumentException("Id cannot be null");
    }

    return repository.findById(id).map(CreditSimulationEntity::toAggregate);
  }


}

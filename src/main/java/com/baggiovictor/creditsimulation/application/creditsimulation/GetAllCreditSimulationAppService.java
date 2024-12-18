package com.baggiovictor.creditsimulation.application.creditsimulation;

import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.GetAllCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.creditsimulation.persistence.CreditSimulationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetAllCreditSimulationAppService implements GetAllCreditSimulationUseCase {

  private final CreditSimulationRepository repository;

  @Override
  public Slice<CreditSimulation> execute(Pageable page) {
    return repository.findAll(page).map(CreditSimulationEntity::toAggregate);
  }
}

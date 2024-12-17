package com.baggiovictor.creditsimulation.application;

import com.baggiovictor.creditsimulation.application.usecases.GetAllCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationEntity;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationRepository;
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

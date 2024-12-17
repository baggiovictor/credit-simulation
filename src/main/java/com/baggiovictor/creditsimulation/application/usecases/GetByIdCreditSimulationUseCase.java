package com.baggiovictor.creditsimulation.application.usecases;

import com.baggiovictor.creditsimulation.domain.model.CreditSimulation;
import java.util.Optional;

public interface GetByIdCreditSimulationUseCase {

  Optional<CreditSimulation> execute(String id);



}

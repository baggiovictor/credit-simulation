package com.baggiovictor.creditsimulation.application.creditsimulation.usecases;

import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import java.util.Optional;

public interface GetByIdCreditSimulationUseCase {

  CreditSimulation execute(String id);



}

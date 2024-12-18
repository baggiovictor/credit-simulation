package com.baggiovictor.creditsimulation.application.creditsimulation.usecases;

import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface GetAllCreditSimulationUseCase {

  Slice<CreditSimulation> execute(Pageable page);
}

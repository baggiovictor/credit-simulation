package com.baggiovictor.creditsimulation.application.usecases;

import com.baggiovictor.creditsimulation.domain.model.CreditSimulation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface GetAllCreditSimulationUseCase {

  Slice<CreditSimulation> execute(Pageable page);
}

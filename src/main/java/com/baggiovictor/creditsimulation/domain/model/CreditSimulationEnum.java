package com.baggiovictor.creditsimulation.domain.model;

import com.baggiovictor.creditsimulation.domain.strategy.credit.CreditSimulationStrategy;
import com.baggiovictor.creditsimulation.domain.strategy.credit.FixedInstallmentSimulationStrategy;

public enum CreditSimulationEnum {
  FIXED_INSTALLMENT {
    @Override
    public CreditSimulationStrategy calculateSimulation() {
      return new FixedInstallmentSimulationStrategy();
    }
  };

  public abstract CreditSimulationStrategy calculateSimulation();
}

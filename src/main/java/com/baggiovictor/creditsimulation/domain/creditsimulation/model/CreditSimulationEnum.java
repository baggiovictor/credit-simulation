package com.baggiovictor.creditsimulation.domain.creditsimulation.model;

import com.baggiovictor.creditsimulation.domain.creditsimulation.strategy.credit.CreditSimulationStrategy;
import com.baggiovictor.creditsimulation.domain.creditsimulation.strategy.credit.FixedInstallmentSimulationStrategy;

public enum CreditSimulationEnum {
  FIXED_INSTALLMENT {
    @Override
    public CreditSimulationStrategy calculateSimulation() {
      return new FixedInstallmentSimulationStrategy();
    }
  };

  public abstract CreditSimulationStrategy calculateSimulation();
}

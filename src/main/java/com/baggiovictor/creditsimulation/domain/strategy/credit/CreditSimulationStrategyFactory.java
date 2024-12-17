package com.baggiovictor.creditsimulation.domain.strategy.credit;

import com.baggiovictor.creditsimulation.domain.model.CreditSimulationEnum;

public class CreditSimulationStrategyFactory {

  public static CreditSimulationStrategy getCreditStrategy(CreditSimulationEnum creditSimulationEnum) {
    return creditSimulationEnum.calculateSimulation();
  }
}

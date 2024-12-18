package com.baggiovictor.creditsimulation.domain.creditsimulation.strategy.credit;

import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulationEnum;

public class CreditSimulationStrategyFactory {

  public static CreditSimulationStrategy getCreditStrategy(CreditSimulationEnum creditSimulationEnum) {
    return creditSimulationEnum.calculateSimulation();
  }
}

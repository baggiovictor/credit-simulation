package com.baggiovictor.creditsimulation.infrastructure.api;

import com.baggiovictor.creditsimulation.application.CreateCreditSimulationAppService;
import com.baggiovictor.creditsimulation.application.usecases.CreateCreditSimulationUseCase.CreateCreditSimulationCommand;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreditSimulationController {

  private final CreateCreditSimulationAppService service;

  @PostMapping("/simulate")
  public String createSimulation(@RequestBody CreateCreditSimulationCommand command) {
    return service.execute(command);
  }
}

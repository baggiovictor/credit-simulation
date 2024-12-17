package com.baggiovictor.creditsimulation.infrastructure.api;

import com.baggiovictor.creditsimulation.application.CreateCreditSimulationAppService;
import com.baggiovictor.creditsimulation.application.GetAllCreditSimulationAppService;
import com.baggiovictor.creditsimulation.application.usecases.CreateCreditSimulationUseCase.CreateCreditSimulationCommand;
import com.baggiovictor.creditsimulation.application.usecases.GetByIdCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.model.CreditSimulation;
import com.baggiovictor.creditsimulation.infrastructure.persistence.CreditSimulationEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CreditSimulationController {

  private final CreateCreditSimulationAppService createService;
  private final GetAllCreditSimulationAppService getAllService;
  private final GetByIdCreditSimulationUseCase getByIdService;

  @PostMapping("/simulate")
  public String createSimulation(@RequestBody CreateCreditSimulationCommand command) {
    return createService.execute(command);
  }

  @GetMapping("/simulations")
  public Slice<CreditSimulation> getAllSimulations(Pageable page) {
    return getAllService.execute(page);
  }

  @GetMapping("/simulations/{id}")
  public CreditSimulation getSimulationById(@RequestParam String id) {
    return getByIdService.execute(id)
        .orElseThrow(() -> new IllegalArgumentException("Simulation not found"));
  }
}

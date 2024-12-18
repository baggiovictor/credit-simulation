package com.baggiovictor.creditsimulation.infrastructure.creditsimulation.api;

import com.baggiovictor.creditsimulation.application.creditsimulation.CreateCreditSimulationAppService;
import com.baggiovictor.creditsimulation.application.creditsimulation.CreateInLotCreditSimulationAppService;
import com.baggiovictor.creditsimulation.application.creditsimulation.GetAllCreditSimulationAppService;
import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.CreateCreditSimulationUseCase.CreateCreditSimulationCommand;
import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.CreateInLotCreditSimulationUseCase.CreateInLotCreditSimulationCommand;
import com.baggiovictor.creditsimulation.application.creditsimulation.usecases.GetByIdCreditSimulationUseCase;
import com.baggiovictor.creditsimulation.domain.creditsimulation.model.CreditSimulation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/simulations")
@Tag(name = "Credit Simulation", description = "Operations related to credit simulation")
public class CreditSimulationController {

  private final CreateCreditSimulationAppService createService;
  private final GetAllCreditSimulationAppService getAllService;
  private final GetByIdCreditSimulationUseCase getByIdService;
  private final CreateInLotCreditSimulationAppService createInLotService;


  @PostMapping
  @Operation(summary = "Create a new credit simulation", method = "POST")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Simulation created"),
      @ApiResponse(responseCode = "400", description = "Invalid input"),
  })
  public String createSimulation(@RequestBody CreateCreditSimulationCommand command) {
    return createService.execute(command);
  }

  @PostMapping("/batch")
  @Operation(summary = "Create in lot new simulations", method = "POST")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Simulation created"),
      @ApiResponse(responseCode = "400", description = "Invalid input"),
  })
  public void processSimulationsInBatch(@RequestBody List<CreateInLotCreditSimulationCommand> simulations) {
    createInLotService.execute(simulations);
  }

  @GetMapping
  @Operation(summary = "Get all credit simulations", method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Simulations found"),
      @ApiResponse(responseCode = "404", description = "Simulations not found"),
  })
  public Slice<CreditSimulation> getAllSimulations(Pageable page) {
    return getAllService.execute(page);
  }

  @GetMapping("/{id}")
  @Operation(summary = "Get a credit simulation by id", method = "GET")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Simulations found"),
      @ApiResponse(responseCode = "404", description = "Simulations not found"),
  })
  public CreditSimulation getSimulationById(@RequestParam String id) {
    return getByIdService.execute(id);
  }
}

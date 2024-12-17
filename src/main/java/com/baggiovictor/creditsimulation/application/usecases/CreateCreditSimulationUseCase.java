package com.baggiovictor.creditsimulation.application.usecases;

import com.baggiovictor.creditsimulation.domain.model.CreditSimulationEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface CreateCreditSimulationUseCase {

  String execute(final CreateCreditSimulationCommand command);

  record CreateCreditSimulationCommand(

      @JsonProperty("valorSolicitado") BigDecimal amount,
      @JsonProperty("dataNascimento") LocalDate customerBirthDate,
      @JsonProperty("prazoPagamento") int termInMonths,
      @JsonProperty("tipoEmprestimo") CreditSimulationEnum type,
      @JsonProperty("nome") String name,
      @JsonProperty("email") String email) {

  }
}

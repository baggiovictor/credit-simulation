package com.baggiovictor.creditsimulation.domain.creditsimulation.model;

import static java.math.BigDecimal.ZERO;
import static java.util.Objects.isNull;

import com.baggiovictor.creditsimulation.domain.validation.ErrorMessage;
import com.baggiovictor.creditsimulation.domain.validation.ValidationHandler;
import com.baggiovictor.creditsimulation.domain.validation.Validator;
import java.math.BigDecimal;
import java.util.Objects;

public class CreditSimulationValidator extends Validator {

  private final CreditSimulation creditSimulation;

  public CreditSimulationValidator(CreditSimulation creditSimulation,
      final ValidationHandler aHandler) {
    super(aHandler);
    this.creditSimulation = creditSimulation;
  }


  @Override
  public void validate() {
    checkParamsConstraints();
  }

  private void checkParamsConstraints() {
    final var creditSimulation = this.creditSimulation;

    if (isNull(creditSimulation)) {
      this.validationHandler().append(new ErrorMessage("'creditSimulation' should not be null"));
      return;
    }

    if (isNull(creditSimulation.getAmount())) {
      this.validationHandler().append(new ErrorMessage("'loanAmount' should not be null"));
      return;
    }

    if (isGreaterThanZero(creditSimulation.getAmount())) {
      this.validationHandler().append(new ErrorMessage("'loanAmount' should be greater than 0"));
      return;
    }

    if (isNull(creditSimulation.getMonthlyInstallment())) {
      this.validationHandler().append(new ErrorMessage("'installments' should not be null"));
      return;
    }

    if (isGreaterThanZero(creditSimulation.getMonthlyInstallment())) {
      this.validationHandler().append(new ErrorMessage("'installments' should be greater than 0"));
    }
  }

  private boolean isGreaterThanZero(BigDecimal value) {
    return Objects.nonNull(value) && value.compareTo(ZERO) > 0;
  }
}

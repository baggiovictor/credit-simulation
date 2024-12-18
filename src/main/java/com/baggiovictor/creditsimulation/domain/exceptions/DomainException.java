package com.baggiovictor.creditsimulation.domain.exceptions;

import com.baggiovictor.creditsimulation.domain.validation.ErrorMessage;
import java.util.List;

public class DomainException extends NoStacktraceException {

  protected final List<ErrorMessage> errors;

  protected DomainException(final String aMessage, final List<ErrorMessage> anErrors) {
    super(aMessage);
    this.errors = anErrors;
  }
}

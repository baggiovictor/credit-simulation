package com.baggiovictor.creditsimulation.domain.exceptions;

import com.baggiovictor.creditsimulation.domain.validation.ErrorMessage;
import java.util.Collections;
import java.util.List;

public class NotFoundException extends DomainException {

  protected NotFoundException(final String aMessage, final List<ErrorMessage> anErrors) {
    super(aMessage, anErrors);
  }

  public static NotFoundException with(
      final Class<?> anAggregate
  ) {

    return new NotFoundException("not found", Collections.emptyList());
  }
}

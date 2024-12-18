package com.baggiovictor.creditsimulation.domain.validation;

public interface ValidationHandler {

    ValidationHandler append(ErrorMessage anError);
}

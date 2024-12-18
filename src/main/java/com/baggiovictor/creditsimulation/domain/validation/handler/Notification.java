package com.baggiovictor.creditsimulation.domain.validation.handler;

import com.baggiovictor.creditsimulation.domain.validation.ErrorMessage;
import com.baggiovictor.creditsimulation.domain.validation.ValidationHandler;
import java.util.ArrayList;
import java.util.List;

public class Notification implements ValidationHandler {

    private final List<ErrorMessage> errors;

    private Notification(final List<ErrorMessage> errors) {
        this.errors = errors;
    }

    public static Notification create() {
        return new Notification(new ArrayList<>());
    }

    @Override
    public Notification append(final ErrorMessage anError) {
        this.errors.add(anError);
        return this;
    }
}
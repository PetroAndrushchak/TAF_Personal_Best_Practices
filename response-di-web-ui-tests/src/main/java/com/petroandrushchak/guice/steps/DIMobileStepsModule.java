package com.petroandrushchak.guice.steps;

import com.google.inject.AbstractModule;
import com.petroandrushchak.guice.steps.mobile.LogInStepsMobile;

public class DIMobileStepsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LoginSteps.class).toInstance(new LogInStepsMobile());

    }
}

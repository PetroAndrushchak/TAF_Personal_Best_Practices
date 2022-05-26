package com.petroandrushchak.guice.steps;

import com.google.inject.AbstractModule;
import com.petroandrushchak.guice.steps.desktop.LogInStepsDesktop;

public class DIDesktopStepsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LoginSteps.class).toInstance(new LogInStepsDesktop());
    }
}

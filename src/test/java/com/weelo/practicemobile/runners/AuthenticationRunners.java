package com.weelo.practicemobile.runners;

import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/authentication.feature",
        glue = "com.weelo.practicemobile.stepdefinitions",
        snippets = CAMELCASE
        )
public class AuthenticationRunners {
}

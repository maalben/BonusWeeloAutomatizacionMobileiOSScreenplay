package com.weelo.practicemobile.stepdefinitions;

import com.weelo.practicemobile.exceptions.AssertionsAutomationMobilepractice;
import com.weelo.practicemobile.models.TestData;
import com.weelo.practicemobile.questions.TheAlert;
import com.weelo.practicemobile.questions.TheTitle;
import com.weelo.practicemobile.tasks.Load;
import com.weelo.practicemobile.tasks.Login;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

import static com.weelo.practicemobile.util.Constants.EXPECTED;
import static org.hamcrest.Matchers.is;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.core.IsEqual.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import java.util.List;
import java.util.Map;

public class AuthenticationStepDefinitios {

    @Managed(driver ="appium")
    private WebDriver hisBrowser;
    Actor mario = Actor.named("Mario");

    @Before
    public void setup()
    {
        mario.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^I load test data$")
    public void iLoadTestData(List<Map<String, String>> data) {
        mario.wasAbleTo(Load.testData(data.get(0)));
    }

    @When("^I try to login myself using my data authentication$")
    public void iTryToLoginMyselfUsingMyDataAuthentication(){
        mario.attemptsTo(Login.inDemoApplicationSauceLabs());
    }

    @Then("^I should see the title screen expected$")
    public void iShouldSeeTheTitleScreenExpected(){
        mario.should(seeThat(TheTitle.is(), equalTo(true))
                .orComplainWith(AssertionsAutomationMobilepractice.class,
                        AssertionsAutomationMobilepractice.TITLE_ELEMENT_NO_EXPECTED));
    }

    @Then("^I should see the alert with message expected$")
    public void iShouldSeeTheAlertWithMessageExpected(){
        mario.should(seeThat(TheAlert.message(), is(TestData.getData().get(EXPECTED).toString()))
                .orComplainWith(AssertionsAutomationMobilepractice.class,
                        AssertionsAutomationMobilepractice.ALERT_MESSAGE_NO_EXPECTED));
    }
}

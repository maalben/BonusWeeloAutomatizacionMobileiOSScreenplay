package com.weelo.practicemobile.questions;

import com.weelo.practicemobile.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.weelo.practicemobile.userinterfaces.AuthenticationUserInterfaces.ALERT_MESSAGE_ERROR;
import static com.weelo.practicemobile.util.Constants.EXPECTED;
import static com.weelo.practicemobile.util.Constants.TIME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TheAlert implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(ALERT_MESSAGE_ERROR.of(TestData.getData().get(EXPECTED).toString()), isVisible()).forNoMoreThan(TIME).seconds());
        return Text.of(ALERT_MESSAGE_ERROR.of(TestData.getData().get(EXPECTED).toString().trim())).answeredBy(actor).toString();
    }

    public static TheAlert message() {
        return  new TheAlert();
    }
}

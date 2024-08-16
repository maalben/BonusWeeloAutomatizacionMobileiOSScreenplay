package com.weelo.practicemobile.tasks;

import com.weelo.practicemobile.models.TestData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static com.weelo.practicemobile.userinterfaces.AuthenticationUserInterfaces.*;
import static com.weelo.practicemobile.util.Constants.PASS;
import static com.weelo.practicemobile.util.Constants.USER;

public class Login implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(!TestData.getData().get(USER).toString().equals("null")){
            actor.attemptsTo(Enter.theValue(TestData.getData().get(USER).toString()).into(TEXTFIELD_USER));
        }
           actor.attemptsTo(Enter.theValue(TestData.getData().get(PASS).toString()).into(TEXTFIELD_PASSWORD));
           actor.attemptsTo(Click.on(BUTTON_LOGIN));
    }

    public static Login inDemoApplicationSauceLabs() {

        return Tasks.instrumented(Login.class);
    }
}

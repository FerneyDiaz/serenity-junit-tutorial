package serenityswag.authentication.pricing;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WhenLogIn {
    @Managed
    WebDriver driver;

    @Steps
    LogInAction login;

    @Test
    public void userCanLogIn(){
        login.as(UserASW.COMERCIAL);
    }
}

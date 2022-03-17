package serenityswag.authentication.actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginAction;
import serenityswag.authentication.actions.User;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenLoggingOn {
    @Managed
    WebDriver webDriver;

    @Steps
    LoginAction login;
    InventoryPage inventoryPage;
    @Test
    public void userCanLogOnViaHomePage(){
        login.as(User.STANDARD_USER);
        Serenity.reportThat("The inventory page should be displayed with correct title",
                () -> assertThat(inventoryPage.getHeadingTitle())
                        .isEqualToIgnoringCase("product")
        );
//        assertThat(inventoryPage.getHeadingTitle())
//                .isEqualToIgnoringCase("products");

    }

}

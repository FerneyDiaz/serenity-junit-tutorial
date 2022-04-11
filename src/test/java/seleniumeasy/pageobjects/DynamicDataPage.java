package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@DefaultUrl("https://demoqa.com/alerts")
public class DynamicDataPage extends PageObject {

    private static final By USER_DETAIL_PANEL = By.id("loading");
    public void getNewUser() {
        $(FormButton.withLabel("Get new user")).click();
        withTimeoutOf(Duration.ofSeconds(30))
                .waitFor(
                        ExpectedConditions.invisibilityOfElementWithText(USER_DETAIL_PANEL,"loading...")
                );

    }

    public String userDescription() {
        return $(USER_DETAIL_PANEL).getText();
    }
}

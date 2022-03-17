package serenityswag.authentication.pricing;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LogInAction extends PageObject {
    public void as(UserASW userASW) {
        openUrl("https://blocks.asw.edu.co/#/login");
        waitFor(5).seconds();
        $("#email").sendKeys(userASW.getUsername());
        $("#password").sendKeys(userASW.getPassword());
        $(By.xpath("//button[contains(text(),'Enviar')]")).click();
    }
}

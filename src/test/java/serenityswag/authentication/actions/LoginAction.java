package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {
    @Step("Log in as {0}")
    public void as(User user) {
        //        webDriver.get("https://www.saucedemo.com/");
        openUrl("https://www.saucedemo.com/");

//        webDriver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
//        webDriver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
//        webDriver.findElement(By.cssSelector("#login-button")).click();
        $(LoginForm.USER_NAME).sendKeys(user.getUsername());
        $(LoginForm.PASSWORD).sendKeys(user.getPassword());
        $(LoginForm.LOGIN_BUTTON).click();
    }

}

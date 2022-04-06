package seleniumeasy.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import seleniumeasy.pageobjects.FormPage;

public class NavigateActions extends UIInteractionSteps {
    @Step
    public void to(FormPage formPage){
        openPageNamed(formPage.name());
    }

}

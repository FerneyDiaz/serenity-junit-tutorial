package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@DefaultUrl("https://demoqa.com/modal-dialogs")
public class ModelDialogPage extends SeleniumEasyForm{
    private final static By LUNCH_MODAL_BUTTON = By.cssSelector("#showSmallModal");
    private final static By SAVE_CHANGES_BUTTON = By.cssSelector("#closeSmallModal");

    public void openModal(){
        $(LUNCH_MODAL_BUTTON).click();
    }

    public WebElementState saveChangesButton(){return $(SAVE_CHANGES_BUTTON);}
    public void saveChanges(){
        $(SAVE_CHANGES_BUTTON).click();
    }
}


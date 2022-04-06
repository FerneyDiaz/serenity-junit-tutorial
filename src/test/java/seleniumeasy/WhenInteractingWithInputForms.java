package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.*;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This is a series of exercises designed to explore how to use
 * Serenity BDD to test various kinds of HTML elements
 */
@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {
    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    /**
     * Basic form fields:
     * Enter a message and check that the message is correctly displayed
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */
    SingleInputFieldForm singleInputFieldForm;
    @Test
    public void basicForms() {
        //singleInputFieldForm.open();
        navigate.to(FormPage.SingleInputFieldForm);
        singleInputFieldForm.enterMessage("Hi there");
        singleInputFieldForm.showMessage();
        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi there");
    }

    /**
     * Basic form fields (part 2)
     * Enter two values and calculate the result
     * https://www.seleniumeasy.com/test/basic-first-form-demo.html
     */

    TwoInputFieldForm twoInputFieldForm;
    @Test
    public void basicFormsWithMultipleFields() {
        //twoInputFieldForm.open();
        navigate.to(FormPage.TwoInputFieldForm);
        twoInputFieldForm.enterA("2");
        twoInputFieldForm.enterB("3");
        twoInputFieldForm.getTotal();
        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo("5");
    }

    /**
     * Checkboxes
     * Check that a message appears when you click the checkbox
     * https://www.seleniumeasy.com/test/basic-checkbox-demo.html
     */
    CheckboxForm checkboxForm;
    @Test
    public void singleCheckbox() {
        navigate.to(FormPage.CheckboxForm);
        checkboxForm.setAgeSelected();
        assertThat(checkboxForm.ageText()).isEqualTo("Success - Check box is checked");
    }

    private static final List<String> ALL_THE_OPTIONS = asList("Option 1","Option 2","Option 3","Option 4");
    @Test
    public void multipleCheckboxes() {
        navigate.to(FormPage.CheckboxForm);
        assertThat(ALL_THE_OPTIONS).allMatch(
                item -> !checkboxForm.optionIsCheckedFor(item)
        );
        /*assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 3")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 4")).isFalse();*/

        checkboxForm.checkAll();
        assertThat(ALL_THE_OPTIONS).allMatch(
                item -> checkboxForm.optionIsCheckedFor(item)
        );
        /*assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 3")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 4")).isTrue();*/
    }

    /**
     * Radio buttons
     * Check that a message appears when you click the radio button
     * https://www.seleniumeasy.com/test/basic-radiobutton-demo.html
     */
    RadioButtonForm radioButtonForm;
    @Test
    public void radioButtons() {
        radioButtonForm.open();
        radioButtonForm.selectOption("Male");
        radioButtonForm.getCheckedValue();
        assertThat(radioButtonForm.getResult()).isEqualTo("Radio button 'Male' is checked");
    }
    MultipleRadioButtonForm multipleRadioButtonForm;
    @Test
    public void multipleRadioButtons() {
        multipleRadioButtonForm.open();
        multipleRadioButtonForm.selectGender("Female");
        multipleRadioButtonForm.selectAgeGroup("15 - 50");
        multipleRadioButtonForm.getValues();
        assertThat(multipleRadioButtonForm.getResult())
                .contains("Sex: Female")
                .contains("Age group: 15 - 50");
    }

    /**
     * Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    SelectListForm selectListForm;
    @Test
    public void selectList() {
        selectListForm.open();
        assertThat(selectListForm.selectedDay()).isEmpty();
        selectListForm.selectDay("Wednesday");
        assertThat(selectListForm.selectedDay()).isEqualTo("Wednesday");
    }

    /**
     * Multi-Select Dropdown lists
     * https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html
     */
    MultipleSelectListForm multipleSelectListForm;
    @Test
    public void multiSelectList() {
        multipleSelectListForm.open();
        assertThat(multipleSelectListForm.selectedStates()).isEmpty();
        multipleSelectListForm.selectStates("Florida","Ohio","Texas");
        assertThat(multipleSelectListForm.selectedStates()).containsExactly("Florida","Ohio","Texas");
    }

    HoverPage hoverPage;
    @Test
    public void hover(){
        hoverPage.open();
        hoverPage.hoverOverFigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();
        hoverPage.captionForFigure(1).shouldContainText("user1");
    }
}

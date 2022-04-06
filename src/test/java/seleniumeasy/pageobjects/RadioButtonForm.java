package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.junit.runner.RunWith;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html")
public class RadioButtonForm extends SeleniumEasyForm {

    public void selectOption(String value) {
        //$("//input[@name='optradio'][@value='{0}']",value).click();
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        $("#buttoncheck").click();
    }

    public String getResult() {
        return $(".radiobutton").getText();
    }
}

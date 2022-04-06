package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("https://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    private static final String FIGURE_IMAGE = "//*[@class='figure'][{0}]";
    private static final String FIGURE_CAPTION = "//*[@class='figcaption'][{0}]";

    public void hoverOverFigure(int number) {
        WebElementFacade figure = $(FIGURE_IMAGE,number);
        //$$("//*[@class='figure']").get(number -1);
        new Actions(getDriver()).moveToElement(figure).perform();
    }

    public WebElementState captionForFigure(int number) {

        return $(FIGURE_CAPTION,number);
    }
}

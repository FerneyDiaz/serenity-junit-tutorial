package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;

public class InventoryPage extends PageObject {
    public String getHeadingTitle() {
        //        assertThat(webDriver.findElement(By.cssSelector(".title")).getText())
//                .isEqualToIgnoringCase("products");
        return $(".title").getText();
    }
}

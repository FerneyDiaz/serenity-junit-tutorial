package serenityswag.inventory;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class ViewProductDetailAction extends PageObject {

    @Step("View product details for product {0}")
    public void forProductWithName(String firstItemName) {
        $(ProductList.productDetailsLinkFor(firstItemName)).click();
    }
}

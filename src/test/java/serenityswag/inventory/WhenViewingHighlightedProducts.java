package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginAction;
import serenityswag.authentication.actions.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenViewingHighlightedProducts {
    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    LoginAction login;
    ProductList productList;
    ProductDetail productDetail;
    ViewProductDetailAction viewProductDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage(){
        login.as(User.STANDARD_USER);
        List<String> productsOnDisplay = productList.titles();
        assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");
    }

    @Test
    public void highLightedProductShouldDisplayedToCorrespondingImage(){
        login.as(User.STANDARD_USER);
        List<String> productOnDisplay = productList.titles();
        SoftAssertions softly = new SoftAssertions();
        productOnDisplay.forEach(
                productName -> softly.assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName)
        );
        softly.assertAll();
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage(){
        login.as(User.STANDARD_USER);
        String firstItemName = productList.titles().get(0);
        viewProductDetails.forProductWithName(firstItemName);
        Serenity.reportThat("The product name should be correctly displayed",
                ()->assertThat(productDetail.productName()).isEqualTo(firstItemName)
                );
        Serenity.reportThat("The product image should have the correct alt text",
                ()-> productDetail.productImageWithAltValueOf(firstItemName).shouldBeVisible()
                );

    }
}

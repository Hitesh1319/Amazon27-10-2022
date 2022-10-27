package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.Given;

import java.io.IOException;

public class AddMultipleProductsToWishlistAndSelectOneProductFromWishlistAndAddItToCart extends BaseClass {

    @Given("Navigate to website.")
    public void navigate_to_website() throws IOException {
    Setup();
    }
}

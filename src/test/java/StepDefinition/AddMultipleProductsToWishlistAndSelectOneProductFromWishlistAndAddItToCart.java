package StepDefinition;

import Pages.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AddMultipleProductsToWishlistAndSelectOneProductFromWishlistAndAddItToCart extends BaseClass {

    @Given("Navigate to website.")
    public void navigate_to_website() throws IOException {
        Setup();
    }

    @And("Navigate to search section and search for mobiles")
    public void navigate_to_search_section_and_search_for_mobiles() throws IOException {
        pageFactory.getSearchBar().searchMobile();
    }
    @And("Select the specific mobile, capture the Name\\(full) of the product as displayed on UI")
    public void select_the_specific_mobile_capture_the_name_full_of_the_product_as_displayed_on_ui() {
        pageFactory.getMobilePage().clickingOnMobile();
        pageFactory.getMobilePage().printingMobile();
    }

    @And("Check for the Size Name and colors available and print the same on console.")
    public void check_for_the_size_name_and_colors_available_and_print_the_same_on_console() {
        pageFactory.getMobilePage().printingColourAndVariant();
    }
    @And("Navigate to Customer questions & answers and list top 3 questions and answers.")
    public void navigate_to_customer_questions_answers_and_list_top_questions_and_answers() {
        pageFactory.getMobilePage().navigateToCustomersQuestionAndAnswer();
    }
    @When("Add the item to the cart, put assertion on the product added to cart.")
    public void add_the_item_to_the_cart_put_assertion_on_the_product_added_to_cart() {
        pageFactory.getMobilePage().clickingOnAddToCartButton();
        pageFactory.getCartPage().verifyProductAdded();
    }
    @And("Navigate to Shopping Cart button, increase the order Quantity to.")
    public void navigate_to_shopping_cart_button_increase_the_order_quantity_to() {
        pageFactory.getCartPage().increasingQuantity();
    }
    @Then("Verify the item quantity inside the cart and list the total amount for the order.")
    public void verify_the_item_quantity_inside_the_cart_and_list_the_total_amount_for_the_order() {
        pageFactory.getCartPage().verifyTheItemQuantityAndListTheTotal();
    }

}

package Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    WebDriver driver;

    protected SearchBar searchBar;
    protected MobilePag mobilePage;
    protected CartPage cartPage;
    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public SearchBar getSearchBar() {
        if(searchBar == null) {
            searchBar = new SearchBar(driver);
        }
        return searchBar;
    }

    public MobilePag getMobilePage() {
        if(mobilePage == null) {
            mobilePage = new MobilePag(driver);
        }
        return mobilePage;
    }

    public CartPage getCartPage() {
        if(cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }
}

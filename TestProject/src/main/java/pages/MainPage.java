package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    @FindBy(xpath = "//*[@class='typeahead tt-input']")
    @SuppressWarnings("unused")
    private WebElement autocompleteInput;

    public void autocompleteSendKeys(String value) {
        autocompleteInput.sendKeys(value);
    }

    public String getAutocompleteText() {
        return autocompleteInput.getAttribute("value");
    }
}

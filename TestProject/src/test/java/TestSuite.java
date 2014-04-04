import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

import static org.hamcrest.CoreMatchers.equalTo;

public class TestSuite {

    private WebDriver driver;

    @Before
    public void beforeClass() {
        driver = new FirefoxDriver();
    }

    @After
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void testFireFoxSendKeysEnterInteraction() {
        MainPage page = PageFactory.initElements(driver, MainPage.class);

        driver.get("http://vase4kin.github.io/selenium/");

        page.autocompleteSendKeys("Mass");

        new Actions(driver)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();

        Assert.assertThat(
                page.getAutocompleteText(),
                equalTo("Massachusetts")
        );
    }
}

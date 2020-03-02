package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebdriverManager;

public class EnterInGmailWithUserOrTelephonePage extends WebdriverManager {

    @FindBy(xpath = "//*[@id=\"view_container\"]//div[@class='U26fgb O0WRkf oG5Srb HQ8yf C0oVfc FliLIb uRo0Xe t29vte G3hhxb']")
    private WebElement buttonCreateAccount;

    public EnterInGmailWithUserOrTelephonePage() {
        PageFactory.initElements(webdriver, this);
    }

    public CreateAccountPage clickButtonCreateAccount() {
        buttonCreateAccount.click();
        return new CreateAccountPage();
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.WebdriverManager;
import org.openqa.selenium.support.PageFactory;

public class FakeDataPage extends WebdriverManager {

    @FindBy(xpath = "//*[@id=\"details\"]/div[@class='content']/div[@class='info']/div[@class='content']/div[@class='address']/h3")
    private WebElement getNamePerson;

    @FindBy(xpath = "//*[@id=\"details\"]/div[2]/div[2]/div/div[2]/dl[4]/dd")
    private WebElement getPhoneNumber;

    @FindBy(xpath = "//*[@id=\"details\"]/div[2]/div[2]/div/div[2]/dl[10]/dd")
    private WebElement getUsername;

    @FindBy(xpath = "//*[@id=\"details\"]/div[2]/div[2]/div/div[2]/dl[11]/dd")
    private WebElement getPassword;

    @FindBy(xpath = "//*[@id=\"details\"]/div[2]/div[1]/div/div[2]/a/img[@alt='Log in using Google']")
    private WebElement buttonSignin;

    @FindBy(xpath = "//*[@id=\"view_container\"]//div[@class='U26fgb O0WRkf oG5Srb HQ8yf C0oVfc FliLIb uRo0Xe t29vte G3hhxb']")
    private WebElement buttonCreateAccount;


    public FakeDataPage() {
        PageFactory.initElements(webdriver, this);
    }

    public String getNamePerson() {
        return getNamePerson.getAttribute("innerText");
    }

    public String getPhoneNumber() { return getPhoneNumber.getAttribute("innerText"); }

    public String getUsername() { return getUsername.getAttribute("innerText"); }

    public String getPassword() { return getPassword.getAttribute("innerText"); }

    public EnterInGmailWithUserOrTelephonePage clickButtonSignin() {
        buttonSignin.click();
        return new EnterInGmailWithUserOrTelephonePage();
    }

}

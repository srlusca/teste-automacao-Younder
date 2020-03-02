package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Evidencias;
import utils.WebdriverManager;

public class CreateAccountPage extends WebdriverManager {

    @FindBy(id = "firstName")
    private WebElement inputName;

    @FindBy(id = "lastName")
    private WebElement inputSurname;

    @FindBy(id = "username")
    private WebElement inputUsername;

    @FindBy(xpath = "//*[@id=\"passwd\"]//input[@name='Passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id=\"confirm-passwd\"]//input[@name='ConfirmPasswd']")
    private WebElement inputConfirmPassword;

    @FindBy(id = "accountDetailsNext")
    private WebElement buttonNext;

    @FindBy(xpath = "//*[@id=\"usernameList\"]//button[1]")
    private WebElement selectRecommendedUser;

    @FindBy(xpath = "//*[@id=\"view_container\"]/form//div[@class='GQ8Pzc']")
    private WebElement messageExistingUser;

    @FindBy(id = "phoneNumberId")
    private WebElement inputPhoneNumber;

    @FindBy(id = "gradsIdvPhoneNext")
    private WebElement buttonNextTwo;

    @FindBy(xpath = "//*[@id=\"view_container\"]/form//div[@class='LXRPh']/div[@jsname='B34EJ']")
    private WebElement getMessageErrorTelephone;

    @FindBy(xpath = "//*[@id=\"view_container\"]/form//div[@class='GQ8Pzc']")
    private WebElement getUsernameError;

    @FindBy(xpath = "//*[@id=\"view_container\"]/form/div[@jsname='paFcre']")
    private WebElement getPageError;

    @FindBy(xpath = "//*[@id=\"countryList\"]//div[@class='MocG8c aCjZuc LMgvRb KKjvXb'][@jsname='wQNmvb']")
    private WebElement selectorCountry;

    public CreateAccountPage() {
        PageFactory.initElements(webdriver, this);
    }

    public void setInputName(String setName) { inputName.sendKeys(setName); }

    public void setInputSurname(String setSurname) {
        inputSurname.sendKeys(setSurname);
    }

    public void setInputUsername(String setUsername) {
        inputUsername.sendKeys(setUsername);
    }

    public void setInputPassword(String setPassword) {
        inputPassword.clear();
        inputPassword.sendKeys(setPassword);
    }

    public void setInputConfirmPassword(String setConfirmPassword) {
        inputConfirmPassword.clear();
        inputConfirmPassword.sendKeys(setConfirmPassword);
    }

    public void clickSelectorCountry () throws InterruptedException {
        Thread.sleep(2000);
        selectorCountry.click();
        Thread.sleep(2000);
    }

    public void selectorCountry (String country) {
        Actions web = new Actions(webdriver);
        WebElement selectCountry = webdriver.findElement(By.xpath("//*[@id=\"countryList\"]/div[2]/div[@data-value='" + country + "']"));
        web.moveToElement(selectCountry).build().perform();
        selectCountry.click();
    }

    public void clickButtonNext () {
        buttonNext.click();
    }

    public void createAccount (String name, String surname, String username, String password, String confirmPassword) {
        setInputName(name);
        setInputSurname(surname);
        setInputUsername(username);
        setInputPassword(password);
        setInputConfirmPassword(confirmPassword);
        clickButtonNext();
    }

    public void messageExistingUser() {
        try {buttonNext.isDisplayed();
            String recommendedUser = selectRecommendedUser.getAttribute("innerText");
            String messageError = messageExistingUser.getAttribute("innerText");
            System.out.println(messageError + "\n" + "Recomendamos e utilizamos o seguinte usuário: \"" + recommendedUser + "\"");
            String screenshot = "src/main/java/resources/USUARIOJAEXISTENTE" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
            selectRecommendedUser.click();
            clickButtonNext();
        }catch (Exception error){}
    }

    public void setInputPhoneNumber(String phoneNumber) {
        inputPhoneNumber.sendKeys(phoneNumber);
    }

    public void clickButtonNextTwo() {
        buttonNextTwo.click();
    }

    public String getMessageError() {
        return getMessageErrorTelephone.getAttribute("innerText");
    }

    public String getPageError() {
        String messagePageError = "";
        try {
            messagePageError = getPageError.getAttribute("innerText");
        } catch (Exception error) {
        }
        return messagePageError;
    }
}

package tests;

import cucumber.api.java.After;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CreateAccountPage;
import pages.EnterInGmailWithUserOrTelephonePage;
import pages.FakeDataPage;
import utils.WebdriverManager;
import utils.Evidencias;


public class CreateAccountTest extends WebdriverManager {

    static WebdriverManager webdriver = new WebdriverManager();
    FakeDataPage fakeDataPage;
    EnterInGmailWithUserOrTelephonePage enterInGmailWithUserOrTelephonePage;
    CreateAccountPage createAccountPage;

    String firstName = "";
    String lastName = "";
    String username = "";
    String password = "";

    @Dado("^que eu acessei a pagina 'fakenamegenerator.com'$")
    public void openURL() {
        webdriver.openChromeURL();
    }

    @E("^armazeno as informacoes necessarias do usuario para cadastrar-lo no gmail$")
    public void getInfos() {
        fakeDataPage = new FakeDataPage();
// Armazenando dados do usuário.
        String namePerson = fakeDataPage.getNamePerson();
        String[] nameSplited = namePerson.split(" ");
        firstName = nameSplited[0];
        lastName = nameSplited[2];
        username = fakeDataPage.getUsername();
        password = fakeDataPage.getPassword();
    }

    @Quando("^sigo ate a pagina de 'Criar sua Conta do Google' e insiro as informacoes armazenadas$")
    public void insertInfos() throws InterruptedException {
        fakeDataPage = new FakeDataPage();
        enterInGmailWithUserOrTelephonePage = new EnterInGmailWithUserOrTelephonePage();
        createAccountPage = new CreateAccountPage();
// Inserindo informações na página para criar uma conta.
        fakeDataPage.clickButtonSignin();
        enterInGmailWithUserOrTelephonePage.clickButtonCreateAccount();
        Thread.sleep(2000);
        createAccountPage.createAccount(firstName, lastName, username, password, password);
        Thread.sleep(2000);
        createAccountPage.messageExistingUser();
    }

    @Entao("^seleciono o pais de 'Brasil' e insiro o telefone invalido$")
    public void insertTelephoneInvalidBrazil() throws InterruptedException{
        createAccountPage = new CreateAccountPage();
        String verifyPage = createAccountPage.getPageError();
//Verificar se a página está disponível
        if (verifyPage.equals("Não é possível criar uma Conta do Google\n\nNão é possível criar uma Conta do Google no momento. Tente novamente mais tarde.")) {
            System.out.println("PÁGINA INDISPONÍVEL");
            String screenshot = "src/main/java/resources/PAGINAINDISPONIVEL" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
        } else {
            createAccountPage.clickSelectorCountry();
            createAccountPage.selectorCountry("br");
            createAccountPage.setInputPhoneNumber("48209479");
            createAccountPage.clickButtonNextTwo();
            Thread.sleep(1500);
            Assert.assertEquals("Este formato de número de telefone não é válido. Verifique o país e o número.", createAccountPage.getMessageError());
            String screenshot = "src/main/java/resources/ERRORBRASIL" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
        }
    }

    @Entao("^seleciono o pais de 'Canada' e insiro telefone invalido$")
    public void insertTelephoneInvalidCanada() throws InterruptedException{
        createAccountPage = new CreateAccountPage();
        String verifyPage = createAccountPage.getPageError();
//Verificar se a página está disponível
        if (verifyPage.equals("Não é possível criar uma Conta do Google\n\nNão é possível criar uma Conta do Google no momento. Tente novamente mais tarde.")) {
            System.out.println("PÁGINA INDISPONÍVEL");
            String screenshot = "src/main/java/resources/PAGINAINDISPONIVEL" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
        } else {
            createAccountPage.clickSelectorCountry();
            createAccountPage.selectorCountry("ca");
            createAccountPage.setInputPhoneNumber("");
            createAccountPage.clickButtonNextTwo();
            Thread.sleep(1500);
            Assert.assertEquals("Digite um número de telefone", createAccountPage.getMessageError());
            String screenshot = "src/main/java/resources/ERRORCANADA" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
        }
    }

    @Entao("^seleciono o pais de 'Uruguay' e insiro telefone invalido$")
    public void insertTelephoneInvalidUruguay() throws InterruptedException{
        createAccountPage = new CreateAccountPage();
        String verifyPage = createAccountPage.getPageError();
//Verificar se a página está disponível
        if (verifyPage.equals("Não é possível criar uma Conta do Google\n\nNão é possível criar uma Conta do Google no momento. Tente novamente mais tarde.")) {
            System.out.println("PÁGINA INDISPONÍVEL");
            String screenshot = "src/main/java/resources/PAGINAINDISPONIVEL" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
        } else {
            createAccountPage.clickSelectorCountry();
            createAccountPage.selectorCountry("uy");
            createAccountPage.setInputPhoneNumber("27116054");
            createAccountPage.clickButtonNextTwo();
            Thread.sleep(1500);
            Assert.assertEquals("Ocorreu um problema ao confirmar seu número de telefone.", createAccountPage.getMessageError());
            String screenshot = "src/main/java/resources/ERRORURUGUAY" + Evidencias.dataHoraParaArquivo() + ".png";
            Evidencias.evidencies(WebdriverManager.webdriver, screenshot);
        }
    }

    //@After
    //public void closeChrome() { closeWebdriver(); }
}
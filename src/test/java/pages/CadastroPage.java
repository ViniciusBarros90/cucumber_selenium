package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CadastroPage {

    static WebDriver driver;
    static String REGISTRAR = "//button[contains(text(),'Registrar')]";
    static String EMAIL =         "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[2]/input[1]";
    static String NOME =          "//input[@name='name']";
    static String SENHA =         "//body/div[@id='__next']/div[1]/div[2]/div[1]/div[2]/form[1]/div[4]/div[1]/input[1]";
    static String CONFIRM_SENHA = "//input[@name='passwordConfirmation']";
    static String CRIAR_SALDO =   "//label[@id='toggleAddBalance']";
    static String CADASTRAR =     "//button[contains(text(),'Cadastrar')]";
    static String FECHAR =        "//*[@id=\"btnCloseModal\"]";

    public CadastroPage(WebDriver driverParametro){ //Método construtor, onde consigo fazer todas as ações utilizando o Webdriver
        this.driver = driverParametro;
    }

    public static void clicarRegistrar(){
        driver.findElement(By.xpath(REGISTRAR)).click();

    }
    public static void PreencherEmail(String email) {
        driver.findElement(By.xpath(EMAIL)).sendKeys(email);
    }

    public static void PreencherNome(String nome) {
        driver.findElement(By.xpath(NOME)).sendKeys(nome);
    }

    public static void PreencherSenha(String senha) {
        driver.findElement(By.xpath(SENHA)).sendKeys(senha);
    }

    public static void PreencherConfirmacaoSenha(String ConfirmacaoSenha) {
        driver.findElement(By.xpath(CONFIRM_SENHA)).sendKeys(ConfirmacaoSenha);
    }

    public static void ClicarEmCriarComSaldo() {
        driver.findElement(By.xpath(CRIAR_SALDO)).click();
    }

    public static void ClicarCadastrar() {
        driver.findElement(By.xpath(CADASTRAR)).click();
    }

       public static void clicarFechar() {
           WebElement btnFechar = new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath(FECHAR)));
       btnFechar.click();
}



}
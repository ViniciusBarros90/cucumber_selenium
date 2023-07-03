package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CadastroPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LoginStep {
    WebDriver driver;
    CadastroPage cadastroPage;
    LoginPage loginPage;

    @Before
    public void before (){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        cadastroPage = new CadastroPage(driver);
        loginPage = new LoginPage(driver);
    }

        @After
        public void after(){
            driver.quit();
        }



    @Dado("que esteja na pagina inicial: {string}")
    public void queEstejaNaPaginaInicial(String url) {
        driver.get(url);
    }

    @Quando("preencher email: {string} e senha: {string}")
    public void preencherEmailESenha(String email, String senha) {
        loginPage.preencherEmail(email);
        loginPage.preencherSenha(senha);
    }

    @E("clicar em fazer login")
    public void clicarEmFazerLogin() throws InterruptedException {
                loginPage.clicarAcessar();
       }

    @Então("valido que a pagina de boas vindas foi carregada")
    public void validoQueAPaginaDeBoasVindasFoiCarregada()  {
       String url = "http://localhost:3000/home";
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(url));
       Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Dado("possuo cadastro")
    public void possuoCadastro() throws InterruptedException {
        CadastroPage.clicarRegistrar();  // Fazendo as chamadas da classe HomePage
        CadastroPage.PreencherEmail("teste@teste.com.br");
        CadastroPage.PreencherNome("QA Academy");
        CadastroPage.PreencherSenha("teste");
        CadastroPage.PreencherConfirmacaoSenha("teste");
        CadastroPage.ClicarEmCriarComSaldo();
        CadastroPage.ClicarCadastrar();
        CadastroPage.clicarFechar();
    }

    @Dado("preencho o cadastro com os dados")
    public void possuoCadastroDataTable(List<Map<String, String>> dataTable)  {
        String email = dataTable.get(1).get("Email");
        String nome = dataTable.get(1).get("Nome");
        String senha = dataTable.get(1).get("Senha");
        String confirmacao = dataTable.get(1).get("Confirmacao");

        CadastroPage.clicarRegistrar();
        CadastroPage.PreencherEmail(email);
        CadastroPage.PreencherNome(nome);
        CadastroPage.PreencherSenha(senha);
        CadastroPage.PreencherConfirmacaoSenha(confirmacao);
        CadastroPage.ClicarEmCriarComSaldo();
        CadastroPage.ClicarCadastrar();
        CadastroPage.clicarFechar();
    }
}

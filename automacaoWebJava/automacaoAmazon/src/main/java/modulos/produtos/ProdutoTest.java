package modulos.produtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.InicialPage;

import java.time.Duration;


@DisplayName("Testes web do modulo adição de produto ao carrinho")
public class ProdutoTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        //Abrir navegador
        System.setProperty("webdriver.chrome.drive","C:\\drivers\\chromedriver");
        this.navegador = new ChromeDriver();
        this.navegador.manage().window().maximize();
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.navegador.get("https://www.amazon.com.br");
    }

    @Test
    @DisplayName("Adicionar varios produtos ao carrinho")
    public void adicionarVariosProdutosAoCarrinho(){
    new InicialPage(navegador)
            .irParaTelaDeLogin()
            .informarUsuario("cursosiuri1@gmail.com")
            .avançarLogin()
            .informarSenha("Iuri@1321")
            .avançarSenha()
            .acessarProdutosMaisVendidos()
            .acessarSecaoGamesEConsoles()
            .adicionarPrimeiroItem()
            .retornarAosProdutosMaisVendidos()
            .retornarSecaoGamesEConsoles()
            .adicionarSegundoItem();



}
}

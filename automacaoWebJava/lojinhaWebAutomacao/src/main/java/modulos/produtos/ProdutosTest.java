package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes web do modulo de produtos")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // Abrir o navegador
        System.setProperty("webdriver.chrome.drive", "C:\\drivers\\chromedriver");
        this.navegador = new ChromeDriver();

        //Vou maximizar a tela
        this.navegador.manage().window().maximize();

        //Definir tempo de espera padrão de 5s
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para a pagina da lojinha web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

@Test
@DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNãoEPermitidoRegistrarProdutoComValorIgualZero() {

   String mensagemApresentada = new LoginPage(navegador)
           .informarOUsuario("admin")
                   .informarSenha("admin")
                           .submeterFormularioDeLogin()
                                   .acessarFormularioAdicaoNovoProduto()
                                           .informarNomeDoProduto("Probook 440")
                                                   .informarValorDoProduto("000")
                                                           .informarCoresDoProduto("preto, prata")
                                                                   .submeterFormularioDeAdicaoComErro()
           .capturarMensagemApresentada();

   //Validação
    Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


}

@Test
@DisplayName("Não é permitido cadastro de produto acima de R$7000.00")
public void testNaoEPermitidoCadastroDeProdutoComValorAcimaDeSeteMil(){
    String mensagemApresentada = new LoginPage(navegador)
            .informarOUsuario("admin")
            .informarSenha("admin")
            .submeterFormularioDeLogin()
            .acessarFormularioAdicaoNovoProduto()
            .informarNomeDoProduto("Probook 440")
            .informarValorDoProduto("700001")
            .informarCoresDoProduto("preto, prata")
            .submeterFormularioDeAdicaoComErro()
            .capturarMensagemApresentada();

    //Validação
    Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
}


@Test
@DisplayName("Posso adicionar produtos que estejam no limete de 0,01")
public void testPossoAdicionarProdutosComValorDeUmcentavo(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("MacBook Pro")
                .informarValorDoProduto("001")
                .informarCoresDoProduto("preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

    //Validação
    Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);


}

@Test
@DisplayName("Posso adicionar produtos que estejam no limete de 7000.00")
public void testPossoAdicionarProdutosComValorDeSeteMilReais(){
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarSenha("admin")
                .submeterFormularioDeLogin()
                .acessarFormularioAdicaoNovoProduto()
                .informarNomeDoProduto("Dell")
                .informarValorDoProduto("700000")
                .informarCoresDoProduto("preto")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        //Validação
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);


    }


@AfterEach
    public void afterEach(){
    //Fechar navegador
    navegador.quit();
}

}

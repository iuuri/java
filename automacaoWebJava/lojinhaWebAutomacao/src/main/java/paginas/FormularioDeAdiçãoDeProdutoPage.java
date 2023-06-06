package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdiçãoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdiçãoDeProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public FormularioDeAdiçãoDeProdutoPage informarNomeDoProduto(String produtoNome){
        navegador.findElement(By.id("produtonome")).sendKeys(produtoNome);
        return this;
    }

    public FormularioDeAdiçãoDeProdutoPage informarValorDoProduto(String valorProduto){
        navegador.findElement(By.name("produtovalor")).sendKeys(valorProduto);
        return this;
    }

    public FormularioDeAdiçãoDeProdutoPage informarCoresDoProduto(String corProduto){
        navegador.findElement(By.id("produtocores")).sendKeys(corProduto);
        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro(){
        navegador.findElement(By.cssSelector("button[type=submit]")).click();
        return new ListaDeProdutosPage(navegador);
    }

    public FormularioDeEdicaoComSucessoPage submeterFormularioDeAdicaoComSucesso(){
        navegador.findElement(By.cssSelector("button[type=submit]")).click();
        return new FormularioDeEdicaoComSucessoPage (navegador);
    }


}

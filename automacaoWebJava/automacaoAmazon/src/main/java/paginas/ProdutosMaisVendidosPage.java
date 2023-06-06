package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutosMaisVendidosPage {
    private WebDriver navegador;

    public ProdutosMaisVendidosPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public ProdutosMaisVendidosPage acessarProdutosMaisVendidos(){
        navegador.findElement(By.linkText("Mais Vendidos")).click();

        return this;
    }

    public GamesEConsolesPage acessarSecaoGamesEConsoles(){
        navegador.findElement(By.linkText("Games e Consoles")).click();

        return new GamesEConsolesPage(navegador);
    }

    public GamesEConsolesPage retornarSecaoGamesEConsoles(){
        navegador.findElement(By.linkText("Games e Consoles")).click();

        return new GamesEConsolesPage(navegador);
    }



}

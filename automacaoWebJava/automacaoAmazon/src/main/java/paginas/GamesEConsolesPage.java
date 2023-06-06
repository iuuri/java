package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamesEConsolesPage {
    private WebDriver navegador;

    public GamesEConsolesPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public GamesEConsolesPage adicionarPrimeiroItem (){
        navegador.findElement(By.id("B07Y2G7VX5")).click();
        navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[6]/div[3]/div[1]/div[3]/div/div[1]/div/div/div/form/div/div/div/div/div[3]/div/div[13]/div[1]/span/span/span/input")).click();
        navegador.findElement(By.id("attachSiAddCoverage")).click();
               return this;
    }

    public ProdutosMaisVendidosPage retornarAosProdutosMaisVendidos(){
        navegador.findElement(By.linkText("Mais Vendidos")).click();

        return new ProdutosMaisVendidosPage(navegador);
    }

    public GamesEConsolesPage adicionarSegundoItem (){
        navegador.findElement(By.id("B07FN1MZBH")).click();
        navegador.findElement(By.xpath("/html/body/div[2]/div[2]/div[5]/div[3]/div[1]/div[2]/div/div/div/div[1]/div/div/div/form/div/div/div/div/div[3]/div/div[13]/div[1]/span/span/span/input")).click();
        navegador.findElement(By.id("sc-buy-box-ptc-button")).click();
        return this;
    }

}

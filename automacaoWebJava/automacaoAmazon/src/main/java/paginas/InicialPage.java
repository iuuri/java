package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicialPage {
    private WebDriver navegador;

    public InicialPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage irParaTelaDeLogin (){
        navegador.findElement(By.id("nav-link-accountList")).click();

        return new LoginPage(navegador);
    }

}

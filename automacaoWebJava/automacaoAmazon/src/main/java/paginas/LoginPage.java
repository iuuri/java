package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver navegador;

    public LoginPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public LoginPage informarUsuario(String usuario){
        navegador.findElement(By.id("ap_email")).sendKeys(usuario);

        return this;
    }

    public LoginPage avançarLogin(){
        navegador.findElement(By.id("continue")).click();

        return this;
    }

    public LoginPage informarSenha(String senha){
        navegador.findElement(By.id("ap_password")).sendKeys(senha);

        return this;
    }

    public ProdutosMaisVendidosPage avançarSenha(){
        navegador.findElement(By.id("signInSubmit")).click();

        return new ProdutosMaisVendidosPage(navegador);
    }



}

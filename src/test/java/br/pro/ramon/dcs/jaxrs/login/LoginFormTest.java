package br.pro.ramon.dcs.jaxrs.login;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class LoginFormTest {

    @Test
    public void testLoginAutorizado() throws IOException {
        String login = "admin";
        String senha = "r**t";

        String saida = usaFormQueFazChamadaAjax(login, senha);

        assertThat(saida, is("Autorizado"));
    }

    @Test
    public void testLoginErrado() throws IOException {
        String login = "usuario";
        String senha = "r**t";

        String saida = usaFormQueFazChamadaAjax(login, senha);

        assertThat(saida, is("Não Autorizado"));
    }

    @Test
    public void testSenhaErrada() throws IOException {
        String login = "admin";
        String senha = "123456";

        String saida = usaFormQueFazChamadaAjax(login, senha);

        assertThat(saida, is("Não Autorizado"));
    }

    @Test
    public void testLoginESenhaErrados() throws IOException {
        String login = "usuario";
        String senha = "123456";

        String saida = usaFormQueFazChamadaAjax(login, senha);

        assertThat(saida, is("Não Autorizado"));
    }

    @Test
    public void testLoginBranco() throws IOException {
        String login = "";
        String senha = "r**t";

        String saida = usaFormQueFazChamadaAjax(login, senha);

        assertThat(saida, is("Entre com o login e a senha!"));
    }

    private String usaFormQueFazChamadaAjax(String login, String senha) {
        JBrowserDriver driver = new JBrowserDriver();
        driver.get("http://localhost:8084/dcs-jaxrs-login");

        WebElement loginInput = driver.findElementById("login");
        loginInput.sendKeys(login);

        WebElement senhaInput = driver.findElementById("senha");
        senhaInput.sendKeys(senha);

        WebElement verificarButton = driver.findElementById("verificar");
        verificarButton.click();

        WebElement autorizacaoInput = driver.findElementById("autorizacao");
        String saida = autorizacaoInput.getAttribute("value");

        return saida;
    }

}

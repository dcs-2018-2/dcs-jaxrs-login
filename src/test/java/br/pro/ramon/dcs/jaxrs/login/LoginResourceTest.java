package br.pro.ramon.dcs.jaxrs.login;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginResourceTest {

    @Test
    public void testLoginAutorizado() throws IOException {
        String login = "admin";
        String senha = "r**t";

        Resposta resposta = acessaWebService(login, senha);

        assertThat(resposta.saida, is("Autorizado"));
        assertThat(resposta.statusCode, is(200));
    }

    @Test
    public void testLoginErrado() throws IOException {
        String login = "usuario";
        String senha = "r**t";

        Resposta resposta = acessaWebService(login, senha);

        assertThat(resposta.saida, is("Não Autorizado"));
        assertThat(resposta.statusCode, is(401));
    }

    @Test
    public void testSenhaErrada() throws IOException {
        String login = "admin";
        String senha = "123456";

        Resposta resposta = acessaWebService(login, senha);

        assertThat(resposta.saida, is("Não Autorizado"));
        assertThat(resposta.statusCode, is(401));
    }

    @Test
    public void testLoginESenhaErrados() throws IOException {
        String login = "usuario";
        String senha = "123456";

        Resposta resposta = acessaWebService(login, senha);

        assertThat(resposta.saida, is("Não Autorizado"));
        assertThat(resposta.statusCode, is(401));
    }

    private Resposta acessaWebService(String login, String senha) throws IOException {
        Response response = Jsoup.connect("http://localhost:8084/dcs-jaxrs-login/webresources/login/" + login)
                .data("senha", senha)
                .method(Method.POST)
                .ignoreHttpErrors(true)
                .execute();

        String saida = response.body();
        int statusCode = response.statusCode();

        return new Resposta(saida, statusCode);
    }

}

class Resposta {

    public String saida;
    public int statusCode;

    public Resposta(String saida, int statusCode) {
        this.saida = saida;
        this.statusCode = statusCode;
    }

}

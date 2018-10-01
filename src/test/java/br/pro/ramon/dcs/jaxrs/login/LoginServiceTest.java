package br.pro.ramon.dcs.jaxrs.login;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void testLoginAutorizado() throws IOException {
        String login = usuarioDigitou("admin");
        String senha = usuarioDigitou("r**t");

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(true));
    }

    @Test
    public void testLoginErrado() throws IOException {
        String login = usuarioDigitou("usuario");
        String senha = usuarioDigitou("r**t");

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(false));
    }

    @Test
    public void testSenhaErrada() throws IOException {
        String login = usuarioDigitou("admin");
        String senha = usuarioDigitou("123456");

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(false));
    }

    @Test
    public void testLoginESenhaErrados() throws IOException {
        String login = usuarioDigitou("usuario");
        String senha = usuarioDigitou("123456");

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(false));
    }

    private String usuarioDigitou(String texto) {
        StringBuilder entrada = new StringBuilder();
        entrada.append(texto);
        return entrada.toString();
    }

}

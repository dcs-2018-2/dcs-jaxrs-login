package br.pro.ramon.dcs.jaxrs.login;

public class LoginService {

    public boolean isAutorizado(String login, String senha) {
        return login.equals("admin") && senha.equals("r**t");
    }

}

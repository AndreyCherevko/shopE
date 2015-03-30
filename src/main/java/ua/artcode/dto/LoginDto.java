package ua.artcode.dto;

/**
 * Created by andrey on 23.03.15.
 */
public class LoginDto {
    private String login;
    private String pass;

    public LoginDto(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public LoginDto() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}

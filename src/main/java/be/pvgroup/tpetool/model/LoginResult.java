package be.pvgroup.tpetool.model;

public class LoginResult {
    private String token;

    public LoginResult(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

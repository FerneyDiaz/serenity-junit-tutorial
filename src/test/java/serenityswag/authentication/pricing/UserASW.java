package serenityswag.authentication.pricing;

public enum UserASW {
    COMERCIAL("fediazpu@poligran.edu.co","1015465949");

    private final String username;
    private final String password;

    UserASW(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

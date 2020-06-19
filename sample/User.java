public class User {
    private String name;
    private String lastname;
    private String passvord;
    private String login;
    private String strana;
    private String email;


    public User(String name, String lastname, String passvord, String login, String strana, String email) {
        this.name = name;
        this.lastname = lastname;
        this.passvord = passvord;
        this.login = login;
        this.strana = strana;
        this.email = email;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassvord() {
        return passvord;
    }

    public void setPassvord(String passvord) {
        this.passvord = passvord;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStrana() {
        return strana;
    }

    public void setStrana(String strana) {
        this.strana = strana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

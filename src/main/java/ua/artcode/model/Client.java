package ua.artcode.model;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="clients_id")
    private int id;
    @Column(name="login",length=20)
    private String login;
    @Column(name="pass",length = 12)
    private String pass;
    @Column(name="email",length = 15)
    private String email;
    @Column(name="phone",length = 15)
    private String phone;



    public Client() {
    }

    public Client(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public Client(String login, String pass, String email, String phone) {
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Client{" +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}


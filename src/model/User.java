package model;

public class User {
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;

    public User(String name, String cpf, String email, String phoneNumber) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}

package com.yghali.app.Model;

public class Users {
    private int ID;
    private String Nom, Prenom, CIN, Login, Password, Role, Phone, Email;
    private static int ID_ = 0;

    public Users(String nom, String prenom, String CIN, String login, String password, String role, String phone, String email) {
        this.ID = ++ID_;
        Nom = nom;
        Prenom = prenom;
        this.CIN = CIN;
        Login = login;
        Password = password;
        Role = role;
        Phone = phone;
        Email = email;
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    

}

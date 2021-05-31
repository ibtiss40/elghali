package com.yghali.app;

import java.util.ArrayList;

public class blocnote {
    public blocnote(String nom, String contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public blocnote(int id, String nom, String contenu) {
        this.id = id;
        this.nom = nom;
        this.contenu = contenu;
    }

    public int id;
    public String nom;
    public String contenu;
    public static ArrayList<blocnote> listblocnotes = new ArrayList<>();


}

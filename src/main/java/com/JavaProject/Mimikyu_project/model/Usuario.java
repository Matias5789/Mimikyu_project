package com.JavaProject.Mimikyu_project.Model;

//POJO - Plain Old Java Object
public class Usuario {
    
    private int id;
    private String nome, sobren, email;

    public Usuario() {
        
    }

    public Usuario(int id, String nome, String sobren, String email){
        this.id = id;
        this.nome = nome;
        this.sobren = sobren;
        this.email = email;
    }

    public Usuario(String nome, String sobren, String email){
        this.nome = nome;
        this.sobren = sobren;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSobren() {
        return sobren;
    }
    public void setSobren(String sobren) {
        this.sobren = sobren;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
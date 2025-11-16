package org.journey.model;

public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String escolaridade;
    private String areaTrabalho;
    private String senhaHash;

    public Usuario() {}

    public Usuario(Integer id, String nome, String email,
                   String escolaridade, String areaTrabalho,
                   String senhaHash) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.escolaridade = escolaridade;
        this.areaTrabalho = areaTrabalho;
        this.senhaHash = senhaHash;
    }

    // getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getEscolaridade() { return escolaridade; }
    public void setEscolaridade(String escolaridade) { this.escolaridade = escolaridade; }

    public String getAreaTrabalho() { return areaTrabalho; }
    public void setAreaTrabalho(String areaTrabalho) { this.areaTrabalho = areaTrabalho; }

    public String getSenhaHash() { return senhaHash; }
    public void setSenhaHash(String senhaHash) { this.senhaHash = senhaHash; }
}

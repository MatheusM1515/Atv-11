package model;

import java.time.LocalDate;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate data_cadastro;

    private Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public static Usuario cadastrarUsuario(int id, String nome, String email, String senha) {
        return new Usuario(id, nome, email, senha);
    }

    public void atualizarUsuario(int id, String nome, String email, String senha) {
        setId(id);
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public void excluirUsuario(int id, String nome, String email, String senha){

    }

    public void exibirInformacoes(int id, String nome, String email, String senha){
        System.out.println("==================== INFORMAÇÕES DO USUÁRIO ====================");
        System.out.println("Id do Usuário: " + this.id);
        System.out.println("Nome do Usuário: " + this.nome);
        System.out.println("Email do Usuário: " + this.email);
        System.out.println();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

}

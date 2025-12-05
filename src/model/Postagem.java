package model;

import util.ConexaoBD;

import java.time.LocalDate;

public class Postagem {
    private int id;
    private int usuarioId;
    private String conteudo;
    private LocalDate dataPostagem;

    public int curtidas = 0;

    public Postagem(int id, int usuarioId, String conteudo){
        this.id = id;
        this.usuarioId = usuarioId;
        this.conteudo = conteudo;
    }

    public void criarPostagem(String novoConteudo){
        this.conteudo = novoConteudo;
        this.dataPostagem = LocalDate.now();
        System.out.println("Postagem criada com sucesso!");
    }

    public void atualizarPostagem(int id, int usuarioId, String conteudo){
        setId(id);
        setUsuarioId(usuarioId);
        setConteudo(conteudo);
    }

    public void excluirPostagem(int id, int usuarioId, String conteudo){
        this.conteudo = null;
        System.out.println("Postagem excluída!");

    }

    public void exibirInformacoes(int id, int usuarioId, String conteudo){
        System.out.println(" =================== INFORMAÇÕES DA POSTAGEM =================== ");
        System.out.println("Id da postagem: " + this.id);
        System.out.println("Usuário Id da postagem: " + this.usuarioId);
        System.out.println("Conteúdo da postagem: " + this.conteudo);
        System.out.println();
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId){
        this.usuarioId = usuarioId;
    }

    public String getConteudo(){
        return conteudo;
    }

    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
}

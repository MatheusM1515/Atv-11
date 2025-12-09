package model;

import java.time.LocalDate;

public class Curtidas {
    private int id;
    private int postagemId;
    private int usuarioId;
    private LocalDate dataCurtida;

    public Curtidas(int id, int fkIdPostagem, int fkIdUsuario){
        this.id = id;
        this.postagemId = postagemId;
        this.usuarioId = usuarioId;
        this.dataCurtida = LocalDate.now();
    }

    public void curtirPostagem(Postagem postagem){
        postagem.curtidas++;
        this.dataCurtida = LocalDate.now();
        System.out.println("Postagem curtida!");
    }

    public void descurtirCurtida(Postagem postagem){
        if(postagem.curtidas > 0){
            postagem.curtidas--;
            System.out.println("Curtida removida!");
        } else{
            System.out.println("Essa postagem não tem curtidas!");
        }
    }

    public void contarCurtida(Postagem postagem){
        System.out.println("Total de curtidas: " + postagem.curtidas);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getPostagemId(){
        return postagemId;
    }

    public void setPostagemId(int postagemId){
        this.postagemId = postagemId;
    }

    public int getUsuarioId(){
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId){
        this.usuarioId = usuarioId;
    }
}

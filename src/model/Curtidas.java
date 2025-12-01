package model;

import java.time.LocalDate;

public class Curtidas {
    private int id;
    private int postagemId;
    private int usuarioId;
    private LocalDate dataCurtida;

    private Curtidas(int id, int postagemId, int usuarioId){
        this.id = id;
        this.postagemId = postagemId;
        this.usuarioId = usuarioId;
    }

    public void curtirPostagem(Postagem postagem){


    }

    public void descurtirCurtida(Postagem postagem){

    }

    public void contarCurtida(Postagem postagem){

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

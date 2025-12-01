package model;

import java.time.LocalDate;

public class Direct {
    private int id ;
    private int remetendeId;
    private int destinatarioId;
    private String mensagem;
    private LocalDate dataEnvio;

    public Direct(int id, int remetendeId, int destinatarioId, String mensagem){
        this.id = id;
        this.remetendeId = remetendeId;
        this.destinatarioId = destinatarioId;
        this.mensagem = mensagem;
    }

    public void enviarMensagem(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getRemetendeId(){
        return remetendeId;
    }

    public void setRemetendeId(int remetendeId) {
        this.remetendeId = remetendeId;
    }

    public int getDestinatarioId(int destinatarioId){
        return destinatarioId;
    }

    public void setDestinatarioId(int destinatarioId) {
        this.destinatarioId = destinatarioId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}



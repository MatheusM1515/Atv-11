package model;

import java.time.LocalDate;

public class Direct {
    private int id ;
    private int remetendeId;
    private int destinatarioId;
    private String mensagem;
    private LocalDate dataEnvio;

    public Direct(int id, int fkIdremetende, int fkIddestinatario, String mensagem){
        this.id = id;
        this.remetendeId = fkIdremetende;
        this.destinatarioId = fkIddestinatario;
        this.mensagem = mensagem;
    }

    public void enviarMensagem(){
        this.dataEnvio = LocalDate.now();
        System.out.println("Mensagem enviada! " + mensagem);

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

    public int getDestinatarioId(){
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

    public String getDataEnvio() {
        return getDataEnvio();
    }

    public void setDataEnvio(LocalDate dataEnvio){
        this.dataEnvio = dataEnvio;
    }
}



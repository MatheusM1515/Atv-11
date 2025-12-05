package dao;

import model.Direct;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//public class DirectDAO {
    // =================== ENVIAR MENSAGEM
    //public boolean inserir(Direct direct) {

        //String sql = "INSERT INTO directs (remetenteId, destinatarioId, mensagem) VALUES (?, ?, ?)";

        //try (Connection conn = ConexaoBD.getConnection();
             //PreparedStatement stmt = conn.prepareStatement(sql)) {

           // stmt.setInt(1, direct.getRemetendeId());
           // stmt.setInt(2, direct.getDestinatarioId());
           // stmt.setString(3, direct.getMensagem());

            //stmt.executeUpdate();
            //return true;

        //} catch (Exception e) {
            //System.out.println("Erro ao inserir direct: " + e.getMessage());
            //return false;
        //}
    //}

//}




package dao;

import model.Direct;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DirectDAO {
    public static boolean enviar(Direct direct) {
        String sql = "INSERT INTO directs (fkIdremetente, fkIddestinatario, mensagem, dataEnvio) " +
                "VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, direct.getRemetendeId());
            stmt.setInt(2, direct.getDestinatarioId());
            stmt.setString(3, direct.getMensagem());
            stmt.setDate(4, java.sql.Date.valueOf(direct.getDataEnvio()));

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao enviar direct: " + e.getMessage());
            return false;
        }
    }


    public static List<Direct> listarConversas(int u1, int u2) {
        String sql = "SELECT * FROM directs " +
                "WHERE (fkIdremetente = ? AND fkIddestinatario = ?) " +
                "   OR (fkIdremetente = ? AND fkIddestinatario = ?) " +
                "ORDER BY dataEnvio ASC";

        List<Direct> lista = new ArrayList<>();

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, u1);
            stmt.setInt(2, u2);
            stmt.setInt(3, u2);
            stmt.setInt(4, u1);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Direct d = new Direct(
                        rs.getInt("id"),
                        rs.getInt("fkIdremetente"),
                        rs.getInt("fkIddestinatario"),
                        rs.getString("mensagem")
                );

                d.setDataEnvio(rs.getDate("dataEnvio").toLocalDate());
                lista.add(d);
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar direct: " + e.getMessage());
        }

        return lista;
    }


    // =================== ENVIAR MENSAGEM
    public boolean inserir(Direct direct) {

        String sql = "INSERT INTO directs (fkIdremetente, fkIddestinatario, mensagem) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, direct.getRemetendeId());
            stmt.setInt(2, direct.getDestinatarioId());
            stmt.setString(3, direct.getMensagem());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir direct: " + e.getMessage());
            return false;
        }
    }
}






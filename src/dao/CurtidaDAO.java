package dao;

import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CurtidaDAO {

    public static boolean deletar(int idDel) {
        String sql = "DELETE FROM curtidas WHERE id_curtida = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDel);

            int linhas = stmt.executeUpdate();
            return linhas > 0;

        } catch (Exception e) {
            System.out.println("Erro ao deletar curtida: " + e.getMessage());
            return false;
        }
    }


    public static boolean verificarSeJaCurtiu(int fkIdUsuario, int fkIdPostagem) {

        String sql = "SELECT * FROM curtidas WHERE fkIdUsuario = ? AND fkIdPostagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fkIdUsuario);
            stmt.setInt(2, fkIdPostagem);

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (Exception e) {
            System.out.println("Erro ao verificar curtida: " + e.getMessage());
            return false;
        }
    }


    public static boolean curtir(int fkIdUsuario, int fkIdPostagem){

        if (verificarSeJaCurtiu(fkIdUsuario, fkIdPostagem)) {
            System.out.println("Usuário já curtiu esta postagem.");
            return false;
        }

        String sql = "INSERT INTO curtidas (fkIdUsuario, fkIdPostagem, data_curtida) VALUES (?, ?, CURDATE())";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fkIdUsuario);
            stmt.setInt(2, fkIdPostagem);

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao curtir postagem: " + e.getMessage());
            return false;
        }
    }


    public static boolean descurtir(int fkIdUsuario, int fkIdPostagem) {

        String sql = "DELETE FROM curtidas WHERE fkIdUsuario = ? AND fkIdPostagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fkIdUsuario);
            stmt.setInt(2, fkIdPostagem);

            int linhas = stmt.executeUpdate();

            return linhas > 0;

        } catch (Exception e) {
            System.out.println("Erro ao descurtir postagem: " + e.getMessage());
            return false;
        }
    }


    public static int contarCurtidas(int fkIdPostagem) {

        String sql = "SELECT COUNT(*) AS total FROM curtidas WHERE fkIdPostagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fkIdPostagem);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("total");
            }

        } catch (Exception e) {
            System.out.println("Erro ao contar curtidas: " + e.getMessage());
        }

        return 0;
    }
}
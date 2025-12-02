package dao;

import model.Postagem;
import util.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostagemDAO {

    // =============== SALVAR POSTAGEM

    public boolean inserir(Postagem postagem) {

        String sql = "INSERT INTO postagens (id_postagem, fkIdUsuario, conteudo) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, postagem.getId());
            stmt.setInt(2, postagem.getUsuarioId());
            stmt.setString(3, postagem.getConteudo());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir postagem: " + e.getMessage());
            return false;
        }
    }

    // =============== ATUALIZAR POSTAGEM

    public boolean atualizar(Postagem postagem) {

        String sql = "UPDATE postagens SET fkIdUsuario = ?, conteudo = ? WHERE id_postagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, postagem.getUsuarioId());
            stmt.setString(2, postagem.getConteudo());
            stmt.setInt(3, postagem.getId());


            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar postagem: " + e.getMessage());
            return false;
        }
    }

    // =============== DELETAR POSTAGEM

    public boolean deletar(int id) {

        String sql = "DELETE FROM postagens WHERE id_postagem = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar postagem: " + e.getMessage());
            return false;
        }
    }

    // =============== BUSCAR POSTAGEM

    public Postagem buscarPorId(int id) {

        String sql = "SELECT * FROM postagens WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new Postagem(
                            rs.getInt("id_postagem"),
                            rs.getInt("fkIdUsuario"),
                            rs.getString("Conteudo")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar postagem: " + e.getMessage());
        }

        return null;
    }

    // =============== LISTAR POSTAGEM

    public List<Postagem> listar() {

        List<Postagem> lista = new ArrayList<>();
        String sql = "SELECT * FROM postagens";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Postagem(
                        rs.getInt("id_postagem"),
                        rs.getInt("fkIdUsuario"),
                        rs.getString("conteudo")
                ));
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar postagens: " + e.getMessage());
        }

        return lista;
    }






}


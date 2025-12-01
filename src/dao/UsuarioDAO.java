package dao;
import model.Usuario;
import util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public boolean emailExiste(String email) {

        String sql = "SELECT id FROM usuarios WHERE email = ? LIMIT 1";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Usuário encontrado

        } catch (Exception e) {
            System.out.println("Erro ao verificar email: " + e.getMessage());
            return false;
        }
    }

    public boolean cadastrar(Usuario usuario) {

        if (emailExiste(usuario.getEmail())) {
            System.out.println("Erro: E-mail já está cadastrado!");
            return false;
        }

        return inserir(usuario);
    }

    public boolean inserir(Usuario usuarios) {

        String sql = "INSERT INTO usuarios (id_usuario, nome, email, senha) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuarios.getId());
            stmt.setString(2, usuarios.getNome());
            stmt.setString(3, usuarios.getEmail());
            stmt.setString(4, usuarios.getSenha());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao inserir usuario: " + e.getMessage());
            return false;
        }
    }
}

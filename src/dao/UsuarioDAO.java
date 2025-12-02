package dao;
import model.Usuario;
import util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // ===================== VERIFICAR EMAIL

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

    // ===================== CADASTRAR USUARIO

    public boolean cadastrar(Usuario usuario) {

        if (emailExiste(usuario.getEmail())) {
            System.out.println("Erro: E-mail já está cadastrado!");
            return false;
        }

        return inserir(usuario);
    }


    // ===================== INSERIR USUARIO NA DB
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

    // ===================== LISTAR

    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                lista.add(new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                ));
            }

        } catch (Exception e) {
            System.out.println("Erro ao listar usuarios: " + e.getMessage());
        }

        return lista;
    }

    public Usuario buscarPorId(int id) {

        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return new Usuario(
                            rs.getInt("id_usuario"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        }

        return null;
    }

    // ===================== ATUALIZAR USUARIO

    public boolean atualizar(Usuario usuario) {

        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id_usuario = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setInt(4, usuario.getId());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            return false;
        }
    }
    // ===================== DELETAR USUARIO

    public boolean deletar(int id) {

        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
            return false;
        }
    }

    // ===================== LOGAR USUARIO

    public boolean login(String email, String senha) {

        String sql = "SELECT id FROM usuarios WHERE email = ? AND senha = ? LIMIT 1";

        try (Connection conn = ConexaoBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            return rs.next(); // encontrou o usuário

        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
            return false;
        }
    }
}






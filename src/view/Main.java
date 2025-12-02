package view;

import dao.UsuarioDAO;
import java.util.Scanner;
import model.Usuario;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================ MINITOK ================");

        UsuarioDAO userDAO = new UsuarioDAO();
        boolean repetir = true;
        while (repetir) {
            System.out.println();
            System.out.println("1) Criar conta");
            System.out.println("2) Listar Usuarios");
            System.out.println("3) Atualizar Usuario");
            System.out.println("4) Ecluir Usuario");
            System.out.println("5) Criar postagem");
            System.out.println("6) Listar postagens de usuario");
            System.out.println("7) Excluir postagem");
            System.out.println("8) Curtir postagem");
            System.out.println("9) Descurtir postagem");
            System.out.println("10) Mostrar quantidade de curtidas");
            System.out.println("11) Enviar direct");
            System.out.println("12) Listar direct entre dois usuario");
            System.out.println("13) Sair");
            System.out.print("Escolha uma opção: ");

            int opcao= sc.nextInt();

            switch (opcao) {
                case 1:
                    Usuario usuario= Usuario.cadastrarUsuario();
                    userDAO.cadastrar(usuario);
                    break;
                case 2:
                    // pass
                    break;
                case 3:
                    // pass
                    break;
                case 4:
                    // pass
                    break;
                case 5:
                    // pass
                    break;
                case 6:
                    // pass
                    break;
                case 7:
                    // pass
                    break;
                case 8:
                    // pass
                    break;
                case 9:
                    // pass
                    break;
                case 10:
                    // pass
                    break;
                case 11:
                    // pass
                    break;
                case 12:
                    // pass
                    break;
                case 13:
                    repetir = false;
                    break;
                default:
                    System.out.println(
                        "Opção inválida. Digite um número entre 1 e 13."
                    );
                    break;
            }
        }
        System.out.println("Encerrando MINITOK. Até logo!");
    }
}

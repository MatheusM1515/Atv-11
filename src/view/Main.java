package view;

import dao.DirectDAO;
import dao.PostagemDAO;
import dao.UsuarioDAO;
import java.util.Scanner;

import model.Direct;
import model.Postagem;
import model.Usuario;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("================ MINITOK ================");

        UsuarioDAO userDAO = new UsuarioDAO();

        mainLoop: while (true) {
            System.out.println();
            System.out.println("1) Criar conta");
            System.out.println("2) Listar Usuarios");
            System.out.println("3) Atualizar Usuario");
            System.out.println("4) Excluir Usuario");
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

            if (!sc.hasNextLine()) {
                System.out.println("\nEntrada encerrada. Saindo...");
                break;
            }

            String line = sc.nextLine();
            if (line == null) {
                System.out.println("\nEntrada encerrada. Saindo...");
                break;
            }

            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }

            int op;
            try {
                op = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println(
                    "Opção inválida. Digite um número entre 1 e 13."
                );
                continue;
            }

            switch (op) {
                case 1:
                    Usuario usuario = Usuario.cadastrarUsuario();
                    if(userDAO.cadastrar(usuario))
                        System.out.println("Usuario cadastrado com suscesso!");
                    else
                        System.out.println("Falha no cadastro");
                    break;
                case 2:
                    System.out.println("\n--- LISTA DE USUARIOS ---");
                    for (Usuario a : userDAO.listar()) {
                        System.out.println(a.getId() + " | " + a.getNome() + " | " + a.getEmail());
                    }
                    break;
                case 3:
                    System.out.print("ID: ");
                    int idUp = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String nomeUp = sc.nextLine();

                    System.out.print("Novo email: ");
                    String emailUp = sc.nextLine();

                    System.out.print("Nova senha: ");
                    String senhaUp = sc.nextLine();

                    Usuario alt = new Usuario(idUp, nomeUp, emailUp, senhaUp);

                    if (userDAO.atualizar(alt))
                        System.out.println("Atualizado!");
                    else
                        System.out.println("Erro ao atualizar.");
                    break;
                case 4:
                   System.out.println("Qual o id do usuário que você deseja deletar? ");
                   int idDel = sc.nextInt();
                   if(userDAO.deletar(idDel))
                       System.out.println("Usuario deletado");
                   else
                       System.out.println("Falha ao deletar o usuario ");
                    break;
                case 5:
                    // TODO: implementar criar postagem

                    break;
                case 6:
                    // TODO: implementar listar postagens de usuario
                    System.out.println(
                        "Funcionalidade 'Listar postagens de usuario' ainda não implementada."
                    );
                    break;
                case 7:
                    // TODO: implementar excluir postagem
                    System.out.println(
                        "Funcionalidade 'Excluir postagem' ainda não implementada."
                    );
                    break;
                case 8:
                    // TODO: implementar curtir postagem
                    System.out.println(
                        "Funcionalidade 'Curtir postagem' ainda não implementada."
                    );
                    break;
                case 9:
                    // TODO: implementar descurtir postagem
                    System.out.println(
                        "Funcionalidade 'Descurtir postagem' ainda não implementada."
                    );
                    break;
                case 10:
                    // TODO: implementar mostrar quantidade de curtidas
                    System.out.println(
                        "Funcionalidade 'Mostrar quantidade de curtidas' ainda não implementada."
                    );
                    break;
                case 11:
                    // TODO: implementar enviar directS

                    break;
                case 12:
                    // TODO: implementar listar direct entre dois usuario
                    System.out.println(
                        "Funcionalidade 'Listar direct entre dois usuario' ainda não implementada."
                    );
                    break;
                case 13:
                    System.out.println("Encerrando MINITOK. Até logo!");
                    break mainLoop;
                default:
                    System.out.println(
                        "Opção inválida. Digite um número entre 1 e 13."
                    );
                    break;
            }
        }
        try {
            sc.close();
        } catch (Exception ignored) {}
    }
}

package view;

//import dao.DirectDAO;
import dao.CurtidaDAO;
import dao.DirectDAO;
import dao.PostagemDAO;
import dao.UsuarioDAO;
import java.util.Scanner;

import model.Direct;
import model.Postagem;
import model.Usuario;

import javax.swing.*;

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
                    System.out.println("\n=== LISTA DE USUARIOS ===");
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
                    // Não está criando as postagem
                    System.out.println("=== CRIAR POSTAGEM ===");

                    System.out.print("ID do usuário que está postando: ");
                    int usuarioIdPost = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Conteúdo da postagem: ");
                    String conteudoPost = sc.nextLine();


                    Postagem novaPostagem = new Postagem(0, usuarioIdPost, conteudoPost);

                    PostagemDAO postagemDAO = new PostagemDAO();

                    if (postagemDAO.inserir(novaPostagem)) {
                        System.out.println("Postagem criada com sucesso!");
                    } else {
                        System.out.println("Falha ao criar postagem.");
                    }
                    break;
                case 6:
                    System.out.println("\n=== LISTA DE POSTAGENS ===");
                    for (Postagem p : PostagemDAO.listar()) {
                        System.out.println(p.getId() + " | " + p.getUsuarioId() + " | " + p.getConteudo());
                    }
                    break;
                case 7:
                    System.out.println("Qual o id da postagem que você deseja deletar? ");
                    int IdDel = sc.nextInt();
                    if(PostagemDAO.deletar(IdDel))
                        System.out.println("Postagem deletado!");
                    else
                        System.out.println("Falha ao deletar postagem. ");
                    break;
                case 8:
                    System.out.println("=== CURTIR POSTAGEM ===");
                    System.out.println("ID do usuário: ");
                    int usuarioCurtidor = sc.nextInt();

                    System.out.println("ID da postagem: ");
                    int postagemCurtir = sc.nextInt();
                    sc.nextLine();

                    if (CurtidaDAO.verificarSeJaCurtiu(usuarioCurtidor, postagemCurtir)){
                        System.out.println("Você já curtiu essa postagem!");
                    } else{
                        if (CurtidaDAO.curtir(usuarioCurtidor, postagemCurtir)){
                            System.out.println("Postagem curtida com sucesso!");
                        } else{
                            System.out.println("Erro ao curtir postagem.");
                        }
                    }
                    break;
                case 9:
                    System.out.println("=== DESCURTIR POSTAGEM ===");
                    System.out.println("ID do usuário: ");
                    int UsuarioDescurtir = sc.nextInt();

                    System.out.println("ID da postagem: ");
                    int postagemDescurtir = sc.nextInt();
                    sc.nextLine();

                    int usuarioDescurtir = 0;
                    if (CurtidaDAO.descurtir(usuarioDescurtir, postagemDescurtir)) {
                        System.out.println("Curtida removida com sucesso!");
                    } else {
                        System.out.println("Você não tinha curtido essa postagem ou ocorreu um erro.");
                    }
                    break;
                case 10:
                    System.out.println("=== TOTAL DE CURTIDAS ===");
                    System.out.println("ID da postagem: ");
                    int postagemContar = sc.nextInt();
                    sc.nextLine();

                    int totalCurtidas = CurtidaDAO.contarCurtidas(postagemContar);
                    System.out.println("A postagem " + postagemContar + " possui " + totalCurtidas + " curtidas.");
                    break;
                case 11:
                    // TODO: implementar enviar directS
                    System.out.println("=== ENVIAR DIRECT ===");

                    System.out.println("ID do remetente: ");
                    int remetente = sc.nextInt();
                    sc.nextLine();

                    System.out.println("ID do destinatário: ");
                    int destinatario = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Mensagem: ");
                    String mensagemDirect = sc.nextLine();

                    Direct direct = new Direct(0, remetente, destinatario, mensagemDirect);
                    direct.enviarMensagem();

                    if(DirectDAO.enviar(direct)){
                        System.out.println("Direct enviado!");
                    } else {
                        System.out.println("Erro ao enviar direct.");
                    }
                    break;
                case 12:
                    // TODO: implementar listar direct entre dois usuario
                    System.out.println("=== LISTA DE DIRECTS ENTRE DOIS USUÁRIOS ===");

                    System.out.println("ID do primeiro usuário: ");
                    int u1 = sc.nextInt();

                    System.out.println("ID do segundo usuário: ");
                    int u2 = sc.nextInt();
                    sc.nextLine();

                    var conversas = DirectDAO.listarConversas(u1, u2);

                    if(conversas.isEmpty()){
                        System.out.println("Nenhuma mensagem entre esses usuários!");
                    }else {
                        for (Direct d: conversas){
                            System.out.println(d.getDataEnvio() + " | " + d.getRemetendeId() + " -> " + d.getDestinatarioId() + " | " + d.getMensagem());
                        }
                    }
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

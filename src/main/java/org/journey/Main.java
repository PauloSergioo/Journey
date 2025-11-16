package org.journey;

import org.journey.controller.UsuarioController;
import org.journey.service.AuthService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioController usuarioController = new UsuarioController();
        AuthService auth = new AuthService();

        int opcao;

        do {
            System.out.println("\n===== MENU JOURNEY =====");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Recuperar senha");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    auth.login(email, senha);
                }
                case 2 -> usuarioController.cadastrarUsuario();
                case 3 -> {
                    System.out.print("Digite seu email: ");
                    String email = sc.nextLine();
                    auth.recuperarSenha(email);
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }
}
package org.journey.controller;

import org.journey.dao.UsuarioDAO;
import org.journey.model.Usuario;
import org.journey.security.HashUtils;

import java.util.Scanner;

public class UsuarioController {

    private final UsuarioDAO dao = new UsuarioDAO();
    private final Scanner sc = new Scanner(System.in);

    public void cadastrarUsuario() {

        System.out.println("\n=== CADASTRO DE USUÁRIO ===");

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        String escolaridade = escolherEscolaridade();

        System.out.print("Área de trabalho: ");
        String area = sc.nextLine();

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setEmail(email);
        u.setEscolaridade(escolaridade);
        u.setAreaTrabalho(area);
        u.setSenhaHash(HashUtils.hash(senha));

        dao.cadastrar(u);
    }

    private String escolherEscolaridade() {

        System.out.println("\n=== NÍVEIS DE ESCOLARIDADE ===");
        System.out.println("0 - Nenhuma escolaridade / Analfabeto");
        System.out.println("1 - Ensino Fundamental Incompleto");
        System.out.println("2 - Ensino Fundamental Completo");
        System.out.println("3 - Ensino Médio Incompleto");
        System.out.println("4 - Ensino Médio Completo");
        System.out.println("5 - Curso Técnico");
        System.out.println("6 - Graduação (Superior) Incompleta");
        System.out.println("7 - Graduação (Superior) Completa");
        System.out.println("8 - Pós-Graduação (Especialização)");
        System.out.println("9 - Pós-Graduação — Mestrado");
        System.out.println("10 - Pós-Graduação — Doutorado");

        int op;
        while (true) {
            System.out.print("Escolha o nível (0 a 10): ");
            try {
                op = Integer.parseInt(sc.nextLine());
                if (op >= 0 && op <= 10) break;
                System.out.println("Opção inválida!");
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números!");
            }
        }

        return switch (op) {
            case 0 -> "Nenhuma escolaridade / Analfabeto";
            case 1 -> "Ensino Fundamental Incompleto";
            case 2 -> "Ensino Fundamental Completo";
            case 3 -> "Ensino Médio Incompleto";
            case 4 -> "Ensino Médio Completo";
            case 5 -> "Curso Técnico";
            case 6 -> "Graduação (Superior) Incompleta";
            case 7 -> "Graduação (Superior) Completa";
            case 8 -> "Pós-Graduação (Especialização)";
            case 9 -> "Pós-Graduação — Mestrado";
            default -> "Pós-Graduação — Doutorado";
        };
    }
}
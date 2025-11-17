package org.journey;

import org.journey.controller.UsuarioController;
import org.journey.service.AuthService;

import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        UsuarioController usuarioController = new UsuarioController();
        AuthService auth = new AuthService();

        int opcao;

        do {
            clearConsole();
            imprimirHeader("MENU JOURNEY");

            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Recuperar senha");
            System.out.println("4 - Career Helper");
            System.out.println("0 - Sair\n");
            System.out.print("Escolha: ");

            opcao = lerNumero();

            switch (opcao) {
                case 1 -> {
                    clearConsole();
                    imprimirHeader("LOGIN");
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Senha: ");
                    String senha = sc.nextLine();
                    auth.login(email, senha);
                    pausar();
                }
                case 2 -> {
                    clearConsole();
                    usuarioController.cadastrarUsuario();
                    pausar();
                }
                case 3 -> {
                    clearConsole();
                    imprimirHeader("RECUPERAR SENHA");
                    System.out.print("Digite seu email: ");
                    String email = sc.nextLine();
                    auth.recuperarSenha(email);
                    pausar();
                }
                case 4 -> {
                    clearConsole();
                    careerHelperMenu();
                }
                case 0 -> System.out.println("Encerrando...");
                default -> {
                    System.out.println("Opção inválida!");
                    pausar();
                }
            }

        } while (opcao != 0);
    }

    // =============================================================
    // MÉTODOS AUXILIARES
    // =============================================================

    private static void careerHelperMenu() {
        int opcao;

        do {
            clearConsole();
            imprimirHeader("CAREER HELPER");

            System.out.println("1 - Descobrir carreira emergente");
            System.out.println("2 - Ver carreiras que ainda vão surgir");
            System.out.println("3 - Recomendações baseadas no que você quer aprender");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");

            opcao = lerNumero();

            switch (opcao) {
                case 1 -> {
                    clearConsole();
                    imprimirHeader("CARREIRAS EMERGENTES");

                    System.out.println("""
                        🔥 Áreas que estão crescendo muito:
                        
                        • AI Prompt Engineer
                        • Especialista em Automação com IA
                        • Técnico em Manutenção de Robôs Domésticos
                        • Criador de Agentes Autônomos
                        • Treinador de Modelos de IA (Dataset Trainer)
                        """);

                    pausar();
                }
                case 2 -> {
                    clearConsole();
                    imprimirHeader("CARREIRAS DO FUTURO");

                    System.out.println("""
                        🚀 Carreiras que devem surgir em breve:

                        • Curador de Inteligências Artificiais
                        • Psicólogo de IA (ajustar comportamento de agentes)
                        • Auditor Ético de Algoritmos
                        • Engenheiro de Realidade Holográfica
                        • Designer de Personalidades Digitais
                        """);

                    pausar();
                }
                case 3 -> {
                    clearConsole();
                    imprimirHeader("RECOMENDAÇÕES PERSONALIZADAS");

                    System.out.print("Diga o que você quer aprender: ");
                    String tema = sc.nextLine().toLowerCase();

                    clearConsole();
                    imprimirHeader("RECOMENDAÇÃO PARA VOCÊ");

                    System.out.println(gerarRecomendacao(tema));
                    pausar();
                }
                case 0 -> { return; }
                default -> {
                    System.out.println("Opção inválida!");
                    pausar();
                }
            }

        } while (true);
    }

    // Mapeamento simples (mock) para simular "IA"
    private static String gerarRecomendacao(String tema) {

        if (tema.contains("excel")) {
            return """
                    📊 Para aprender Excel você pode evoluir assim:

                    1) Fórmulas básicas → SOMA, MÉDIA, PROC
                    2) Tabelas Dinâmicas
                    3) Dashboard com gráficos
                    4) Macros simples com VBA
                    5) Automatização com Python + Excel

                    Carreira indicada: ANALISTA DE DADOS INICIANTE
                    """;
        }

        if (tema.contains("programar") || tema.contains("coding")) {
            return """
                    👨‍💻 Para começar a programar:

                    1) Lógica e estruturas básicas
                    2) Java ou Python
                    3) Banco de dados
                    4) APIs
                    5) Deploy

                    Carreira indicada: DESENVOLVEDOR JUNIOR
                    """;
        }

        if (tema.contains("ia") || tema.contains("inteligência")) {
            return """
                    🤖 Para entrar na área de IA:

                    1) Fundamentos de Python
                    2) IA generativa (OpenAI, Gemini)
                    3) Prompt engineering
                    4) Criação de agentes autônomos
                    5) Automação de rotinas

                    Carreira indicada: AI AUTOMATION SPECIALIST
                    """;
        }

        return """
                Não reconheci esse tema ainda 🤔  
                Mas um bom começo é:

                • Buscar fundamentos
                • Praticar no dia a dia
                • Escolher uma carreira emergente e evoluir nela
                """;
    }

    // Lê números com segurança
    private static int lerNumero() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void imprimirHeader(String titulo) {
        System.out.println("===== " + titulo + " =====\n");
    }

    private static void pausar() {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }

    /**
     * Função para limpar console (Windows, Linux e Mac).
     */
    private static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception ignored) {}
    }
}
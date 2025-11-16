package org.journey.service;

import org.journey.dao.UsuarioDAO;
import org.journey.model.Usuario;
import org.journey.security.HashUtils;

import java.util.Random;

public class AuthService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    private final Random random = new Random();

    public boolean login(String email, String senha) {
        Usuario user = usuarioDAO.buscarPorEmail(email);

        if (user == null) {
            System.out.println("Email não encontrado.");
            return false;
        }

        String hashDigitado = HashUtils.hash(senha);

        if (hashDigitado.equals(user.getSenhaHash())) {
            System.out.println("Login bem-sucedido! Bem-vindo, " + user.getNome());
            return true;
        }

        System.out.println("Senha incorreta.");
        return false;
    }

    public void recuperarSenha(String email) {
        Usuario user = usuarioDAO.buscarPorEmail(email);

        if (user == null) {
            System.out.println("Nenhum usuário encontrado com esse email.");
            return;
        }

        int codigo = 100000 + random.nextInt(900000);

        System.out.println("\n--- RECUPERAÇÃO DE SENHA ---");
        System.out.println("Email de recuperação enviado para: " + email);
        System.out.println("Código (simulado): " + codigo);
        System.out.println("--------------------------------\n");
    }
}

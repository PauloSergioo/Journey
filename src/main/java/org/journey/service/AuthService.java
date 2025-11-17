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

        // Gera senha nova de 6 dígitos
        int codigo = 100000 + random.nextInt(900000);
        String novaSenha = String.valueOf(codigo);

        // Hash da nova senha
        String novaSenhaHash = HashUtils.hash(novaSenha);

        // Atualiza no banco
        boolean ok = usuarioDAO.atualizarSenha(user.getId(), novaSenhaHash);

        if (ok) {
            System.out.println("\n--- RECUPERAÇÃO DE SENHA ---");
            System.out.println("Uma nova senha foi gerada!");
            System.out.println("Sua nova senha é: " + novaSenha);
            System.out.println("Use-a para fazer login e depois altere se desejar.");
            System.out.println("--------------------------------\n");
        } else {
            System.out.println("Erro ao atualizar a senha.");
        }
    }
}
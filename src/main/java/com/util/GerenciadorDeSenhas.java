package com.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class GerenciadorDeSenhas {

    // Gera o hash da senha
    public static String gerarHashSenha(String senhaPlana) {
        return BCrypt.withDefaults().hashToString(12, senhaPlana.toCharArray());
    }

    // Verifica se a senha fornecida corresponde ao hash armazenado
    public static boolean verificarSenha(String senhaPlana, String hashArmazenado) {
        return BCrypt.verifyer().verify(senhaPlana.toCharArray(), hashArmazenado).verified;
    }

}

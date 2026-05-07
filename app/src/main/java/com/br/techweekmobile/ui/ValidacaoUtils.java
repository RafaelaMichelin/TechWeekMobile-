package com.br.techweekmobile.ui;

import java.util.regex.Pattern;


public class ValidacaoUtils {


    private static final Pattern REGEX_RA = Pattern.compile("^\\d{6,10}$");

    private static final Pattern REGEX_EMAIL = Pattern.compile(
            "^[a-zA-Z0-9._%+\\-]+@[a-zA-Z0-9.\\-]+\\.[a-zA-Z]{2,}$"
    );

    private static final Pattern REGEX_NOME = Pattern.compile(
            "^[a-zA-ZÀ-ÿ\\s]{3,60}$"
    );


    public static boolean validarRA(String ra) {
        if (ra == null || ra.trim().isEmpty()) return false;
        return REGEX_RA.matcher(ra.trim()).matches();
    }


    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        return REGEX_EMAIL.matcher(email.trim()).matches();
    }


    public static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;
        return REGEX_NOME.matcher(nome.trim()).matches();
    }


    public static String mensagemErroRA(String ra) {
        if (ra == null || ra.trim().isEmpty()) return "RA é obrigatório.";
        if (!REGEX_RA.matcher(ra.trim()).matches()) return "RA deve conter entre 6 e 10 dígitos numéricos.";
        return null;
    }


    public static String mensagemErroEmail(String email) {
        if (email == null || email.trim().isEmpty()) return "E-mail é obrigatório.";
        if (!REGEX_EMAIL.matcher(email.trim()).matches()) return "Informe um e-mail válido (ex: nome@dominio.com).";
        return null;
    }

    public static String mensagemErroNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return "Nome é obrigatório.";
        if (!REGEX_NOME.matcher(nome.trim()).matches()) return "Nome deve ter entre 3 e 60 letras.";
        return null;
    }
}


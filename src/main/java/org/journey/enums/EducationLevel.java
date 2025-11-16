package org.journey.enums;


public enum EducationLevel {

    NENHUMA("Nenhuma escolaridade / Analfabeto"),
    FUND_INCOMP("Ensino Fundamental Incompleto"),
    FUND_COMP("Ensino Fundamental Completo"),
    MED_INCOMP("Ensino Médio Incompleto"),
    MED_COMP("Ensino Médio Completo"),
    TECNICO("Curso Técnico"),
    SUP_INCOMP("Graduação (Superior) Incompleta"),
    SUP_COMP("Graduação (Superior) Completa"),
    POS_ESPEC("Pós-Graduação (Especialização)"),
    POS_MEST("Pós-Graduação — Mestrado"),
    POS_DOUT("Pós-Graduação — Doutorado");

    private final String descricao;

    EducationLevel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
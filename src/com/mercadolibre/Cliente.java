package com.mercadolibre;

import java.time.LocalDate;

public class Cliente {

    // Propriedades
    public String nome;
    private LocalDate dataDeNascimento;
    public Sexo sexo;

    // Métodos
    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {

        if (dataDeNascimento.isBefore(LocalDate.of(1920, 12, 31))) {
            throw new IllegalArgumentException("A data de nascimento deve ser superior a 31/12/1920.");
        }

        this.dataDeNascimento = dataDeNascimento;
    }
}

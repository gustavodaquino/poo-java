package com.mercadolibre;

public class Banco {

    // Propriedades
    private short codigo;
    private String nome;

    // Construtor
    public Banco(short codigo, String nome) {

        if (codigo == 0) {
            throw new IllegalArgumentException("O código do banco não pode ser 0.");
        }

        if (nome == null) {
            throw new IllegalArgumentException("O nome do banco não pode ser nulo.");
        }

        this.codigo = codigo;
        this.nome = nome;
    }

    public Banco() {
        // Um construtor sem parâmetros.
        System.out.println("Construtor sem parâmetros invocado.");
    }

    // Métodos
    public short getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
}

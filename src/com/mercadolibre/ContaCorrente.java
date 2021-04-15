package com.mercadolibre;

import java.math.BigDecimal;

public class ContaCorrente {

    // Propriedades
    private Agencia agencia;
    private int numero;
    private Cliente cliente;
    private BigDecimal saldo = BigDecimal.ZERO;
    private boolean bloqueado = false;

    // private Senha senha;

    // Métodos
    public boolean depositar(BigDecimal valor) {

        System.out.printf("Tentativa de depósito realizada na conta: %d.%n", getNumero());

        this.saldo = this.saldo.add(valor);
        return true;
    }

    public boolean sacar(BigDecimal valor) {

        System.out.printf("Tentativa de saque realizada na conta: %d.%n", getNumero());

        if (saldo.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Saque realizado utilizando o limite de crédito disponível.");
        }

        this.saldo = this.saldo.subtract(valor);
        return true;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}

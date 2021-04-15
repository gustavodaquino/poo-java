package com.mercadolibre;

import com.mercadolibre.utils.BigDecimalUtils;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    // Propriedades
    private Banco banco;
    private short codigo;
    private String nome;
    private List<ContaCorrente> contasCorrentes = new ArrayList();

    // Construtor
    public Agencia(Banco banco, short codigo, String nome) {

        if (banco == null) {
            throw new IllegalArgumentException("O banco não pode ser nulo.");
        }

        if (codigo == 0) {
            throw new IllegalArgumentException("O código da agência não pode ser 0.");
        }

        if (nome == null) {
            throw new IllegalArgumentException("O nome da agêndia não pode ser nulo.");
        }

        this.codigo = codigo;
        this.nome = nome;
    }

    // Métodos
    public short getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public List<ContaCorrente> getContasCorrentes() {
        return contasCorrentes;
    }

    public void adicionarContaCorrente(ContaCorrente contasCorrente) {
        this.contasCorrentes.add(contasCorrente);
    }

    public void imprimirRelatorio() {
        System.out.println("---------- Dados da agência ----------");
        System.out.printf("Código: %d%n", getCodigo());
        System.out.printf("Agência: %s%n", getNome());
        System.out.printf("Quantidade de contas ativas: %d%n",
                getContasCorrentes()
                        .stream()
                        .filter(x -> !x.isBloqueado())
                        .count());
        System.out.printf("Quantidade de contas inativas: %d%n",
                getContasCorrentes()
                        .stream()
                        .filter(ContaCorrente::isBloqueado)
                        .count());
        System.out.println("---------- Clientes ----------");
        getContasCorrentes().forEach(contaCorrente -> {
            System.out.printf("Cliente: %s%n", contaCorrente.getCliente().nome);
            System.out.printf("Saldo da conta: %s%n",
                    BigDecimalUtils.currencyFormat(contaCorrente.getSaldo()));
            System.out.printf("Conta bloqueada: %s%n", contaCorrente.isBloqueado());
            System.out.println("------------------------------");
        });
    }
}

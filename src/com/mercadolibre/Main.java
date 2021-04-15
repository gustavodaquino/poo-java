package com.mercadolibre;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        var bancoDeMarte = new Banco((short) 377, "Banco de Marte");
        Agencia agenciaCentro = new Agencia(bancoDeMarte, (short) 1, "Centro");

        var helena = new Cliente();
        helena.nome = "Helena";
        helena.setDataDeNascimento(LocalDate.of(2000, 3, 15));
        helena.sexo = Sexo.Feminino;

        var contaDaHelena = new ContaCorrente();
        contaDaHelena.setCliente(helena);
        contaDaHelena.setAgencia(agenciaCentro);
        contaDaHelena.setNumero(1234);
        contaDaHelena.setBloqueado(false);

        contaDaHelena.sacar(new BigDecimal(500));

        var agata = new Cliente();
        agata.nome = "Ágata";
        agata.setDataDeNascimento(LocalDate.of(1998, 6, 20));
        agata.sexo = Sexo.Feminino;

        var contaDaAgata = new ContaCorrente();
        contaDaAgata.setCliente(agata);
        contaDaAgata.setAgencia(agenciaCentro);
        contaDaAgata.setNumero(1235);
        contaDaAgata.setBloqueado(true);

        agenciaCentro.adicionarContaCorrente(contaDaHelena);
        agenciaCentro.adicionarContaCorrente(contaDaAgata);

        // agenciaCentro.imprimirRelatorio();
    }
}
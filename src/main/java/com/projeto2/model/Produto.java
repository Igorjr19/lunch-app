package com.projeto2.model;

import java.io.Serializable;

/**
 *
 * @author Igor J Rodrigues
 */
public class Produto implements Serializable {
    private int quantidade;
    private String nome;
    private double valor;

    public Produto(int quantidade, String nome, double valor) {
        this.quantidade = quantidade;
        this.nome = nome;
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

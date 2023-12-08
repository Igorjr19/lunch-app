package com.projeto2.model;

import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public boolean  addProduto(int quantidade, String nome, double valor) {
        return produtos.add(new Produto(quantidade, nome, valor));
    }
    
    public boolean possui(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome) && produto.getQuantidade() > 0) {
                    return true;
            }
        }
        return false;
    }
    
    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if(produto.getNome().equals(nome)){
                return produto;
            }
        }
        return null;
    }
}

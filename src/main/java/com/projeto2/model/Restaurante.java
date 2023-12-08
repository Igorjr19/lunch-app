package com.projeto2.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Restaurante {

    private Estoque estoque;
    private ArrayList<Pedido> pedidos;
    private int numPedidos;

    public int getNumPedidos() {
        return numPedidos;
    }

    public void setNumPedidos(int numPedidos) {
        this.numPedidos = numPedidos;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void novoPedido(int dia, int mes, int ano, String rua, int numero, String bairro, String referencia, ArrayList<String> nomesProdutos, String pagamento) {
        LocalDate dataPedido = LocalDate.of(ano, mes, dia);
        numPedidos += 1;
        Pedido novoPedido = new Pedido(numPedidos, dataPedido, rua, numero, bairro, referencia, pagamento);
        ArrayList<Produto> produtosPedido = new ArrayList<>();
        for (Produto produtoEstoque : estoque.getProdutos()) {
            for (String produto : nomesProdutos) {
                if (produto.equals(produtoEstoque.getNome())) {
                    produtosPedido.add(produtoEstoque);
                }
            }
        }
        novoPedido.setProdutos(produtosPedido);
        pedidos.add(novoPedido);
    }

    public void novoProduto(int quantidade, String nome, double valor) {
        estoque.addProduto(quantidade, nome, valor);
    }

    public void controlarEstoque(String nomeProduto, int quantidade) { // aumenta ou diminui a quantidade de um produto em um estoque
        Produto produto = estoque.buscarProduto(nomeProduto);
        produto.setQuantidade(quantidade);
    }

    public ArrayList<String> getAllProdutosName() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Produto produto : estoque.getProdutos()) {
            nomes.add(produto.getNome());
        }
        return nomes;
    }
    
    public void excluirPedido(int num) {
        int i = 0;
        for (Pedido pedido : pedidos) {
            if(pedido.getNumPedido() == num) {
                pedidos.remove(i);
            }
            i++;
        }
    }
    
    public int getQuantProduto(String nome) {
        return estoque.buscarProduto(nome).getQuantidade();
    }
}

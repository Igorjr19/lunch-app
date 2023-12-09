package com.projeto2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Restaurante implements Serializable {

    private Estoque estoque;
    private ArrayList<Pedido> pedidos;
    private int numPedidos;

    public Restaurante() {
        estoque = new Estoque();
        pedidos = new ArrayList<>();
        numPedidos = 0;
    }

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

    public void novoPedido(String rua, int numero, String bairro, String referencia, ArrayList<Produto> produtos, String pagamento) {
        LocalDate dataPedido = LocalDate.now();
        numPedidos += 1;
        Pedido novoPedido = new Pedido(numPedidos, dataPedido, rua, numero, bairro, referencia, pagamento);
        novoPedido.setProdutos(produtos);
        for (Produto produto : produtos) {
            controlarEstoque(estoque.buscarProduto(produto.getNome()).getNome(), estoque.buscarProduto(produto.getNome()).getQuantidade() - produto.getQuantidade());
        }
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
        for (int i = 0; i < pedidos.size(); i ++) {
            if (pedidos.get(i).getNumPedido() == num) {
                pedidos.remove(i);
            }
        }
    }

    public int getQuantProduto(String nome) {
        return estoque.buscarProduto(nome).getQuantidade();
    }

    public String exibirPedidos() {
        String s = new String();
        for (Pedido pedido : pedidos) {
            s += pedido.formatar();
            s += "\n\n";
        }
        return s;
    }
    
    public ArrayList<Integer> getAllNumPedidos() {
        ArrayList<Integer> pedidosNum = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            pedidosNum.add(pedido.getNumPedido());
        }
        return pedidosNum;
    }
}

package com.projeto2.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Restaurante {
    Estoque estoque;
    ArrayList<Pedido> pedidos;
    
    public void novoPedido(int dia, int mes, int ano, String rua, int numero, String bairro, String referencia, ArrayList<String> nomesProdutos, String pagamento){
        LocalDate dataPedido = LocalDate.of(ano, mes, dia);
        Pedido novoPedido = new Pedido(dataPedido, rua, numero, bairro, referencia, pagamento);
        ArrayList<Produto> produtosPedido = new ArrayList<>();
        for (Produto produtoEstoque : estoque.getProdutos()) {
            for (String produto : nomesProdutos) {
                if (produto.equals(produtoEstoque.getNome())){
                    produtosPedido.add(produtoEstoque);
                }
            }
        }
        novoPedido.setProdutos(produtosPedido);
        pedidos.add(novoPedido);
    }
    
    public void novoProduto(int quantidade, String nome, double valor){
        estoque.addProduto(quantidade, nome, valor);
    }
}

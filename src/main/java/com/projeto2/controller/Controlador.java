package com.projeto2.controller;

import com.projeto2.model.Restaurante;
import com.projeto2.model.Persistencia;
import com.projeto2.model.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor J Rodrigues
 */
public class Controlador {

    private static Restaurante restaurante;
    private static Persistencia dados;
    private static ArrayList<Produto> itensPedido = new ArrayList<>();

    public static void novoPedido(String rua, int numero, String bairro, String referencia, ArrayList<Produto> produtos, String pagamento) {
        restaurante.novoPedido(rua, numero, bairro, referencia, produtos, pagamento);
    }

    public static void novoProduto(int quantidade, String nome, double valor) {
        restaurante.novoProduto(quantidade, nome, valor);
    }

    public static void controlarEstoque(String nomeProduto, int quantidade) { // aumenta ou diminui a quantidade de um produto em um estoque
        restaurante.controlarEstoque(nomeProduto, quantidade);
    }

    public static ArrayList<String> getAllProdutosName() {
        return restaurante.getAllProdutosName();
    }

    public static void excluirPedido(int numPedido) {
        restaurante.excluirPedido(numPedido);
    }

    public static int getQuantProduto(String nome) {
        return restaurante.getQuantProduto(nome);
    }

    public static void inicializar() {
        dados = new Persistencia("data/dados.txt");
        try {
            restaurante = dados.lerDados();
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvar() {
        try {
            dados.escreverDados(restaurante);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Produto buscarProduto(String nome) {
        return restaurante.getEstoque().buscarProduto(nome);
    }

    public static void addItemPedido(String nome, int quant, double valor) {
        itensPedido.add(new Produto(quant, nome, valor));
    }

    public static void removeItemPedido(int index) {
        itensPedido.remove(index);
    }

    public static ArrayList<Produto> getItensPedido() {
        ArrayList<Produto> retornoItens = (ArrayList<Produto>) itensPedido.clone();
        itensPedido = new ArrayList<>();
        return retornoItens;
    }

    public static String exibirPedidos() {
        return restaurante.exibirPedidos();
    }
    
    public static ArrayList<Integer> getAllNumPedidos() {
        return restaurante.getAllNumPedidos();
    }
}

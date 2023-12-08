package com.projeto2.controller;

import com.projeto2.model.Restaurante;
import com.projeto2.model.Persistencia;
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

    public static void novoPedido(int dia, int mes, int ano, String rua, int numero, String bairro, String referencia, ArrayList<String> nomesProdutos, String pagamento) {
        restaurante.novoPedido(dia, mes, ano, rua, numero, bairro, referencia, nomesProdutos, pagamento);
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
        restaurante = new Restaurante();
        dados = new Persistencia("data/estoque.txt", "data/pedidos.txt");
        try {
            restaurante.setEstoque(dados.lerEstoque());
            restaurante.setPedidos(dados.lerPedidos());
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void salvar() {
        try {
            dados.escreverEstoque(restaurante.getEstoque());
            dados.escreverPedidos(restaurante.getPedidos());
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}

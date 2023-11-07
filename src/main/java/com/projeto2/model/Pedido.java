package com.projeto2.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Pedido {
    private LocalDate dataPedido;
    private String rua;
    private int numero;
    private String bairro;
    private String referencia;
    private ArrayList<Produto> produtos;
    private String pagamento;

    public Pedido(LocalDate dataPedido, String rua, int numero, String bairro, String referencia, ArrayList<Produto> produtos, String pagamento) {
        this.dataPedido = dataPedido;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.referencia = referencia;
        this.produtos = produtos;
        this.pagamento = pagamento;
    }
    
    public Pedido(LocalDate dataPedido, String rua, int numero, String bairro, String referencia, String pagamento) {
        this.dataPedido = dataPedido;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.referencia = referencia;
        this.produtos = new ArrayList<>();
        this.pagamento = pagamento;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
    
    public String listarProdutos(){
        StringBuilder s = new StringBuilder();
        for (Produto produto : produtos) {
            s.append(produto.getNome());
            s.append("\n");
        }
        return s.toString();
    }
    
    public String formatar(){
        StringBuilder s = new StringBuilder();
        s.append("Data do Pedido: ").append(dataPedido.toString()).append("\n");
        s.append("Endereço: ").append(rua).append(", ").append(numero).append(", ").append(bairro).append(", ").append(referencia).append("\n");
        s.append("Produtos do pedido:\n").append(listarProdutos());
        s.append("Forma de Pagamento: ").append(pagamento).append("\n");
        return s.toString();
    }
}

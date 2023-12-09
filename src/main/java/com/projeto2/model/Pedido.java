package com.projeto2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Igor J Rodrigues
 */
public class Pedido implements Serializable {
    private int numPedido;
    private LocalDate dataPedido;
    private String rua;
    private int numero;
    private String bairro;
    private String referencia;
    private ArrayList<Produto> produtos;
    private String pagamento;

    public Pedido(int numPedido, LocalDate dataPedido, String rua, int numero, String bairro, String referencia, ArrayList<Produto> produtos, String pagamento) {
        this.numPedido = numPedido;
        this.dataPedido = dataPedido;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.referencia = referencia;
        this.produtos = produtos;
        this.pagamento = pagamento;
    }
    
    public Pedido(int numPedido, LocalDate dataPedido, String rua, int numero, String bairro, String referencia, String pagamento) {
        this.numPedido = numPedido;
        this.dataPedido = dataPedido;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.referencia = referencia;
        this.produtos = new ArrayList<>();
        this.pagamento = pagamento;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
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
            s.append("Nome do Produto: ");
            s.append(produto.getNome());
            s.append("\nQuantidade: ");
            s.append(produto.getQuantidade());
            s.append("\nValor: R$");
            s.append(produto.getValor());
            s.append("\n");
        }
        return s.toString();
    }
    
    public double calcularValorTotal() {
        double valorTot = 0;
        for (Produto produto : produtos) {
            valorTot += produto.getValor() * produto.getQuantidade();
        }
        return valorTot;
    }
    
    public String formatar(){
        StringBuilder s = new StringBuilder();
        s.append("Nº do Pedido: ").append(numPedido).append("\n");
        s.append("Data do Pedido: ").append(dataPedido.getDayOfMonth()).append("/").append(dataPedido.getMonthValue()).append("/").append(dataPedido.getYear()).append("\n");
        s.append("Endereço: ").append(rua).append(", ").append(numero).append(", ").append(bairro).append(", ").append(referencia).append("\n");
        s.append("Produtos do pedido:\n").append(listarProdutos());
        s.append("Forma de Pagamento: ").append(pagamento).append("\n");
        s.append("Valor Total do Pedido: R$").append(calcularValorTotal());
        return s.toString();
    }
}

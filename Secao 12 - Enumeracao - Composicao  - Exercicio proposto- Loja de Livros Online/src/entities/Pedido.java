package entities;

import entities.enums.StatusDoPedido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date dataPedido;
    private StatusDoPedido statusDoPedido;

    // Associação
    private Cliente cliente;

    // Composição
    List<ItemDoProduto> itens = new ArrayList<>();

    // Constructor
    public Pedido(Date dataPedido, StatusDoPedido statusDoPedido, Cliente cliente) {
        this.dataPedido = dataPedido;
        this.statusDoPedido = statusDoPedido;
        this.cliente = cliente;
    }

    // Getter e Setter
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(StatusDoPedido statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Métodos
    public void addItem(ItemDoProduto produto) {
        itens.add(produto);
    }

    public void removeItem(ItemDoProduto produto) {
        itens.remove(produto);
    }

    public double total() {
        double soma = 0.0;
        for (ItemDoProduto item : itens) {
            soma += item.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Momento do pedido: ");
        sb.append(sdf.format(dataPedido)+"\n");
        sb.append("Status do pedido: ");
        sb.append(statusDoPedido+"\n");
        sb.append("Cliente: ");
        sb.append(cliente+"\n");
        sb.append("Itens do pedido: ");
        for (ItemDoProduto item : itens) {
            sb.append(item+"\n");
        }
        sb.append("Preço total R$: ");
        sb.append(String.format("%.2f",total()));
        return sb.toString();
    }
}

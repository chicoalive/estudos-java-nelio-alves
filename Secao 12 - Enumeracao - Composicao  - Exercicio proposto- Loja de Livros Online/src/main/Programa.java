package main;

import entities.Cliente;
import entities.ItemDoProduto;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusDoPedido;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {
    public static void main(String[] argumentos) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat formatoDeData = new SimpleDateFormat("dd/MM/yyyy");

        // --- Cadastrando cliente ---
        System.out.println("Dados do cliente: ");
        System.out.print("Nome: ");
        String nome = teclado.nextLine().trim();
        System.out.print("Email: ");
        String email = teclado.nextLine().trim();
        System.out.print("Nascimento (DD/MM/YYYY): ");
        // Lendo como String e convertendo em Date
        String dataNascimentoString = teclado.nextLine().trim();
        Date nascimento = formatoDeData.parse(dataNascimentoString);

        Cliente cliente = new Cliente(nome, email, nascimento);

        // --- Fazendo pedido ---
        System.out.println();
        System.out.println("Dados do pedido: ");
        System.out.print("Status: ");
        String statusString = teclado.nextLine().trim();
        StatusDoPedido status = StatusDoPedido.valueOf(statusString);

        Pedido pedido = new Pedido(new Date(), status, cliente);

        // --- Definindo a quantidade de itens do pedido ---
        System.out.println();
        System.out.print("Quantos itens contém o pedido: ");
        String quantidadeItensString = teclado.nextLine().trim();
        int quantidadeItens = Integer.parseInt(quantidadeItensString);

        // --- Cadastrando itens do pedido ---
        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println();
            System.out.println("Digite os dados do " + (i + 1) + "º produto: ");
            System.out.print("Nome do produto: ");
            String nomeProduto = teclado.nextLine().trim();
            System.out.print("Preço do produto: ");
            String precoString = teclado.nextLine().trim();
            double preco = Double.parseDouble(precoString);

            // Instanciando produto
            Produto produto = new Produto(nomeProduto, preco);

            System.out.print("Quantidade do produto: ");
            String quantidadeProdutoString = teclado.nextLine().trim();
            // Lendo a quantidade do produto como Integer para compatibilidade com o construtor
            int quantidadeProduto = Integer.parseInt(quantidadeProdutoString);

            ItemDoProduto itemDoProduto = new ItemDoProduto(quantidadeProduto, preco, produto);
            pedido.addItem(itemDoProduto);
        }
        System.out.println();
        System.out.println("Resumo do Pedido");
        System.out.println(pedido);
        teclado.close();

    }
}
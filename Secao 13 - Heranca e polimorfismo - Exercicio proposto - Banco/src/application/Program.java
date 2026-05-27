package application;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Quantos produtos serão cadastrados: ");
        int qtdProd = teclado.nextInt();
        List<Produto> listProdutos = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < qtdProd; i++) {
            System.out.println("Dados do " + (i + 1) + "º produto: ");
            System.out.print("Qual tipo do produto (Comum/Usado/Importado): ");
            String tipoProd = teclado.next();
            if (tipoProd.equalsIgnoreCase("Comum")) {
                System.out.print("Nome: ");
                String nomeProd = teclado.next();
                System.out.print("Preço: ");
                double precoProd = teclado.nextDouble();
                listProdutos.add(new Produto(nomeProd, precoProd));
            } else if (tipoProd.equalsIgnoreCase("Usado")) {
                System.out.print("Nome: ");
                String nomeProd = teclado.next();
                System.out.print("Preço: ");
                double precoProd = teclado.nextDouble();
                // Lê a data como String do usuário e converte para Date usando SimpleDateFormat
                System.out.print("Data de fabricação (DD/MM/YYYY): ");
                String dataFab = teclado.next();
                // String.valueOf() é desnecessário quando a variável já é String — passe direto
                Date data = sdf.parse(dataFab);
                listProdutos.add(new ProdutoUsado(nomeProd, precoProd, data));
            } else if (tipoProd.equalsIgnoreCase("Importado")) {
                System.out.print("Nome: ");
                String nomeProd = teclado.next();
                System.out.print("Preço: ");
                double precoProd = teclado.nextDouble();
                System.out.print("Taxa de importação: ");
                double taxaImportacao = teclado.nextDouble();
                listProdutos.add(new ProdutoImportado(nomeProd, precoProd, taxaImportacao));
            }
            System.out.println();
        }


        // Exibição de dados ao usuário
        for (Produto produto : listProdutos) {
            System.out.println(produto.precoTag());
        }
        teclado.close();
    }
}

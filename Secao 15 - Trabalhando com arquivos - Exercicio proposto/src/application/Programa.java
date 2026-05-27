package application;

import model.entities.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        // --- Configuração Inicial ---
        Locale.setDefault(Locale.US);
        Scanner leitorDoTeclado = new Scanner(System.in);
        Produto produto = null;

        // --- Coleta de Caminhos do Usuário ---
        System.out.print("Digite o caminho base (ex: C:\\Users\\SeuUsuario\\Desktop): ");
        String caminhoBase = leitorDoTeclado.nextLine().trim();
        System.out.print("Digite o nome da pasta de entrada: ");
        String nomePastaEntrada = leitorDoTeclado.nextLine().trim();
        System.out.print("Digite o nome do arquivo de entrada (sem .csv): ");
        String nomeArquivoEntrada = leitorDoTeclado.nextLine().trim() + ".csv";

        // --- Preparação de Pastas e Arquivos ---
        File pastaDeEntrada = new File(caminhoBase, nomePastaEntrada);
        garantirExistenciaDaPasta(pastaDeEntrada);

        File arquivoDeEntrada = new File(pastaDeEntrada, nomeArquivoEntrada);

        // --- Lógica Principal: Obter dados do produto ---
        if (arquivoDeEntrada.exists()) {
            System.out.println("Arquivo '" + nomeArquivoEntrada + "' encontrado. Lendo dados...");
            produto = lerProdutoDeArquivo(arquivoDeEntrada);
        } else {
            System.out.println("Arquivo '" + nomeArquivoEntrada + "' não encontrado. Solicitando novos dados...");
            produto = criarProdutoPeloTeclado(leitorDoTeclado);
            escreverProdutoEmArquivo(produto, arquivoDeEntrada);
        }

        // --- Verificação de Segurança para Interromper em Caso de Falha ---
        if (produto == null) {
            System.out.println("\nErro crítico: Não foi possível carregar os dados do produto do arquivo. O programa será encerrado.");
            leitorDoTeclado.close();
            return; // Termina a execução do método main imediatamente.
        }

        // --- Geração do Sumário ---
        File pastaDeSaida = new File(caminhoBase, "out");
        garantirExistenciaDaPasta(pastaDeSaida);

        File arquivoDeSumario = new File(pastaDeSaida, "summary.csv");
        escreverArquivoDeSumario(produto, arquivoDeSumario);

        System.out.println("\nProcesso finalizado.");
        leitorDoTeclado.close();
    }

    private static Produto lerProdutoDeArquivo(File arquivo) {
        try (Scanner leitorDeArquivo = new Scanner(arquivo)) {
            if (leitorDeArquivo.hasNextLine()) {
                String linha = leitorDeArquivo.nextLine();
                String[] campos = linha.split(",");

                if (campos.length >= 3) {
                    String nome = campos[0].trim();
                    double preco = Double.parseDouble(campos[1].trim());
                    int quantidade = Integer.parseInt(campos[2].trim());
                    return new Produto(nome, preco, quantidade);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro crítico: Arquivo de entrada não encontrado no momento da leitura.");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler o arquivo: O formato do preço ou da quantidade é inválido.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao ler o arquivo: " + e.getMessage());
        }
        return null;
    }

    private static Produto criarProdutoPeloTeclado(Scanner leitor) {
        System.out.println("Digite os dados do novo produto:");
        System.out.print("Nome: ");
        String nome = leitor.nextLine().trim();
        System.out.print("Preço: ");
        double preco = Double.parseDouble(leitor.nextLine());
        System.out.print("Quantidade: ");
        int quantidade = Integer.parseInt(leitor.nextLine());
        return new Produto(nome, preco, quantidade);
    }

    /**
     * CORREÇÃO: Os métodos foram atualizados para usar os nomes corretos dos getters da classe Produto.
     * ANTES: produto.getNome(), produto.getPreco(), produto.getQuantidade()
     * AGORA: produto.getNomeProduto(), produto.getPrecoProduto(), produto.getQtdProduto()
     */
    private static void escreverProdutoEmArquivo(Produto produto, File arquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            String linha = produto.getNomeProduto() + "," + produto.getPrecoProduto() + "," + produto.getQtdProduto();
            bw.write(linha);
            bw.newLine();
            System.out.println("Novo produto salvo em '" + arquivo.getName() + "'.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o novo produto no arquivo: " + e.getMessage());
        }
    }

    /**
     * CORREÇÃO: O método foi atualizado para usar o nome correto do getter da classe Produto.
     * ANTES: produto.getNome()
     * AGORA: produto.getNomeProduto()
     */
    private static void escreverArquivoDeSumario(Produto produto, File arquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            String linhaSumario = produto.getNomeProduto() + "," + String.format("%.2f", produto.valorTotal());
            bw.write(linhaSumario);
            bw.newLine();
            System.out.println("Arquivo de sumário '" + arquivo.getName() + "' criado/atualizado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao criar o arquivo de sumário: " + e.getMessage());
        }
    }

    private static void garantirExistenciaDaPasta(File pasta) {
        if (!pasta.exists()) {
            System.out.println("Criando pasta '" + pasta.getName() + "'...");
            if (pasta.mkdir()) {
                System.out.println("Pasta criada com sucesso.");
            } else {
                System.out.println("Falha ao criar a pasta.");
            }
        }
    }
}

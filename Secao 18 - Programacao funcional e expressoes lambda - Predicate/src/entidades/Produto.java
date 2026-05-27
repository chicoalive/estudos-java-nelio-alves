package entidades;

public class Produto {
    private String nome;
    private Double preco;

    public Produto(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /*
     * EVOLUÇÃO 1: Método Estático
     * - Usado para Method Reference estático (Produto::staticPredicate).
     * - Não precisa de uma instância da classe para ser chamado.
     * - Recebe o objeto 'Produto' como parâmetro para avaliação.
     */
    public static boolean staticPredicate(Produto p) {
        return p.getPreco() >= 100.0;
    }

    /*
     * EVOLUÇÃO 2: Método Não Estático (de Instância)
     * - Usado para Method Reference de instância (produto::naoEstaticoPredicate).
     * - Opera sobre o estado da própria instância (this.preco).
     * - Não recebe parâmetros, pois o objeto se autoavalia.
     */
    public boolean naoEstaticoPredicate() {
        return preco >= 100.0;
    }

    @Override
    public String toString() {
        // Alterado para exibir em uma única linha
        return "Produto: " + nome + ", Preço R$ " + String.format("%.2f", preco);
    }
}

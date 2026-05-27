package entidades;

public class Produto {

    private String nome;
    private Double preco;

    public Produto(String nome, Double preço) {
        this.nome = nome;
        this.preco = preço;
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
     * TERCEIRA ABORDAGEM - MÉTODO DE INSTÂNCIA (NÃO ESTÁTICO)
     * 
     * EVOLUÇÃO DO CÓDIGO:
     * PRIMEIRA: classe AumentarPreco separada com Consumer<Produto>
     * SEGUNDA: método estático staticModificarPreco(Produto produto)
     * TERCEIRA (atual): método de instância naoStaticModificarPreco()
     * 
     * VANTAGENS DO MÉTODO DE INSTÂNCIA:
     * 1. Não precisa passar parâmetro - usa os próprios atributos do objeto
     * 2. Mais orientado a objetos - cada objeto modifica seu próprio preço
     * 3. Pode ser usado com method reference: Produto::naoStaticModificarPreco
     * 4. Mais limpo que método estático que precisa receber o objeto
     * 
     * DIFERENÇA ENTRE STATIC E NÃO-STATIC:
     * - Static: Produto.staticModificarPreco(produto) - precisa passar o objeto
     * - Não-static: produto.naoStaticModificarPreco() - o objeto modifica a si mesmo
     * 
     * Uso com forEach: listaProdutos.forEach(Produto::naoStaticModificarPreco);
     */
    public void naoStaticModificarPreco() {
        preco = preco * 1.1;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + "\n"
                + "Preço R$ " + String.format("%.2f", preco);
    }
}

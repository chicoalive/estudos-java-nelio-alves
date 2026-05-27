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

	// Método não estático para retornar o nome em maiúsculas.
	// Usado para demonstrar method reference de instância.
	public String nomeEmCaixaAltaNaoEstatico() {
		return nome.toUpperCase();
	}
	
	// Método estático para retornar o nome de um produto em maiúsculas.
	// Usado para demonstrar method reference estático.
	public static String nomeEmCaixaAltaEstatico(Produto p) {
		return p.getNome().toUpperCase();
	}
	
	@Override
	public String toString() {
		return nome + ", " + String.format("%.2f", preco);
	}
}
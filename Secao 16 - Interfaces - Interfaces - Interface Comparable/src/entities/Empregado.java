package entities;

// Usando a interface Comparable para criar um objeto que pode ser comparado
public class Empregado implements Comparable<Empregado> {

    private String nome;
    private Double salario;

    public Empregado(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    // Serve para definir um critério de ordenação para os objetos da classe.
    @Override
    public int compareTo(Empregado o) {
        // A ordenação padrão será por nome (A-Z).
        return nome.compareTo(o.getNome());

        // Para ordenar por nome de Z-A, inverta a comparação:
        // return o.getNome().compareTo(nome);

        // Para ordenar por salário (do menor para o maior):
        // return salario.compareTo(o.getSalario());

        // Para ordenar por salário (do maior para o menor):
        // return o.getSalario().compareTo(salario);
    }

    @Override
    public String toString() {
        return "Empregado: "+nome+" - Salário R$: "+String.format("%.2f",salario);
    }
}

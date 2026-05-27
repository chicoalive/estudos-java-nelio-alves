package entities;

import java.util.Objects;

// Representa um participante com nome e e-mail.
public class Participant {
    private String name;
    private String email;

    // Construtor para criar um novo participante.
    public Participant(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Obtém o nome do participante.
    public String getName() {
        return name;
    }

    // Define o nome do participante.
    public void setName(String name) {
        this.name = name;
    }

    // Obtém o e-mail do participante.
    public String getEmail() {
        return email;
    }

    // Define o e-mail do participante.
    public void setEmail(String email) {
        this.email = email;
    }

    // Compara participantes com base no e-mail para garantir que sejam únicos.
    // Dois participantes são considerados iguais se tiverem o mesmo e-mail.
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Participant that)) return false;
        return Objects.equals(email, that.email);
    }

    // Gera um código hash baseado no e-mail.
    // Essencial para que coleções como HashSet funcionem corretamente.
    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }


    // Retorna uma representação em texto (String) do participante.
    // Útil para exibir as informações do objeto de forma legível.
    @Override
    public String toString() {
        return  "Nome: " + name + "\n"
                + "Email: " + email + "\n";
    }
}

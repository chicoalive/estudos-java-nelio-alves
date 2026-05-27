package model.entities;

public interface Forma {

    // Método abstrato que define o contrato: toda classe que implementar Forma é obrigada a fornecer sua própria implementação de area()
    // Os modificadores public e abstract são implícitos em interfaces, portanto não precisam ser declarados explicitamente
    double area();
}

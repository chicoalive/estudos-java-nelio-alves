package model.entities;

import model.enums.Cor;

// O abstract garante que a classe não precise implementar o método area()
/* A ideia é unir interface e classe abstrata para podemos escolher o que implementar se queremos tudo as duas, ou separadas. */
public abstract class FormaAbstrata implements Forma {
    // Aqui implementamos a cor, já na interface não há cor
    private Cor cor;

    public FormaAbstrata(Cor cor) {
        this.cor = cor;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
}

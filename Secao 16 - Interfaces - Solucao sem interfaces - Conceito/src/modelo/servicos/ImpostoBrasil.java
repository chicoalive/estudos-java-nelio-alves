package modelo.servicos;

public class ImpostoBrasil implements ServicoImposto {

    @Override
    public double taxa(double valor) {
        if (valor <= 100) {
            return valor * 0.2;
        } else {
            return valor * 0.15;
        }
    }

}

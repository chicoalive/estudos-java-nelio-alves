package model.services;

public class PaypalService implements OnlinePaymentService {

    //  interface OnlinePaymentService obriga a implementação dos métodos
    @Override
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        // Juro simples: 1% sobre a parcela base multiplicado pelo número do mês.
        // Taxa de pagamento: 2% fixos aplicados sobre o valor já acrescido dos juros.
        return amount * 0.01 * months;
    }
}

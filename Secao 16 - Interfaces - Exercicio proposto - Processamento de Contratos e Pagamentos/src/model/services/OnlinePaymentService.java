package model.services;

public interface OnlinePaymentService {
    // Precisar ter um método genérico, obrigando a quem implementar a interface a ter desenvolver ele.
    // Calculando a taxa de pagamento
    Double paymentFee(Double amount);

    // Calculando taxa de juros
    Double interest(Double amount, Integer months);
}

package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    // Injeção de dependência
    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContrato(Contract contract, int months) {
        // Injeção de dependência: usa a interface para aceitar qualquer serviço de pagamento.
        // O loop 'for' percorre os meses, calculando vencimentos e valores progressivos.
        // Estratégia de cálculo: 1º define a base, 2º aplica juros, 3º aplica taxa sobre o montante.

        for (int i = 1; i <= months; i++) {
            double dividedValue = contract.getTotalValue() / months;
            double interest = onlinePaymentService.interest(dividedValue, i);
            double fee = onlinePaymentService.paymentFee(dividedValue + interest);
            contract.addInstallment(new Installment(contract.getDate().plusMonths(i), dividedValue + interest+fee));
        }
    }
}

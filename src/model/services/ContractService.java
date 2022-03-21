package model.services;

import model.entities.Contract;
import model.entities.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    private PaymentService paymentService;

    public ContractService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void processContract(Contract contract, Integer months) {

        double sum = contract.getTotalValue() / months;

        for (int i = 1; i < (months + 1); i++) {
            Date date = addMonths(contract.getDate(), i);
            double updateSum = sum + paymentService.interest(sum, i);
            double fullSum = updateSum + paymentService.fee(updateSum);
            contract.addInstallment(new Installment(date, fullSum));
        }

    }

    private Date addMonths(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, i);
        return calendar.getTime();
    }


}

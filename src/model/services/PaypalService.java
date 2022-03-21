package model.services;

public class PaypalService implements PaymentService {

    private static final Double PAYMENT_FEE = 0.02;
    private static final Double MONTHLY_FEE = 0.01;


    @Override
    public Double fee(double amount) {
        return amount *= (PAYMENT_FEE);
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * MONTHLY_FEE * months;
    }
}

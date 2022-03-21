package model.services;

public interface PaymentService {

    Double fee(double amount);

    Double interest(Double amount, Integer months);

}

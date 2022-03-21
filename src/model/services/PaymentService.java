package model.services;

public interface PaymentService {

    Double fee(double tax);

    Double interest(Double amount,Integer months);

}

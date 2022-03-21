package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        int number = 8028;
        String date = "25/06/2018";
        Double value = 600.00;
        int numberInstallments = 3;

        Contract contract = new Contract(number, sdf.parse(date), value);
        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, numberInstallments);
        System.out.println("Installments");
        for (Installment n : contract.getInstallmentList()) {
            System.out.println(n);
        }


    }
}

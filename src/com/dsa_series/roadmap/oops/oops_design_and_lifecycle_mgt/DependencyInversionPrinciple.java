package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

interface PaymentProcessor {
    void processPayment();
}

class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card payment");
    }
}

class UPIPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment() {
        System.out.println("Processing UPI Payment");
    }

}

class PaymentService {
    private PaymentProcessor processor;

    public PaymentService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void makePayment() {
        processor.processPayment();
    }
}

public class DependencyInversionPrinciple {

    public static void main(String[] args) {
        PaymentProcessor creditCard = new CreditCardProcessor();
        PaymentService paymentService = new PaymentService(creditCard);
        paymentService.makePayment();

        PaymentService upiPaymentService = new PaymentService(new UPIPaymentProcessor());
        upiPaymentService.makePayment();

    }
}

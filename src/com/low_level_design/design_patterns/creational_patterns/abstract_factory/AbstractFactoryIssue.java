package com.low_level_design.design_patterns.creational_patterns.abstract_factory;

interface PaymentGateway {
    void processPayment(double amount);
}

class RazorpayGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via Razorpay : ₹" + amount);
    }
}

class PayUGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via PayU: ₹" + amount);
    }
}

interface Invoice {
    void generateInvoice();
}

class GSTInvoice implements Invoice {
    @Override
    public void generateInvoice() {
        System.out.println("Generating GST Invoice for India.");
    }
}

// Checkout Service is violating SRP as it is dealing with mutiple things like
// creating the Payment Gateway object based on the gatewayType and then
// processing the invoice.
// It should not be concerned with what of paymentGateway object should be
// created.
class CheckoutService {
    private String gatewayType;

    public CheckoutService(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public void checkout(double amount) {
        if (gatewayType == "razorpay") {
            PaymentGateway paymentGateway = new RazorpayGateway();
            paymentGateway.processPayment(amount);
        } else {
            PaymentGateway paymentGateway = new PayUGateway();
            paymentGateway.processPayment(amount);
        }
        Invoice invoice = new GSTInvoice();
        invoice.generateInvoice();
    }
}

public class AbstractFactoryIssue {
    public static void main(String[] args) {

    }
}

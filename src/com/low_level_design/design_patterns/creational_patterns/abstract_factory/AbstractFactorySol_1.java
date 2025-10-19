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

class IndiaFactory {
    public static PaymentGateway createPaymentGateway(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "razorpay":
                return new RazorpayGateway();
            case "payu":
                return new PayUGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in India:");
        }
    }

    public static Invoice creatInvoice() {
        return new GSTInvoice();
    }
}

class CheckoutService {
    private String gatewayType;

    private String countryCode;

    public CheckoutService(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public void checkout(double amount) {
        if (countryCode == "INDIA") {
            PaymentGateway paymentGateway = IndiaFactory.createPaymentGateway(gatewayType);
            paymentGateway.processPayment(amount);
            Invoice invoice = IndiaFactory.creatInvoice();
            invoice.generateInvoice();
        } else {
            // Will have to write separate factory for US.

            // Again we will be violating SRPs as we don't want to think about which
            // factory to choose.
        }

    }
}

public class AbstractFactorySol_1 {

    // In this class we provided the solution for the scenario if we are only
    // operating in India. But in case we want to expand to lets say US.
    // Then we need to have payment gateway like PayPal and Stripe and the invoicing
    // also will be generated differently.

    // The Brute force way of doing this would be to add a country code and then
    // write a
    // separate factory class for US

}

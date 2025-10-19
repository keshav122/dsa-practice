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

class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via Stripe : $" + amount);
    }
}

class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via PayPal: $" + amount);
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

class USInvoice implements Invoice {
    @Override
    public void generateInvoice() {
        System.out.println("Generating US Compliant Invoice.");
    }
}

interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);

    Invoice createInvoice();
}

class IndiaFactory implements RegionFactory {

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "razorpay":
                return new RazorpayGateway();
            case "payu":
                return new PayUGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in India:" + gatewayType);
        }
    }

    @Override
    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}

class USFactory implements RegionFactory {

    @Override
    public PaymentGateway createPaymentGateway(String gatewayType) {
        switch (gatewayType.toLowerCase()) {
            case "stripe":
                return new StripeGateway();
            case "paypal":
                return new PayPalGateway();
            default:
                throw new IllegalArgumentException("Unsupported payment gateway in US:" + gatewayType);
        }
    }

    @Override
    public Invoice createInvoice() {
        return new USInvoice();
    }
}

class CheckoutService {
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory factory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}

public class AbstractFactorySol2 {

    public static void main(String[] args) {
        // The gatewayType can also be fetched from DB or environment variables.
        CheckoutService checkoutService = new CheckoutService(new IndiaFactory(), "razorpay");
        CheckoutService checkoutServiceUS = new CheckoutService(new USFactory(), "paypal");

    }
}

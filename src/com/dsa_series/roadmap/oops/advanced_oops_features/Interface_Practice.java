/*Author: keshav122 */
package com.dsa_series.roadmap.oops.advanced_oops_features;

interface PaymentGateway {
    public void processPayment(double amount);
}

class CreditCardPayment implements PaymentGateway {

    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing credit card payment of %.2f\n", amount);
    }

}

class UPIPayment implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.printf("Processing UPI payment of %.2f\n", amount);
    }
}

public class Interface_Practice {

}

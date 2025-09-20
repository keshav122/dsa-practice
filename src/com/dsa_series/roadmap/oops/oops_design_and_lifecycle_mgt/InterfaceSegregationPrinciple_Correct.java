package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class BasicPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("I am printing");
    }

}

class AllInOnePrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("I am printing");
    }

    @Override
    public void scan() {
        System.out.println("I am scanning");
    }
}

public class InterfaceSegregationPrinciple_Correct {

    public static void main(String[] args) {

    }
}

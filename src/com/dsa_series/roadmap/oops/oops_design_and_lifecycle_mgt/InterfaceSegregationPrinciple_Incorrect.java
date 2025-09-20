package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

interface Printer {
    void print();

    void scan();

}

class BasicPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("I am printing");
    }

    // This is not good implementation as Basic Printer is forced to implement the
    // scan method even though it doesn't have
    // the capability to scan
    @Override
    public void scan() {
        System.out.println("I cannot scan");
    }

}

class AllInOnePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("I am printing");
    }

    @Override
    public void scan() {
        System.out.println("I am scanning");
    }
}

public class InterfaceSegregationPrinciple_Incorrect {

}

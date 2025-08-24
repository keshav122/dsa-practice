package com.dsa_series.roadmap.oops.advanced_oops_features.inner_classes;

interface Sample {
    public void execute();
}

abstract class Sample2 {
    abstract public void execute2();
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Sample sample = new Sample() {
            @Override
            public void execute() {
                System.out.println("Yes I did run");
            }

        };
        sample.execute();

        Sample2 sample2 = new Sample2() {
            @Override
            public void execute2() {
                System.out.println("Yes I can run from abstract classes too");
            }
        };
        sample2.execute2();
    }
}

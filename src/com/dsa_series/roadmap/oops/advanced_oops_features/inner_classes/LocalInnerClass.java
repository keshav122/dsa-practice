package com.dsa_series.roadmap.oops.advanced_oops_features.inner_classes;

class OuterClass {
    static int val = 10;
    String name = "OuterClass";

    public void execute() {
        int x = 10;
        class InnerClass {
            public void execute() {
                System.out.println("Inner Class executed" + x);
            }
        }
        // Must not change x later otherwise it will not be effectively final
        // x = x+ 10;
        InnerClass innerClass = new InnerClass();
        innerClass.execute();
    }
}

// Class defined inside method/block , It can access all of the outer Class but
// only effectively final
// local variables of method/blocl it is defined inside

public class LocalInnerClass {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.execute();
    }
}

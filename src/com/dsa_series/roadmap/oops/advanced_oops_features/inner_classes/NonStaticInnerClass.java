package com.dsa_series.roadmap.oops.advanced_oops_features.inner_classes;

class OuterClass {
    static int val = 10;
    String name = "OuterClass";

    class InnerClass {
        public void execute() {
            // We can access the val variable as it is static but not the name variable
            System.out.println("Inner Class executed");
        }
    }
}

public class NonStaticInnerClass {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        // To create the instance of inner class we have to create via the instance of
        // outer class
        innerClass.execute();
    }
}

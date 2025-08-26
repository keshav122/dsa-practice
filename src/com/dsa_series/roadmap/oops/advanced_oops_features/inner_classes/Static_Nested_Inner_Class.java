package com.dsa_series.roadmap.oops.advanced_oops_features.inner_classes;

class OuterClass {
    static int val = 10;
    String name = "OuterClass";

    static class InnerClass {
        public void execute() {
            // We can access the val variable as it is static but not the name variable
            System.out.println("Inner Class executed" + val);
        }
    }

    public void execute() {
        // InnerClass.execute()
        // Cannot directly do InnerClass.execute becuase
        // We cannot make a static reference to the non-static method execute() from the
        // type OuterClass.InnerClass
        InnerClass innerClass = new InnerClass();
        innerClass.execute();
    }
}

public class Static_Nested_Inner_Class {

    public static void main(String[] args) {
        // There is no object of OuterClass created only InnerClass object is created
        // Even though the Inner class is static we have to create a object of it
        // OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        // innerClass.execute();

        // To access the inner class via the outer class
        OuterClass outerClass = new OuterClass();
        outerClass.execute();
    }

}

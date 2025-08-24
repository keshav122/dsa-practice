package com.dsa_series.roadmap.oops.advanced_oops_features;

abstract class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("The dog " + name + " says : Woof!");
    }

}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("The cat " + name + " says : Meow!");
    }

}

public class Abstraction_Practice {

}

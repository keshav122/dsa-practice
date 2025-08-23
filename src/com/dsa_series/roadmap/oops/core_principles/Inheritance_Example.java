package com.dsa_series.roadmap.oops.core_principles;

class Product {
    private String name;
    private String category;
    private double price;

    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Name : " + name);
        System.out.println("Category : " + category);
        System.out.println("Price : " + price);
    }
}

class Electronics extends Product {
    private int warrantyPeriodInYears;
    private String brand;

    Electronics(int warrantyPeriodInYears, String brand, String name, double price) {
        super(name, "Electronics", price);
        this.warrantyPeriodInYears = warrantyPeriodInYears;
        this.brand = brand;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Warranty : " + warrantyPeriodInYears);
        System.out.println("Brand : " + brand);
    }
}

class TShirt extends Product {

    private String size;
    private String color;

    TShirt(String size, String color, String name, double price) {
        super(name, "TShirt", price);
        this.size = size;
        this.color = color;
    }

    void displayDetails() {
        System.out.println("Size : " + size);
        System.out.println("Color : " + color);
    }
}

public class Inheritance_Example {

    public static void main(String[] args) {
        Electronics electronics = new Electronics(2, "LG", "TV", 20000.0);
        electronics.displayDetails();
    }
}

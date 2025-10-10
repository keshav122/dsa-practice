package com.low_level_design.design_patterns.creational_patterns.builder;

import java.util.List;

//BurgerMeal

//Bun
//Patty

//We are building a food delivery app so we expand upon the menu
//sides
//toppings
//cheese

class BurgerMeal {
    private String bun;
    private String patty;

    // We are increasing the parameters but some of them are conditionals (they are
    // not essential or mandatory for creating a burger whereas the bun & patty are)
    // that is a customer may not want the sides and toppings
    public BurgerMeal(String bun, String patty, String sides, List<String> toppings) {
        this.bun = bun;
        this.patty = patty;
    }
}

public class BuilderIssue {

    public static void main(String[] args) {
        // Not an ideal experience for client side to explicitly add null for
        // conditionals
        BurgerMeal burgerMeal = new BurgerMeal("wheat", "veg", null, null);
    }
}

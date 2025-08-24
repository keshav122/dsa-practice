package com.dsa_series.roadmap.oops.advanced_oops_features.inner_classes;

import java.util.ArrayList;

public class AnonymousInnerClass_UseCase {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>() {
            public boolean add(Integer val) {
                System.out.println("Val is not add");
                // If we dont want to add , we can return true from here
                // If we want to add we can call the parent method
                return super.add(val);
            }
        };

        // Lets say we only want to add even numbers
        ArrayList<Integer> evenList = new ArrayList<>() {
            @Override
            public boolean add(Integer val) {
                if (val % 2 == 0) {
                    return super.add(val);
                }
                return false;
            }
        };
        evenList.add(18);
        evenList.add(9);// 9 wil not be added
        System.out.println(evenList);
    }
}

package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.util.ArrayList;
import java.util.List;

public class Lower_UpperBoundedWildCard {

    public static <T> void printArray(List<? extends T> ls) {
        for (T val : ls) {
            System.out.print(val + " ");
        }
    }

    public static void printArray1(List<? extends Number> ls) {
        for (Number val : ls) {
            System.out.print(val + " ");
        }
    }

    public static void writeArray(List<? super Integer> ls) {
        ls.add(10);// write access is allowed
        // Integer a = ls.get(0);//reading and storing is not allowed
        System.out.println(ls.get(0));// reading & printing is allowed

    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        printArray(list);

        // Raw types
        List li = new ArrayList<>();
        li.add(10);
        li.add(20);
        for (Object o : li) {
            System.out.print(o + " ");
        }

    }
}

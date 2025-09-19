package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.util.ArrayList;
import java.util.List;

class ExampleGenerics<T> {

    private List<T> list = new ArrayList<>();

    public void add(T val) {
        list.add(val);
    }

    public void removeLast() {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        } else {
            list.remove(list.size() - 1);
        }
    }

    public T getElement(int index) {
        return list.get(index);
    }

    public void print() {
        for (T elem : list) {
            System.out.print(elem + " ");
        }
    }

}

public class Generics {

    // Define generic method
    public static <T> void printArray(T[] arr) {
        for (T val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {
        ExampleGenerics<Integer> obj = new ExampleGenerics<>();
        obj.add(10);
        obj.add(20);
        System.out.println(obj.getElement(0));
        obj.removeLast();
        obj.print();

        Integer[] array = { 5, 6, 7 };
        printArray(array);
    }
}

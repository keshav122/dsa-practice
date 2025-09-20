package com.dsa_series.roadmap.oops.oops_design_and_lifecycle_mgt;

import java.util.ArrayList;
import java.util.List;

class MemoryLeakExample {

    private static List<Object> staticList = new ArrayList<>();

    public void addToStaticList(Object obj) {
        staticList.add(obj);
    }

}

public class MemoryLeak {

    public static void main(String[] args) {
        MemoryLeakExample example = new MemoryLeakExample();
        for (int i = 0; i < 1000; i++) {
            example.addToStaticList(new Object());
        }
        System.out.println("Objects added to static list");
    }

    // After the completion of main method the garbage collector will run and clear
    // the example object present in heap memory, but the static list is tied to the
    // class
    // and therefore it will not be cleared

}

package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.io.File;
import java.io.IOException;

public class FileIntro {
    public static void main(String[] args) {
        try {
            File file = new File(
                    "C:/k_workspace/dsa-practice/src/com/dsa_series/roadmap/oops/advance_programming_in_oops/testFile.txt");
            System.out.println(file.exists());
            file.createNewFile();
            System.out.println(file.exists());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

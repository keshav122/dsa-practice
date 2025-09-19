package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.io.BufferedReader;
import java.io.FileReader;

public class TryWithResources {
    public static void main(String[] args) {
        // the resource is automatically closed
        try (BufferedReader br = new BufferedReader(new FileReader(
                "C:/k_workspace/dsa-practice/src/com/dsa_series/roadmap/oops/advance_programming_in_oops/testFile.txt"));) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Line : " + line);
            }
        } catch (Exception e) {

        }
    }
}

package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(
                    "C:/k_workspace/dsa-practice/src/com/dsa_series/roadmap/oops/advance_programming_in_oops/testFile.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Line : " + line);
            }
        } catch (Exception e) {

        } finally {
            br.close();
        }
    }
}

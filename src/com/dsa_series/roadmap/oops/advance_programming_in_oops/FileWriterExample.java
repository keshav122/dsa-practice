/*Author: keshav122 */
package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(
                    "C:/k_workspace/dsa-practice/src/com/dsa_series/roadmap/oops/advance_programming_in_oops/testFile.txt"));
            bw.write("Hey! I am writing to you");
            bw.newLine();
            bw.write("Hi ! I am writing to you again !");
            bw.flush();// To instantly write to the file

        } catch (Exception e) {

        } finally {
            bw.close();
        }

    }
}

package com.dsa_series.roadmap.oops.advance_programming_in_oops;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Logger {

    private String path;

    Logger(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }

        this.path = path;
    }

    public void log(String message) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(message);
            bw.newLine();
            bw.flush();// To instantly write to the file
        } catch (Exception e) {
            System.out.println("Failed to log this message : " + message);
        }

    }
}

public class LoggingClassExample {
    public static void main(String[] args) throws IOException {
        Logger logger = new Logger(
                "C:/k_workspace/dsa-practice/src/com/dsa_series/roadmap/oops/advance_programming_in_oops/logFile.txt");
        logger.log("Please log 1");
        logger.log("Please log 2");
        logger.log("Please log 3");
    }

}

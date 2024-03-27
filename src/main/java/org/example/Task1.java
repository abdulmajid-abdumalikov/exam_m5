package org.example;

import java.io.*;
import java.util.Base64;

public class Task1 {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        Base64.Encoder encoder = Base64.getEncoder();

        try {
            FileInputStream inputStream = new FileInputStream(inputFileName);
            byte[] inputBytes = new byte[(int) new File(inputFileName).length()];
            inputStream.read(inputBytes);
            inputStream.close();

            byte[] encodedBytes = encoder.encode(inputBytes);

            FileWriter fileWriter = new FileWriter(outputFileName);
            fileWriter.write(new String(encodedBytes));
            fileWriter.close();

            System.out.println("Done!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



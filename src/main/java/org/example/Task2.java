package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Data
class Student {
    private String name;
    private int age;

}

public class Task2 {
    public static void main(String[] args) {

        String jsonFilePath = "students.json";
        String jsonContent = readJsonFile(jsonFilePath);

        Gson gson = new Gson();

        Type studentListType = new TypeToken<List<Student>>() {
        }.getType();
        List<Student> students = gson.fromJson(jsonContent, studentListType);

        int totalAge = 0;
        for (Student student : students) {
            totalAge += student.getAge();
        }
        double averageAge = (double) totalAge / students.size();

        System.out.println("O'rtacha yosh: " + averageAge);
    }

    private static String readJsonFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

package com.celllabs;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.*;
import java.util.*;

import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TestExecutor {
    private static Map<String, List<String>> map = new HashMap<>();



    public static void main(String[] args) {

        Consumer<String> print = x -> System.out.println(x);
        print.accept("java");
        System.out.println("************");

        Properties properties = new Properties();
        try (InputStream inputStream = new FileInputStream("properties.txt")) {
            properties.load(inputStream);
            System.out.println(properties.get("age"));
        } catch (IOException e) {

        }


        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Preprocess the JSON file to remove comments
            String jsonContent = preprocessJsonFile("testcases.json");

            // Read JSON content into a Map
            Map<String, List<TestCase>> testCases = objectMapper.readValue(
                    jsonContent, new TypeReference<Map<String, List<TestCase>>>() {
                    });

            // Process the test cases
            for (Map.Entry<String, List<TestCase>> entry : testCases.entrySet()) {
                String screen = entry.getKey();
                List<TestCase> cases = entry.getValue();

                System.out.println("Screen: " + screen);
                for (TestCase testCase : cases) {
                    System.out.println(testCase);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String preprocessJsonFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .filter(line -> !line.trim().startsWith("//"))
                    .collect(Collectors.joining("\n"));
        }
    }
}

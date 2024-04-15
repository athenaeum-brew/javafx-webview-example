package com.cthiebaud.javafx;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ContentLoader {
    public static String loadHTMLContentFromClasspath(String resourceName) {
        // Load HTML content from classpath resource
        try (InputStream inputStream = ContentLoader.class.getResourceAsStream(resourceName);
                Scanner scanner = new Scanner(inputStream)) {
            StringBuilder contentBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                contentBuilder.append(scanner.nextLine());
            }
            return contentBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return ""; // Return empty string if resource cannot be loaded
        }
    }

    public static String loadHTMLContentFromFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            Path path = Paths.get(filePath);
            Files.lines(path).forEach(contentBuilder::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
}

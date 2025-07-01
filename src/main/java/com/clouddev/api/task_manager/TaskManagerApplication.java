package com.clouddev.api.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TaskManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApplication.class, args);
    }

    // Add root endpoint to fix 404 error
    @GetMapping("/")
    public String home() {
        return """
                <html>
                <head><title>Task Manager API</title></head>
                <body style="font-family: Arial; margin: 40px;">
                    <h1>🚀 Task Manager API</h1>
                    <p>Welcome to the Task Manager API! Try these endpoints:</p>
                    <ul>
                        <li><a href="/api/hello">GET /api/hello</a></li>
                        <li><a href="/api/hello?name=YourName">GET /api/hello?name=YourName</a></li>
                        <li><a href="/api/status">GET /api/status</a></li>
                    </ul>
                    <p><strong>Built with Java 17 + Spring Boot 3.5.3</strong></p>
                </body>
                </html>
                """;
    }

    @GetMapping("/api/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "Developer") String name) {
        return String.format("Hello %s! Welcome to the Task Manager API.", name);
    }

    @GetMapping("/api/status")
    public String status() {
        return "Task Manager API is running successfully!";
    }
}
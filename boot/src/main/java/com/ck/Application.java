package com.ck;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.addListeners(event -> System.out.println("Application Event: " + event.getClass().getSimpleName()));
        app.run(args);
    }
}

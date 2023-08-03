package com.example.benchmarks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BenchMarkApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BenchMarkApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}

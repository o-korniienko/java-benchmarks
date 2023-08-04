package com.example.benchmarks;

import com.example.benchmarks.benchmarks.MyBenchMarks;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BenchMarkApp implements CommandLineRunner {

    private final static Integer MEASUREMENT_ITERATIONS = 2;
    private final static Integer WARMUP_ITERATIONS = 2;

    public static void main(String[] args) {
        SpringApplication.run(BenchMarkApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Options opt = new OptionsBuilder()
                // set the class name regex for benchmarks to search for to the current class
                .include(MyBenchMarks.class.getSimpleName())
                .warmupIterations(WARMUP_ITERATIONS)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                // do not use forking (if Spring @Autowired is used) or the benchmark methods will not see references stored within its class
                .forks(3)
                .warmupForks(3)
                .threads(3)
                //.shouldDoGC(true)
                .shouldFailOnError(true)
                .resultFormat(ResultFormatType.JSON)
                .result("/bencmarks-report.txt") // set this to a valid filename if you want reports
                .shouldFailOnError(true)
                .jvmArgs("-server")
                .build();

        new Runner(opt).run();*/
    }
}

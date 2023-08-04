package com.example.benchmarks;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

abstract public class BenchMarksRunner {


    private final static Integer MEASUREMENT_ITERATIONS = 2;
    private final static Integer WARMUP_ITERATIONS = 2;

    private Options options;

    @BeforeEach
     void setUp(){
        options = new OptionsBuilder()
                // set the class name regex for benchmarks to search for to the current class
                .include("\\." + this.getClass().getSimpleName() + "\\.")
                .warmupIterations(WARMUP_ITERATIONS)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                // do not use forking (if Spring @Autowired is used) or the benchmark methods will not see references stored within its class
                .forks(3)
                .threads(3)
                .shouldDoGC(true)
                .shouldFailOnError(true)
                .resultFormat(ResultFormatType.JSON)
                .result("/bencmarks-report.txt") // set this to a valid filename if you want reports
                .shouldFailOnError(true)
                .jvmArgs("-server")
                .build();
    }

    @Test
    public void executeJmhRunner() throws RunnerException {
        new Runner(options).run();
    }
}

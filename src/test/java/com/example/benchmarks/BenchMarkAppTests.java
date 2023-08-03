package com.example.benchmarks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@State(Scope.Benchmark)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BenchMarkAppTests extends BenchMarksRunner {


    private static MyService service;

    @Autowired
    void setService(MyService service) {
        BenchMarkAppTests.service = service;
    }


   /* @Setup(Level.Trial)
    public void setupBenchmark() {

    }*/

    @Benchmark
    public Object testConcat(MyBenchMarkState param) {
        service.concat(param);
        return new Object();
    }

    @Benchmark
    public long testPlus(MyBenchMarkState param) {
        return service.plus(param);
    }

    @Test
    public void test(){

    }
}

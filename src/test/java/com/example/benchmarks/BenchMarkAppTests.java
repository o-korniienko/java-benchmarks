package com.example.benchmarks;

import com.example.benchmarks.benchmarks.MyBenchMarkState;
import com.example.benchmarks.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@State(Scope.Benchmark)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class BenchMarkAppTests extends BenchMarksRunner {


    private static MyService service;

    /*@Autowired
    void setService(MyService service) {
        BenchMarkAppTests.service = service;
    }*/


    //Allows using forks
    @Setup(Level.Trial)
    public void setUp() {
        BenchMarkAppTests.service = new MyService();
    }

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

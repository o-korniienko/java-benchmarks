package com.example.benchmarks.benchmarks;

import com.example.benchmarks.service.MyService;

import org.openjdk.jmh.annotations.*;
import org.springframework.stereotype.Service;

@State(Scope.Benchmark)
@Service
public class MyBenchMarks {


    private static MyService service;

    /*@Autowired
    void setService(MyService service) {
        MyBenchMarks.service = service;
    }*/

    @Setup(Level.Trial)
    public void setUp() {
        service = new MyService();
    }

    @Benchmark
    public Object concatTest(MyBenchMarkState param) {
        service.concat(param);
        return new Object();
    }

    @Benchmark
    public long plusTest(MyBenchMarkState param) {
        return service.plus(param);
    }
}

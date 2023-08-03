package org.mysample.core;


import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyBenchMarks {


    public String getRandomText(int length) {
        //return RandomStringUtils.random(length);
        return "world";
    }

    @Fork(value = 1, warmups = 3)
    @Warmup(iterations = 3)
    @Measurement(iterations = 3)
    @BenchmarkMode(Mode.All)
    @Threads(3)
    @Benchmark
    public void concat(MyBenchMarkState param) {
        for (int i = 0; i < param.getIterations(); i++) {
            String result = param.text.concat(" " + getRandomText(param.getIterations()));
        }
    }

    @Fork(value = 1, warmups = 3)
    @Warmup(iterations = 3)
    @Measurement(iterations = 3)
    @BenchmarkMode(Mode.All)
    @Benchmark
    public void plus(MyBenchMarkState param) {
        for (int i = 0; i < param.getIterations(); i++) {
            int result = param.number + getRandomNumber(1000);
        }
    }



    public int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }




    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public void objectCreation(MyBenchMarkState param) {
        new Object();
    }

    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Benchmark
    public Object pillarsOfCreation(MyBenchMarkState param) {
        return new Object();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void blackHole(Blackhole blackhole) {
        blackhole.consume(new Object());
    }

    @Benchmark
    public double foldedLog() {
        int x = 8;

        return Math.log(x);
    }

    @Benchmark
    public double log(LogState input) {
        return Math.log(input.x);
    }
}

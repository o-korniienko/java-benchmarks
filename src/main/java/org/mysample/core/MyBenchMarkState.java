package org.mysample.core;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class MyBenchMarkState {


    @Param({"hello"})
    public String text;

    @Param({"1234567"})
    public int number;

    @Param({"100", "1000"})
    private int iterations;

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}

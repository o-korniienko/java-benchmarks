package com.example.benchmarks.service;

import com.example.benchmarks.benchmarks.MyBenchMarkState;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MyService {


    public String getRandomText(int length) {
        return RandomStringUtils.random(length);
    }


    public String concat(MyBenchMarkState param) {
        String result = "";
        for (int i = 0; i < param.getIterations(); i++) {
            result = param.text.concat(" " + getRandomText(param.getIterations()));
        }
        return result;
    }


    public long plus(MyBenchMarkState param) {
        long result = 0;
        for (int i = 0; i < param.getIterations(); i++) {
            result = param.number + getRandomNumber(1000);
        }

        return result;
    }

    public int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }
}

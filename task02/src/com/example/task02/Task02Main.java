package com.example.task02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {
        cycleGrayCode(3)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16)
            throw new IllegalArgumentException("n must be within [1;16]");

        int size = (int)Math.pow(2, n);
        return IntStream.iterate(0, x -> (x + 1) % size).map(Task02Main::grayEncode);
    }

    static int grayEncode(int g)
    {
        return g ^ (g >> 1);
    }

}

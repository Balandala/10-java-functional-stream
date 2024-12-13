package com.example.task04;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task04Main {

    public static void main(String[] args) {

        //StringBuilder out = new StringBuilder();
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))
                .lines()
                .map(String::toLowerCase)
                .flatMap(x -> Stream.of(x.split("[^a-zа-яё0-9]+")))
                .filter(w -> !w.isEmpty())
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue)
                        .reversed()
                        .thenComparing(Map.Entry::getKey)
                )
                .map(Map.Entry::getKey)
                .limit(10)
                .forEach(e -> System.out.printf("%s\n", e))
                //.forEach(x -> out.append(x + "\n"))
        ;


        //System.out.println(out);
    }

}

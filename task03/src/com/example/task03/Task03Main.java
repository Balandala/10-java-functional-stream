package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        if (stream == null || order == null || minMaxConsumer == null)
            throw new NullPointerException();

        final T[] max = (T[]) new Object[1];
        final T[] min = (T[]) new Object[1];
        final boolean[] foundNull = new boolean[]{false};
        stream.forEach(x ->
                {
                    if (x == null) {
                        foundNull[0] = true;
                        min[0] = null;
                    }

                    if (!foundNull[0] && min[0] == null && max[0] == null){
                        min[0] = x;
                        max[0] = x;
                    }


                    if (!foundNull[0] && order.compare(x, min[0]) < 0) {
                        min[0] = x;
                    }
                    if (order.compare(x, max[0]) > 0)
                        max[0] = x;
                }

        );
        minMaxConsumer.accept(min[0], max[0]);
    }
}

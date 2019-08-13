package com.danidemi.tutorial.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamTests {

    @Test
    public void reducing() {

        Stream<Integer> stream = Stream.of(1, -1, 1, -1, 1, -1, 1);

        Optional<Integer> sumOfStream = stream.reduce((a, n) -> a = a + n);

        assertEquals(1, sumOfStream.get());

    }

    @Test
    public void collecting() {

        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integers = ints.parallelStream();

        Supplier< AtomicReference<Double> > theContainer = () -> new AtomicReference<Double>(0.0);
        BiConsumer< AtomicReference<Double> , ? super Integer> accumulator = (container, nvalue) -> {
            container.set(container.get() + nvalue);
        };
        BiConsumer<AtomicReference<Double>, AtomicReference<Double>> combiner = (a, b) -> {
            double i = a.get() + b.get();
            System.out.println("combining '" + a + "' and '" + b + "' makes '" + i);
            a.set( i );
        };
        AtomicReference<Double> total = integers.
                filter(n -> n <= 10)
                .peek(n -> System.out.println(n))
                .collect(theContainer, accumulator, combiner);
        System.out.println("Total is " + total);

    }

}

package com.danidemi.tutorial.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FunctionalIntefcaceTests {

    @Test
    public void meetTheSupplier() {

        // A Supplier is just able to provide some data every time its get() is called.
        Supplier<Double> supplier = Math::random;

        for (int i = 0; i < 10; i++) {
            Double randomValue = supplier.get();
            assertTrue( randomValue >= 0 && randomValue < 1);
        }

    }

    @Test
    public void meetTheBiFunction() {

        // A Bifunction is a function with two arguments, just f(x,y).
        BiFunction<Double, Double, Double> areaOfRectangle = (x,y) -> x*y;

        assertEquals(12.0, areaOfRectangle.apply(3.0,4.0) );

    }

    @Test
    public void meetTheBinaryOperator() {

        BinaryOperator<String> concatenation = (s1,s2) -> s1+s2;

        assertEquals("helloworld", concatenation.apply("hello", "world") );

    }



}

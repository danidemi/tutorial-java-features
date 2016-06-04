package com.danidemi.tutorial.java.enumeration;

import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class EsotericEnumeration {



    enum City {
        ROME(23),
        DENVER(450);

        int h;

        City(int fromSeaLevel) {
            h = fromSeaLevel;
        }
    };

    enum Tranformations implements Function<Double, Double> {

        DOUBLE(new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return aDouble * 2;
            }
        }),
        SQUARE(x -> x * x );


        private Function<Double, Double> function;

        Tranformations(Function<Double, Double> function){
            this.function = function;
        }

        @Override
        public Double apply(Double aDouble) {
            return function.apply(aDouble);
        }
    };

    @Test
    public void esotericEnumeration() {

        List<Double> transformed = asList(12.3, 3.4)
                .stream()
                .map(Tranformations.DOUBLE)
                .collect(Collectors.toList());

    }

}

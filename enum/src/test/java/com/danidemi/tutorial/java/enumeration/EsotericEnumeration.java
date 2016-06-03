package com.danidemi.tutorial.java.enumeration;

import org.junit.Test;

import java.util.function.Function;

import static com.danidemi.tutorial.java.enumeration.EsotericEnumeration.XXX.*;

public class EsotericEnumeration {



    enum City {
        ROME(23),
        DENVER(450);

        int h;

        City(int fromSeaLevel) {
            h = fromSeaLevel;
        }
    };

    enum XXX {

        A(new Function<Double, Double>() {
            @Override
            public Double apply(Double aDouble) {
                return null;
            }
        }),
        B( x -> {return x * x;} );



        private Function<Double, Double> f;

        XXX(Function<Double, Double> f){
            this.f = f;
        }
    };

    @Test
    public void esotericEnumeration() {

        XXX a = A;

    }

}

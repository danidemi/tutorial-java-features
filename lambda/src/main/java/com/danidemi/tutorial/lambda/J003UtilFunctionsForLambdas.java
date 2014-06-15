/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.danidemi.tutorial.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author danidemi
 */
public class J003UtilFunctionsForLambdas {
    
    static class Person {
        
        private final int hInCm;
        private final String name;
        private int ageInYears;
        private double weightInKg;

        public Person(int hInCm, String name, int ageInYears, double weightInKg) {
            this.hInCm = hInCm;
            this.name = name;
            this.ageInYears = ageInYears;
            this.weightInKg = weightInKg;
        }

        public int getHeightInCm() {
            return hInCm;
        }

        public String getName() {
            return name;
        }

        public int getAgeInYears() {
            return ageInYears;
        }

        public double getWeightInKg() {
            return weightInKg;
        }
        
        @Override
        public String toString() {
            return String.format("%s, %d cm, %d yrs", name, hInCm, ageInYears);
        }
        
        boolean isSmallerThan(int max) {
            return getHeightInCm() < max;
        }    
        
        
        
        
    }
    
    static class Finder {
        static Collection<Person> find( Collection<Person> items, Predicate<Person> predicate){
            ArrayList<Person> list = new ArrayList<Person>();
            for (Person item : items) {
                if(predicate.test(item)){
                    list.add( item );
                }
            }
            return list;
        }
        
        static <Out> Collection<Out> transform( Collection<Person> items, java.util.function.Function<Person, Out> f){
            ArrayList<Out> list = new ArrayList<Out>();
            for (Person item : items) {
                Out o = f.apply(item);
                list.add( o );
            }
            return list;
        }
    }
    
    public static void main(String[] args) {
        new J003UtilFunctionsForLambdas().run();
    }
    
    static boolean isSmall(Person p) {
        return p.getHeightInCm() < 165;
    }
    


    private void run() {
        
        // our list of people
        List<Person> people = new ArrayList<Person>( Arrays.asList(
            new Person(180, "John", 17, 78.5),
            new Person(170, "Carlo", 24, 98.1),
            new Person(160, "Iker", 39, 54.2),
            new Person(150, "Cornelius", 48, 48.5)
        ));
        
        // we'll have to put people here
        Collection<Person> smallPeople;
        
        // a very verbose way
        Predicate<Person> predicate = new Predicate<Person>() {

            @Override
            public boolean test(Person t) {
                return t.getHeightInCm() < 165;
            }
        
        };
        
        smallPeople = Finder.find(people, predicate);
        System.out.println( smallPeople );
        
        // classic way with inline anonymous interface
        smallPeople = Finder.find(people, new Predicate<Person>() {
            
            @Override
            public boolean test(Person t) {
                return t.getHeightInCm() < 165;
            }
            
        });
        System.out.println( smallPeople );
        
        // with lambdas
        smallPeople = Finder.find(people, person -> person.getHeightInCm() < 165);
        System.out.println( smallPeople );
        
        // with method reference
        smallPeople = Finder.find(people, J003UtilFunctionsForLambdas::isSmall);
        System.out.println( smallPeople );        
        

        
        
        Collection<String> names = Finder.transform(people, person -> person.getName() );
        System.out.println( names );
        

        
    }
    
}

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

        public Person(int hInCm, String name, int ageInYears) {
            this.hInCm = hInCm;
            this.name = name;
            this.ageInYears = ageInYears;
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

        @Override
        public String toString() {
            return String.format("%s, %d cm, %d yrs", name, hInCm, ageInYears);
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
    }
    
    public static void main(String[] args) {
        new J003UtilFunctionsForLambdas().run();
    }

    private void run() {
        
        // our list of people
        List<Person> people = new ArrayList<Person>( Arrays.asList(
        new Person(180, "John", 17),
        new Person(170, "Carlo", 24),
        new Person(160, "Iker", 39),
        new Person(150, "Cornelius", 48)));
        
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
        
    }
    
}

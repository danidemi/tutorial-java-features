package com.danidemi.tutorial.generics;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author danidemi
 */
public class J002Wildcards {

    public static void main(String[] args) {
        new J002Wildcards().run();
    }
    
    // This only prints List of objects, not i.e. lists of Integers,
    // because List<Integer> is not a subclass of List<Object>
    public static void printListOfObject(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }
    
    // This one prints List of everything
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem + " ");
        }
        System.out.println();
    }    
    
    // This only prints List of Numbers.
    // The "?" here is called "Upper Bounded Wildcard"
    public static void printListOfNumbers(List<? extends Number> list) {
        for (Number elem : list) {
            System.out.println(elem.doubleValue() + " ");
        }
        System.out.println();
    }    

    private void run() {
        
       List<Object> objects = Arrays.asList( new Object(), "Hello", 34 );
       
       List<Number> numbers = Arrays.asList( 134L, 284, 324.24f, 123.3 );
       
       // This does not compiles. List<Number> is not a subclass of List<Object>
       //printListOfObject( numbers );
       printListOfObject( objects );
       
       printListOfNumbers(numbers);
        
    }
    
}

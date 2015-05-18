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
            System.out.println(elem);
        }
    }
    
    // This one prints List of everything
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    }    
    
    // This prints List of Numbers or whatever is a Number.
    // The "?" here is called "Upper Bounded Wildcard"
    public static void printListOfNumbers(List<? extends Number> list) {
        for (Number elem : list) {
            System.out.println(elem);
        }
    }    

    private void run() {
       
       List<Object> objects = Arrays.asList( new Object(), "Hello", 34 );
       List<Number> numbers = Arrays.asList( 134L, 284, 324.24f, 123.3 );
       List<Integer> integers = Arrays.asList( 13, 28, 324, 3 );
       
       // This does not compiles. List<Number> is not a subclass of List<Object>
       // System.out.println("printListOfObject - numbers");
       // printListOfObject( numbers );
       
       // This works, is the only thing you can pass to printListOfObject()
       System.out.println("printListOfObjects - objects");
       printListOfObject( objects );
       
       
       // This works with any list of numbers or list of subclasses of number
       System.out.println("printListOfNumbers - numbers");
       printListOfNumbers(numbers);
       
       System.out.println("printListOfNumbers - integers");
       printListOfNumbers(integers);
        
    }
    
}

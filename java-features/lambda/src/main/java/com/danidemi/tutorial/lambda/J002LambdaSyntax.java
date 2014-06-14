package com.danidemi.tutorial.lambda;

import java.text.DecimalFormat;

/**
 *
 * @author danidemi
 */
public class J002LambdaSyntax {
    
    static interface IOne {
        void method(int a, String b);
    }
    
    static interface ITwo {
        String method();
    }    
    
    static interface IThree {
        String method(long k);
    }
        
    private void run() {
        
        // a lambda that accept two parameters
        IOne i1a = (p1,p2) -> { System.out.println(p1 + ":" + p2); };
        i1a.method(42, "The number");
        
        // if the lambda is just one void method, you can save the "return"
        IOne i1b = (p1,p2) -> System.out.println(p1 + ":" + p2);
        i1b.method(42, "The number");        
        
        // if the single method in the interface have not params, it's enough to specify ()
        ITwo i2 = () -> { return "Hello"; };
        i2.method();        
        
        // standard way to represent a lambda when the single method has one param
        IThree i3a = (k) -> { return DecimalFormat.getInstance().format(k); };
        i3a.method(123L);
        
        // but if there is only one param, you can save "(" and ")"
        IThree i3 = k -> { return DecimalFormat.getInstance().format(k); };
        i3.method(123L);
        
        // ...and in general, if the body of the lambda can be represented with just one 
        // expression, you can save "{", "}" and also "return"
        IThree i3b = k -> DecimalFormat.getInstance().format(k);
        i3b.method(123L);        
        
    }
    


    public static void main(String[] args) {
        new J002LambdaSyntax().run();
    }

}

package com.danidemi.tutorial.generics;

/**
 *
 * @author danidemi
 */
public class J001Generics {
    
    // T is called "type parameter"
    public class Box<T> {
        
        private T value;

        public Box() {
        }

        public Box(T value) {
            this.value = value;
        }
        
        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
        
    }
    
    
    
    private void run() {
        
        // Here "Integer" is called "type argument"
        Box<Integer> b1 = new Box<Integer>();
        b1.setValue(123);
        
        // Again "String" is called "type argument".
        Box<String> b2 = new Box<String>();
        b2.setValue("hello");
        
        // As it is possible to declare a Box of Integers,
        // is it also possible to declare a Box of Box of Longs
        Box< Box<Long> > b3 = new Box< Box<Long> >();
        b3.setValue( new Box<Long>(123_456L) );
        
        // Is it possible not to specify any type argument,
        // to obtain a raw type.
        Box b4 = new Box();
        b4.setValue(new Object());
        
        // With a proper generic type, you get compile time checks!
        //b1 = b2; // This would not compile, commented out.
        
        // Not the same with raw types
        b4 = b2;
        
        // Pay attention with extension hierarchies.
        Box<Number> b5 = new Box<Number>();
        b5.setValue(123L);
        b5.setValue(0b00011001010);
        b5.setValue(32.423);
        
        // Box<Long> is not a subclass of Box<Number> even if Long is subclass on Number.
        //Box<Number> b6 = new Box<Long>(); // this does not compile! 
        
        
    }
    
    public static void main(String[] args) {
        new J001Generics().run();
    }
    
}

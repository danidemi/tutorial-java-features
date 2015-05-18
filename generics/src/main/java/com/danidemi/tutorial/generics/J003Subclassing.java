package com.danidemi.tutorial.generics;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

import com.danidemi.tutorial.generics.model.Animal;
import com.danidemi.tutorial.generics.model.Container;

public class J003Subclassing {
	
	private void run() {
		
		Container<Animal> c = new Container<>();
		
		Type genericSuperclass = c.getClass().getGenericSuperclass();
		System.out.println(genericSuperclass);
		

		TypeVariable<?>[] typeParameters = c.getClass().getTypeParameters();
		System.out.println(Arrays.asList(typeParameters));
		System.out.println(typeParameters[0].getTypeName());
		
		
	}
	
	public static void main(String[] args) {
		new J003Subclassing().run();
	}

}

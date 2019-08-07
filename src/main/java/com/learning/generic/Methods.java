package com.learning.generic;

public class Methods<T> {

    public static <S> S transformStatic(String value) {
	// TODO
	return null;
    }

    public static void main(String[] args) {
	Methods<Object> foo = new Methods<>();
	String variable = "Hello";
	foo.<String>transform(variable);
    }

    public T transform(T value) {
	// TODO
	System.out.printf("transform of T%n");
	return null;
    }

    public <T extends String> T transform(T value) {
	// TODO
	System.out.printf("transform of method T%n");
	return null;
    }

}

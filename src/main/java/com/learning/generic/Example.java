package com.learning.generic;

public class Example {

    public static void main(String[] args) {
	Echo<Number> echo = new Echo<Number>();
	Number result = echo.echo(1);
	result = echo.echo(1d);
	result = echo.echo(1f);
	result = echo.echo(1L);
	if (result instanceof Long) {
	    System.out.printf("It's a long!%n");
	}
	Number[] results = echo.echo(new Integer[] { 1, 2 });
		Echo<Number> t = echo.echo(new Echo<Number>());
    }

}

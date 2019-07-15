package learning.java.generic;

public class Echo<T extends Number> {

    // Echo<Number> foo;
    // Echo<Number> bar;


    public T echo(T value) {
        return value;
    }

    public Number echoNonGeneric(Number value) {
        return value;
    }

    // public NumberEcho echo(NumberEcho value) // public class NumberEcho {
    // public IntegerEcho echo(ItegerEcho value)  // public class IntegerEcho {
    public Echo<T> echo(Echo<T> value) {
        return value;
    }

    public Number[] echo(Number[] values) {
        return values;
    }
}

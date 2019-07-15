package learning.java.learncollections;


import java.util.ArrayList;

public class MyCollection {
    public static void main(String[] args) {
        var collection = new ArrayList<String>();
        collection.add("foo");
        collection.add("bar");
        collection.add("bar1");
        for (var value : collection) {
            System.out.printf("%s%n", collection.remove(value));

        }
        System.out.printf("%d%n",collection.size());

    }
}

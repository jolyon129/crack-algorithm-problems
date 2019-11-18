package com.leetcode.jolyon.amazon.DesignFiltersForBooks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.tutorialspoint.com/design_pattern/intercepting_filter_pattern.htm
public class OrFilter implements FilterInterface {
    FilterInterface first;
    FilterInterface second;

    public OrFilter(FilterInterface first, FilterInterface second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public List<Book> execute(List<Book> books) {
        List<Book> firstItem = first.execute(books);
        List<Book> secondItem = second.execute(books);
        Set<Book> res = new HashSet<>();
        for (Book b : firstItem) {
            res.add(b);
        }
        for (Book b : secondItem) {
            res.add(b);
        }
        return new ArrayList<>(res);
    }
}

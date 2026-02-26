package ru.shul.objects;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    @FunctionalInterface
    public interface Test<T> {
        boolean test(T t);
    }

    public static <T> List<T> filter(List<T> list, Test<T> test) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (test.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

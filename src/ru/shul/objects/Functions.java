package ru.shul.objects;

import java.util.ArrayList;
import java.util.List;

public class Functions {

    @FunctionalInterface
    public interface Transform<T, P> {
        P apply(T value);
    }

    public static <T, P> List<P> transformList(List<T> list, Transform<T, P> func) {
        List<P> result = new ArrayList<>();
        for (T item : list) {
            result.add(func.apply(item));
        }
        return result;
    }
}

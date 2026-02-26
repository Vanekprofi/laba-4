package ru.shul.objects;

import java.util.List;

public class Reduce {

    @FunctionalInterface
    public interface Reducer<T> {
        T reduce(T accumulator, T current);
    }

    public static <T> T reduceList(List<T> list, T emptyValue, Reducer<T> reducer) {
        T result = emptyValue;
        for (T item : list) {
            result = reducer.reduce(result, item);
        }
        return result;
    }
}

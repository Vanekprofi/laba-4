package ru.shul.objects;

import java.util.*;
import java.util.function.*;

public class CollectorUtil {

    public static <T, R> R collect(
            Iterable<T> src,
            Supplier<R> supplier,
            BiConsumer<R, T> accumulator
    ) {
        R result = supplier.get();
        for (T t : src) {
            accumulator.accept(result, t);
        }
        return result;
    }
}

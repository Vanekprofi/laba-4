package ru.shul.main;

import ru.shul.objects.*;
import ru.shul.points.*;
import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println("\nЗадание 1.1");

            Box<Integer> intBox = new Box<>();
            intBox.put(3);
            System.out.println("Значение из коробки: " + intBox.get());

            System.out.println("\nЗадание 1.2");

            Storage<Integer> storage1 = new Storage<>(null);
            System.out.println("В хранилище: " + storage1.getValue(0));

            Storage<Integer> storage2 = new Storage<>(99);
            System.out.println("В хранилище: " + storage2.getValue(-1));

            Storage<String> storage3 = new Storage<>(null);
            System.out.println("В хранилище: " + storage3.getValue("default"));

            Storage<String> storage4 = new Storage<>("hello");
            System.out.println("В хранилище: " + storage4.getValue("hello world"));

            System.out.println("\nЗадание 2.3");

            Box<Point> pointBox = new Box<>();
            put3DPoint(pointBox);
            System.out.println(pointBox);


            List<String> words = Arrays.asList("qwerty", "asdfg", "zx");
            List<Integer> numbers = Arrays.asList(1, -3, 7);
            List<int[]> arrays = Arrays.asList(
                    new int[]{-1, -2, -3},
                    new int[]{-100, 0, 100},
                    new int[]{-10, 135, -235, 323, 23}
            );

            System.out.println("\nЗадание 3.1");

            List<Integer> lengths = Functions.transformList(words, (String s) -> s.length());
            System.out.println("Длины строк: " + lengths);

            List<Integer> abs = Functions.transformList(numbers, (Integer n) -> Math.abs(n));
            System.out.println("Модули чисел: " + abs);

            List<Integer> maxValues = Functions.transformList(arrays,
                    (int[] arr) -> {
                        int max = arr[0];
                        for (int i = 1; i < arr.length; i++) {
                            if (arr[i] > max) {
                                max = arr[i];
                            }
                        }
                        return max;
                    }
            );
            System.out.println("Максимумы: " + maxValues);

            System.out.println("\nЗадание 3.2");

            List<String> longStrings = Filter.filter(words, (String s) -> s.length() >= 3);
            System.out.println("Фильтр строк >=3: " + longStrings);

            List<Integer> positives = Filter.filter(numbers, (Integer n) -> n > 0);
            System.out.println("Положительные: " + positives);

            List<int[]> noPositiveArrays = Filter.filter(arrays,
                    arr -> Arrays.stream(arr).noneMatch(x -> x > 0));
            System.out.println("Массивы без положительных элементов:");
            for (int[] arr : noPositiveArrays) {
                System.out.println(Arrays.toString(arr));
            }

            System.out.println("\nЗадание 3.3");

            String string = Reduce.reduceList(words, "", (acc, s) -> acc + s);
            System.out.println("Обьединение строк: " + string);

            Integer sum = Reduce.reduceList(numbers, 0, Integer::sum);
            System.out.println("Сумма чисел: " + sum);

            List<List<Integer>> list = Arrays.asList(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(4, 5, 6),
                    Arrays.asList(7, 8, 9, 10, 0)
            );
            Integer count = Reduce.reduceList(
                    Functions.transformList(list, List::size),
                    0,
                    Integer::sum
            );
            System.out.println("Общее количество элементов: " + count);

            System.out.println("\nЗадание 3.4");

            List<Integer> numbersList = Arrays.asList(1, -3, 7);
            List<Integer> positiveNumbers = CollectorUtil.collect(
                    numbersList,
                    ArrayList::new,
                    (result, x) -> {
                        if (x >= 0) result.add(x);
                    }
            );

            List<Integer> negativeNumbers = CollectorUtil.collect(
                    numbersList,
                    ArrayList::new,
                    (result, x) -> {
                        if (x < 0) result.add(x);
                    }
            );

            System.out.println("Положительные: " + positiveNumbers);
            System.out.println("Отрицательные: " + negativeNumbers);

            List<String> words2 = Arrays.asList("qwerty", "asdfg", "zx", "qw");
            Map<Integer, List<String>> byLength = CollectorUtil.collect(
                    words2,
                    HashMap::new,
                    (map, s) -> map.computeIfAbsent(s.length(), k -> new ArrayList<>()).add(s)
            );

            for (Map.Entry<Integer, List<String>> entry : byLength.entrySet()) {
                System.out.println("Длина " + entry.getKey() + ": " + entry.getValue());
            }

            List<String> words3 = Arrays.asList("qwerty", "asdfg", "qwerty", "qw");
            Set<String> unique = CollectorUtil.collect(
                    words3,
                    HashSet::new,
                    Set::add
            );
            System.out.println("Уникальные строки: " + unique);

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void put3DPoint(Box<? super Point3D> box) {
            Point3D point = new Point3D(5, 7, 9);
            box.put(point);
    }
}

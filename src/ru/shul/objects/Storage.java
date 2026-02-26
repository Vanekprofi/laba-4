package ru.shul.objects;

public class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValue(T alternative) {
        return value != null ? value : alternative;
    }

    @Override
    public String toString() {
        return "Хранилище: содержимое = " + value;
    }
}

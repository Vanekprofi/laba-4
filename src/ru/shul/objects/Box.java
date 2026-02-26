package ru.shul.objects;

public class Box<T> {
    private T box;

    public Box() {}

    public boolean isFull() { return box != null; }

    public void put(T item) {
        if (isFull()) { throw new IllegalStateException("Коробка уже заполнена!"); }
        this.box = item;
    }

    public T get() {
        T item = box;
        box = null;
        return item;
    }

    @Override
    public String toString() {
        if (isFull()) {
            return "Коробка: содержимое = " + box;
        } else {
            return "Коробка пустая";
        }
    }
}

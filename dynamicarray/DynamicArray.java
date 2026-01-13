package dynamicarray;

public interface DynamicArray<T> {
    void append(T value);
    T get(int index);
    void set(int index, T value);
    int size();
    T popBack();
}

package dynamicarray;

import static java.lang.Math.max;

import java.util.Arrays;

// Problem 25.1

public class DynamicArrayImpl<T> implements DynamicArray<T> {
    private Object[] array;
    private int nValues;

    private static final int DEFAULT_CAPACITY = 4;
    private static final int MIN_CAPACITY = 4;


    public DynamicArrayImpl() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.nValues = 0;
    }

    @Override
    public void append(T value) {
        if (this.nValues == this.array.length) {
            resizeArray(2);
        }
        array[nValues] = value;
        nValues++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        verifyIndex(index);
        return (T) array[index];
    }

    @Override
    public void set(int index, T value) {
        verifyIndex(index);
        array[index] = value;
    }

    @Override
    public int size() {
        return nValues;
    }

    @Override
    public void popBack() {
        if (nValues == 0) {
            return;
        }
        array[nValues - 1] = null;
        nValues--;
        if (nValues <= array.length / 4) {
            resizeArray(0.5);
        }
    }

    private void resizeArray(double factor) {
        int newSize = max(MIN_CAPACITY, (int) (array.length * factor));
        this.array = Arrays.copyOf(this.array, newSize);
    }

    private void verifyIndex(int index) {
        if (index < 0 || index > nValues - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " out of range");
        }
    }
}

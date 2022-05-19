import java.lang.reflect.Array;

public class DynArray<T> {
    public T[] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
//        new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        if (array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            capacity = new_capacity;
            return;
        }

        T[] newArray = (T[]) Array.newInstance(this.clazz, new_capacity);
        int copyRange = capacity <= new_capacity ? capacity : new_capacity;
        for (int i = 0; i < copyRange; i++) {
            newArray[i] = array[i];
            count = newArray[i] == null ? count : count + 1;
        }
        capacity = new_capacity;
        array = newArray;
    }

    public T getItem(int index) {
        if (index >= capacity || index < 0) {
            throw new RuntimeException("Index out of range");
        }

        return array[index];
    }

    public void append(T itm) {
        int index = capacity;
        makeArray(capacity * 2);
        array[index] = itm;
    }

    public void insert(T itm, int index) {
        if (index >= capacity || index < 0) {
            throw new RuntimeException("Index out of range");
        }

        int range = capacity;
        if (array[capacity - 1] != null) {
            makeArray(capacity * 2);
            range++;
        }

        T buffer = null;
        for (int i = 0; i < range; i++) {
            if (i < index) {
                array[i] = array[i];
            }

            if (i == index) {
                buffer = array[i];
                array[i] = itm;
            }

            if (i > index) {
                T temp = array[i];
                array[i] = buffer;
                buffer = array[i];
            }
        }
    }

    public void remove(int index) {
        // ваш код
    }

}
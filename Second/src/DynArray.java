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
        System.arraycopy(array, 0, newArray, 0, new_capacity);
        count = count <= new_capacity ? count : new_capacity;
        capacity = new_capacity;
    }

    public T getItem(int index) {
        if (index >= capacity || index < 0) {
            throw new RuntimeException("Index out of range");
        }

        return array[index];
    }

    public void append(T itm) {
        if (count == capacity) {
            capacity *= 2;
            makeArray(capacity);
        }

        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        if (index >= capacity || index < 0) {
            throw new RuntimeException("Index out of range");
        }


    }

    public void remove(int index) {
        // ваш код
    }

}
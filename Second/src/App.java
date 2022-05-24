public class App {
    public static void main(String[] args) {
        System.out.println("MAIN");
        var test = new DynArray<Integer>(Integer.class);
//       System.out.println(test.getItem(16));

        test.append(4);
        test.append(5);
        test.append(7);
        test.append(3);
        test.append(4);
        test.makeArray(3);
        System.out.println(test.array.length);
        System.out.println(test.capacity);
        System.out.println(test.count);
        System.out.println(test.clazz);
        for (int i =0; i < test.capacity; i++) {
            System.out.println(test.array[i]);
        }
    }
}

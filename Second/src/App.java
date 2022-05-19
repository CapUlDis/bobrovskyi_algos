public class App {
    public static void main(String[] args) {
        System.out.println("MAIN");
        var test = new DynArray<Integer>(Integer.class);
//        test.makeArray(5);
//        for (int i = 0; i < test.array.length; i++ ) {
//            System.out.println(test.array[i]);
//        }
        test.append(3);
        System.out.println(test.getItem(16));
        System.out.println(test.array.length);
    }
}

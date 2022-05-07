public class App {
    public static void main(String[] args) {
        System.out.println("TEST START\n");

        System.out.println("PREPARING DATA\n");

        var list = new LinkedList2();
        var emptyList = new LinkedList2();

        var n1 = new Node(5);
        var n2 = new Node(7);
        var n3 = new Node(9);
        var n4 = new Node(5);
        var n5 = new Node(5);
        var n6 = new Node(3);
        var n7 = new Node(5);

        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);

        System.out.println("CHECK PREPARED DATA START");

        var n = list.head;
        while(n != null) {
            System.out.println(n.value);
            n = n.next;
        }

        System.out.println("CHECK PREPARED DATA STOP\n");

        System.out.println("CHECK METHOD FIND START\n");

        var shouldFindNode = list.find(5);
        System.out.println("FOUND VALUE " + shouldFindNode.value);

        var notShouldFindNode = list.find(666);
        System.out.println("NOT FOUND VALUE " + notShouldFindNode);

        var nodeInEmptyList = emptyList.find(10);
        System.out.println("IN EMPTY LIST " + nodeInEmptyList + "\n");

        System.out.println("CHECK METHOD FIND FINISHED\n");



        System.out.println("TEST STOP");
    }
}

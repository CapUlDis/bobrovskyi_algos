public class App {
    public static void main(String[] args) {
        System.out.println("Ass");
        var linkedList = new LinkedList();
        var n1 = new Node(5);
        var n2 = new Node(7);
        var n3 = new Node(6);
        var n4 = new Node(5);
        var n5 = new Node(9);
        var n6 = new Node(5);
        var n7 = new Node(5);
        var n8 = new Node(1);
        var n9 = new Node(5);

//        linkedList.addInTail(n1);
//        linkedList.addInTail(n2);
//        linkedList.addInTail(n3);
//        linkedList.addInTail(n4);
//        linkedList.addInTail(n5);
//        linkedList.addInTail(n6);
//        linkedList.addInTail(n7);
//        linkedList.addInTail(n8);
//        linkedList.addInTail(n9);

        System.out.println(linkedList.count());
//        Node node = linkedList.head;

//        while (node != null) {
//            System.out.println(node.value);
//            node = node.next;
//        }
//
//        System.out.println("delete===========");
        var t = linkedList.remove(5);
        System.out.println(linkedList.count());
//        node = linkedList.head;
//        while (node != null) {
//            System.out.println(node.value);
//            node = node.next;
//        }
//        System.out.println(linkedList.findAll(5));
    }
}

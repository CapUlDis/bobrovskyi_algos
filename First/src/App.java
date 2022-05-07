public class App {
    public static void main(String[] args) {
        testLinkedListMethods();
    }

    public static LinkedList getNormalList() {
        var n1 = new Node(5);
        var n2 = new Node(7);
        var n3 = new Node(8);
        var n4 = new Node(5);
        var n5 = new Node(9);
        var n6 = new Node(5);
        var n7 = new Node(5);
        var n8 = new Node(3);
        var n9 = new Node(5);

        var list = new LinkedList();

        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        list.addInTail(n8);
        list.addInTail(n9);

        return list;
    }

    public static LinkedList getEmptyList() {
        return new LinkedList();
    }

    public static LinkedList getSingleElementList() {
        var n0 = new Node(17);

        var sinElemList = new LinkedList();
        sinElemList.addInTail(n0);

        return sinElemList;
    }

    public static void testLinkedListMethods() {
        var n1 = new Node(5);
        var n2 = new Node(7);
        var n3 = new Node(8);
        var n4 = new Node(5);
        var n5 = new Node(9);
        var n6 = new Node(5);
        var n7 = new Node(5);
        var n8 = new Node(3);
        var n9 = new Node(5);

        var n0 = new Node(17);

        var nNew = new Node(66);

        var list = new LinkedList();
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(n3);
        list.addInTail(n4);
        list.addInTail(n5);
        list.addInTail(n6);
        list.addInTail(n7);
        list.addInTail(n8);
        list.addInTail(n9);

        var emptyList = new LinkedList();

        var sinElemList = new LinkedList();
        sinElemList.addInTail(n0);

        testFindAll(getNormalList(), getEmptyList(), getSingleElementList());
        testRemove();
        testRemoveAll();
    }

    public static void testFindAll(LinkedList _list, LinkedList _emptyList, LinkedList _sinElemList) {
        System.out.println("TEST FIND ALL METHOD START==========\n");
        System.out.println("TEST #1 LIST FIND EXISTING ELEMENT");
        if (_list.findAll(5).size() != 5) {
            throw new AssertionError("WRONG SEARCH RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #2 LIST FIND NON-EXISTING ELEMENT");
        if (_list.findAll(4).size() != 0) {
            throw new AssertionError("WRONG SEARCH RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #3 EMPTY LIST");
        if (_emptyList.findAll(4).size() != 0) {
            throw new AssertionError("WRONG SEARCH RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #4 SINGLE ELEMENT LIST FIND EXISTING ELEMENT");
        if (_sinElemList.findAll(17).size() != 1) {
            throw new AssertionError("WRONG SEARCH RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #5 SINGLE ELEMENT LIST FIND NON-EXISTING ELEMENT");
        if (_sinElemList.findAll(33).size() != 0) {
            throw new AssertionError("WRONG SEARCH RESULT");
        }
        System.out.println("...PASSED\n");
        System.out.println("TEST FIND ALL METHOD FINISHED==========\n");
    }

    public static void testRemove() {
        System.out.println("TEST REMOVE METHOD START==========\n");

        System.out.println("TEST #1 LIST REMOVE EXISTING ELEMENT");
        var _list = getNormalList();
        if (!_list.remove(5)) {
            throw new AssertionError("WRONG REMOVE RESULT");
        }

        var strResult = "";
        var pointer = _list.head;
        while (pointer != null) {
            strResult += pointer.value;
            pointer = pointer.next;
        }
        if (Integer.parseInt(strResult, 10) != 78595535) {
            throw new AssertionError("WRONG REMOVE RESULT: " + strResult);
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #2 LIST REMOVE NON-EXISTING ELEMENT");
        _list = getNormalList();
        if (_list.remove(20)) {
            throw new AssertionError("WRONG REMOVE RESULT");
        }

        strResult = "";
        pointer = _list.head;
        while (pointer != null) {
            strResult += pointer.value;
            pointer = pointer.next;
        }
        if (Integer.parseInt(strResult, 10) != 578595535) {
            throw new AssertionError("WRONG REMOVE RESULT: " + strResult);
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #3 EMPTY LIST REMOVE EXISTING ELEMENT");
        var _emptyList = getEmptyList();
        if (
            _emptyList.remove(5)
            || _emptyList.head != null
            || _emptyList.tail != null
        ) {
            throw new AssertionError("WRONG REMOVE RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #4 SINGLE ELEMENT LIST REMOVE EXISTING ELEMENT");
        var _sinElemList = getSingleElementList();
        if (
            !_sinElemList.remove(17)
            || _sinElemList.head != null
            || _sinElemList.tail != null
        ) {
            throw new AssertionError("WRONG REMOVE RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #5 SINGLE ELEMENT LIST REMOVE NON-EXISTING ELEMENT");
        _sinElemList = getSingleElementList();
        if (
            _sinElemList.remove(23)
            || _sinElemList.head == null
            || _sinElemList.tail == null
        ) {
            throw new AssertionError("WRONG REMOVE RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST REMOVE METHOD FINISHED==========\n");
    }

    public static void testRemoveAll() {
        System.out.println("TEST REMOVE ALL METHOD START==========\n");

        System.out.println("TEST #1 LIST REMOVE ALL EXISTING ELEMENT");
        var _list = getNormalList();
        _list.removeAll(5);

        var strResult = "";
        var pointer = _list.head;
        while (pointer != null) {
            strResult += pointer.value;
            pointer = pointer.next;
        }
        if (Integer.parseInt(strResult, 10) != 7893) {
            throw new AssertionError("WRONG REMOVE ALL RESULT: " + strResult);
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #2 LIST REMOVE ALL NON-EXISTING ELEMENT");
        _list = getNormalList();
        _list.removeAll(20);

        strResult = "";
        pointer = _list.head;
        while (pointer != null) {
            strResult += pointer.value;
            pointer = pointer.next;
        }
        if (Integer.parseInt(strResult, 10) != 578595535) {
            throw new AssertionError("WRONG REMOVE ALL RESULT: " + strResult);
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #3 EMPTY LIST REMOVE ALL EXISTING ELEMENT");
        var _emptyList = getEmptyList();
        _emptyList.remove(5);
        if (
            _emptyList.head != null
            || _emptyList.tail != null
        ) {
            throw new AssertionError("WRONG REMOVE ALL RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #4 SINGLE ELEMENT LIST REMOVE ALL EXISTING ELEMENT");
        var _sinElemList = getSingleElementList();
        _sinElemList.removeAll(17);
        if (
                _sinElemList.head != null
                || _sinElemList.tail != null
        ) {
            throw new AssertionError("WRONG REMOVE ALL RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST #5 SINGLE ELEMENT LIST REMOVE ALL NON-EXISTING ELEMENT");
        _sinElemList = getSingleElementList();
        _sinElemList.removeAll(23);
        if (
                _sinElemList.head == null
                || _sinElemList.tail == null
        ) {
            throw new AssertionError("WRONG REMOVE ALL RESULT");
        }
        System.out.println("...PASSED\n");

        System.out.println("TEST REMOVE ALL METHOD FINISHED==========\n");
    }
}

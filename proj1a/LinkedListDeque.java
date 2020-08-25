public class LinkedListDeque<T> {

    private class ItemNode {
        private ItemNode prev;
        private ItemNode next;
        private T t;

        public ItemNode(T i) {
            prev = null;
            next = null;
            t = i;
        }

        public ItemNode() {
            prev = null;
            next = null;
            t = null;
        }

        public ItemNode(ItemNode front,
                        T i, ItemNode back) {
            prev = front;
            t = i;
            next = back;
        }

        public T nodeGet(int index) {
            if (index == 0) {
                return t;
            }

            return next.nodeGet(index - 1);
        }
    }

    private int size;
    private ItemNode first;

    public LinkedListDeque() {
        first = new ItemNode();
        first.next = first;
        first.prev = first;
        size = 0;
    }

    public void addFirst(T item) {
        ItemNode newItem = new ItemNode(item);
        ItemNode temp = first.next;
        first.next = newItem;
        newItem.prev = first;
        temp.prev = newItem;
        newItem.next = temp;

        size = size + 1;
    }


    public void addLast(T item) {
        ItemNode newItem = new ItemNode(item);
        ItemNode temp = first.prev;
        temp.next = newItem;
        newItem.prev = temp;
        first.prev = newItem;
        newItem.next = first;

        size = size + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        ItemNode ptr = first.next;
        int i = 0;
        while (i < size) {
            System.out.print(ptr.t + " ");
            i = i + 1;
        }
        System.out.println();
    }

    public T removeFirst() {
        ItemNode temp = first.next;

        first.next = first.next.next;
        first.next.prev = first;

        size = Math.max(size - 1, 0);

        return temp.t;
    }

    public T removeLast() {
        ItemNode temp = first.prev;

        first.prev = first.prev.prev;
        first.prev.next = first;

        size = Math.max(size - 1, 0);
        return temp.t;
    }

    public T get(int index) {
        int position = Math.min(index, size);
        ItemNode ptr = first;
        int i = 0;
        while (i <= position) {
            ptr = ptr.next;
            i = i + 1;
        }

        return ptr.t;
    }

//    public LinkedListDeque(LinkedListDeque other) {
//        size = other.size;
//        first = new ItemNode();
//        first.next = first;
//        first.prev = first;
//        int i = 0;
//        while (i < size) {
//            this.addLast((T) other.get(i));
//            i = i + 1;
//        }
//    }

    public T getRecursive(int index) {
////        int position = Math.min(index, size);
//        if (index >= size) {
//            return null;
//        } else if (index == 0) {
//            return this.first.next.t;
//        }
//
//        LinkedListDeque temp = new LinkedListDeque();
//        temp.first = first;
//        temp.first.next = first.next.next;
//        temp.size = size - 1;
//        return (T) temp.getRecursive(index - 1);
        return first.next.nodeGet(index);
    }

//    public static void main(String[] args) {
//        LinkedListDeque<int> test = new  LinkedListDeque();
//        test.addFirst(1);
//    }
}

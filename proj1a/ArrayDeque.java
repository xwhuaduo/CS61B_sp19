public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void addFirst(T item) {
        size = size + 1;
        items[nextFirst] = item;

        nextFirst = (nextFirst - 1 + items.length) % items.length;

        if (nextFirst == nextLast) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0,
                    newItems, 0,
                    nextLast);
            System.arraycopy(items, nextFirst,
                    newItems, nextFirst + items.length,
                    items.length - nextLast);

            nextFirst = nextFirst + items.length;
            items = newItems;
        }
    }

    public void addLast(T item) {
        size = size + 1;
        items[nextLast] = item;

        nextLast = nextLast + 1;

        if (nextLast == items.length) {
            nextLast = 0;
        }

        if (nextLast == nextFirst) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0,
                    newItems, 0,
                    nextLast);
            System.arraycopy(items, nextFirst,
                    newItems, nextFirst + items.length,
                    items.length - nextLast);

            nextFirst = nextFirst + items.length;
            items = newItems;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int i = nextFirst + 1;
        while (i <= nextLast) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        if (size * 4 < items.length) {
            int newLength = items.length / 2;
            int diff = items.length - newLength;
            int indexFirst = (nextFirst + 1) % items.length;
            int indexLast = (nextLast - 1 + items.length) % items.length;

            T[] newItems = (T[]) new Object[newLength];

            if (indexFirst <= indexLast) {
                System.arraycopy(items, indexFirst,
                        newItems, 1,
                        size);
                nextFirst = 0;
                nextLast = size + 1;
            } else {
                System.arraycopy(items, 0,
                        newItems, 0,
                        indexLast + 1);
                System.arraycopy(items, indexFirst,
                        newItems, indexFirst - diff,
                        size - indexLast - 1);
                nextFirst = indexFirst - diff - 1;
            }
            items = newItems;
        }



        size = size - 1;
        nextFirst = (nextFirst + 1) % items.length;
        T value = items[nextFirst];
        items[nextFirst] = null;
        return value;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        if (size * 4 < items.length) {
            int newLength = items.length / 2;
            int diff = items.length - newLength;
            int indexFirst = (nextFirst + 1) % items.length;
            int indexLast = (nextLast - 1 + items.length) % items.length;
            T[] newItems = (T[]) new Object[newLength];

            if (indexFirst <= indexLast) {
                System.arraycopy(items, indexFirst,
                        newItems, 1,
                        size);
                nextFirst = 0;
                nextLast = size + 1;
            } else {
                System.arraycopy(items, 0,
                        newItems, 0,
                        indexLast + 1);
                System.arraycopy(items, indexFirst,
                        newItems, indexFirst - diff,
                        size - indexLast - 1);
                nextFirst = (indexFirst - diff - 1 + newItems.length) % newItems.length;
            }
            items = newItems;
        }

        if (size == 0) {
            return null;
        }

        size = size - 1;
        nextLast = (nextLast - 1 + items.length) % items.length;
        T value = items[nextLast];
        items[nextLast] = null;
        return value;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            return items[(nextFirst + 1 + index) % items.length];
        }

    }
//
//    public ArrayDeque(ArrayDeque other) {
//        items = (T[]) new Object[other.items.length];
//        nextFirst = other.nextFirst;
//        nextLast = other.nextLast;
//        size = other.size;
//
//        System.arraycopy(other, other.nextFirst+1,
//                         items, nextFirst+1,
//                         size);
//    }
//    public static void main(String[] args) {
//        ArrayDeque<Integer> arr = new ArrayDeque();
//        arr.addFirst(1);
//        arr.addFirst(2);
//        arr.addFirst(3);
//        arr.removeLast();
//        arr.addFirst(5);
//        arr.isEmpty();
//        arr.size();
//        arr.isEmpty();
//        arr.removeFirst();
//        arr.addFirst(10);
//        arr.removeLast();
//        arr.removeLast();
//        arr.removeLast();
//        arr.removeLast();
//    }
}

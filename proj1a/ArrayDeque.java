public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (T[]) new Object[100];
        nextFirst = 50;
        nextLast = 51;
        size = 0;
    }

//    public void doubleSize() {
//        T[] newItems = (T[]) new Object[this.items.length*2];
//        int newNextFirst = Math.round(size/2);
//        System.arraycopy(items, nextFirst,
//                         newItems, newNextFirst+1,
//                         size);
//
//        this.items = newItems;
//        nextFirst = newNextFirst;
//        nextLast = nextFirst+size+1;
//    }

    public void addFirst(T item) {
        size = size + 1;
        items[nextFirst] = item;

        nextFirst = nextFirst - 1;

        if (nextFirst < 0 ) {
            nextFirst = items.length -1;
        }

        if (nextFirst == nextLast) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0,
                    newItems, 0,
                    nextLast);
            System.arraycopy(items, nextFirst,
                    newItems, nextFirst+items.length,
                    items.length - nextLast);

            nextFirst = nextFirst + items.length;
            items = newItems;
        }
    }

    public void addLast(T item) {
        size = size + 1;
        items[nextLast] = item;

        nextLast = nextLast + 1;

        if (nextLast == items.length ) {
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

        size = size - 1;
        nextFirst = (nextFirst + 1) % items.length;
        T value = items[nextFirst];

        if (size * 4 < items.length) {
            int newLength = items.length/2;
            int diff = items.length - newLength;
            T[] newItems = (T[]) new Object[newLength];

            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst+1,
                        newItems, 1,
                        size);
                nextFirst = 0;
                nextLast = size + 1;
                items = newItems;
            } else {
                System.arraycopy(items, 0,
                        newItems, 0,
                        nextLast);
                System.arraycopy(items, (nextFirst+1) % items.length,
                        newItems, nextFirst - diff + 1,
                        size - nextLast);
                nextFirst = nextFirst - diff;
                items = newItems;
            }
        }
        return value;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        size = size - 1;
        nextLast = (nextLast - 1 + items.length) % items.length;
        T value = items[nextFirst];

        if (size * 4 < items.length) {
            int newLength = items.length/2;
            int diff = items.length - newLength;
            T[] newItems = (T[]) new Object[newLength];

            if (nextFirst < nextLast) {
                System.arraycopy(items, nextFirst+1,
                        newItems, 1,
                        size);
                nextFirst = 0;
                nextLast = size + 1;
                items = newItems;
            } else {
                System.arraycopy(items, 0,
                        newItems, 0,
                        nextLast);
                System.arraycopy(items, (nextFirst+1) % items.length,
                        newItems, nextFirst - diff + 1,
                        size - nextLast);
                nextFirst = nextFirst - diff;
                items = newItems;
            }
        }
        return value;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        } else {
            return items[nextFirst + 1 + index];
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
}

import java.util.NoSuchElementException;

public class ArrayDeque<Item> implements Deque<Item>{
    public int intSize = 8;
    public int size;
    public int nfirst = intSize/2;
    public int nlast = nfirst + 1;
    public Item[] s;
    
    // Constructor
    public ArrayDeque() {
        s = (Item[]) new Object[intSize];
        size = 0;
    }
    
    // Resize an array
    private void resize(int max) {
        Item[] t = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            t[i] = s[i];
        }
        s = t;
    }
    
    
    // Adds an item to the front of the Deque
    @Override
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size == s.length) {
            resize(2*s.length);
        }
        s[nfirst] = item;
        nfirst--;
        size++;
    }
    
    // Adds an item to the back of Deque
    @Override
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size == s.length) {
            resize(2*s.length);
        }
        s[nlast] = item;
        nlast++;
        size++;
    }
    
    // Returns true if deque is empty, false otherwise
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the numbers of items in the Deque
    @Override
    public int size() {
        return size;
    }
    
    // Prints the items in the Deque from first to last, separated by a space
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(s[i]);
        }
    }
    
    /* 
     * Removes and returns the item at the front of the Deque. 
     * if no such item exists, return null
     */
    @Override
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item r = s[nfirst+1];
        s[nfirst+1] = null;
        size--;
        if (size > 0 && size == s.length/4) {
            resize(s.length/2);
        }
        return r;
    }
    /* 
     * Removes and returns the item at the back of the Deque. 
     * if no such item exists, return null
     */

    @Override

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item r = s[nlast-1];
        s[nlast-1] = null;
        size--;
        if (size > 0 && size == s.length/4) {
            resize(s.length/2);
        }
        return r;
    }
    
    /*
     * Gets the item at the given index, where 0 is the front, 
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     */
    @Override
    public Item getRecursive(int index) {
        return s[index];
    }

}

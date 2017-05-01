public class ArrayDeque<Item> {
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
    
    
    // Adds an item to the front of the Deque
    public void addFirst(Item item) {
        s[nfirst] = item;
        nfirst--;
        size++;
    }
    
    // Adds an item to the back of Deque
    public void addLast(Item item) {
        s[nlast] = item;
        nlast++;
        size++;
    }
    
    // Returns true if deque is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the numbers of items in the Deque
    public int size() {
        return size;
    }
    
    // Prints the items in the Deque from first to last, separated by a space
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.println(s[i]);
        }
    }
    
    /* 
     * Removes and returns the item at the front of the Deque. 
     * if no such item exists, return null
     */
    
    public Item removeFirst() {
        Item r = s[nfirst+1];
        s[nfirst+1] = null;
        size--;
        return r;
    }
    /* 
     * Removes and returns the item at the back of the Deque. 
     * if no such item exists, return null
     */
    
    public Item removelast() {
        Item r = s[nlast-1];
        s[nlast-1] = null;
        size--;
        return r;
    }
    
    /*
     * Gets the item at the given index, where 0 is the front, 
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     */
    public Item get(int index) {
        return s[index];
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}


public class LinkedListDeque<Item> {
    private int size = 0; // declare size of linked list
    private Node<Item> head, tail;
    
    // Nested Node classes creating a node of a linked list 
    private static class Node<Item> {
        public Item item;
        public Node<Item> prev, next;
    }

    // Constructor
    public LinkedListDeque() {
        // Set up the circular sentinel
        head = new Node<Item>();
        tail = new Node<Item>();
        head.next = tail;
        head.prev = tail;
        tail.next = head;
        tail.prev = head;
    }
    // Adds an item to the front of the Deque
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> current = new Node<Item>();
        current.item = item;
        if (isEmpty()) {
            head.next = current;
            current.prev = head;
            current.next = tail;
        } else {
            Node<Item> first = head.next;
            first.prev = current;
            head.next = current;
            current.next = first;
            current.prev = head;
        }
        size++;
    }
    
    // Adds an item to the back of Deque
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> current = new Node<Item>();
        current.item = item;
        if (isEmpty()) {
            tail.prev = current;
            current.next = tail;
            current.prev = head;
        } else {
            Node<Item> last = tail.prev;
            last.next = current;
            tail.prev = current;
            current.next = tail;
            current.prev = last;
        }
        size++;
    }
    
    // Returns true if deque is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the numbers of items in the deque
    public int size() {
        return size;
    }
    
    // Prints the items in the Deque from first to last, separated by a space
    public void printDeque() {
        if (isEmpty()) {
            Node<Item> p = head.next;
            while (p.next != head) {
                System.out.println(p.item);
                p = p.next;
            }
        }
    } 
    
    /* 
     * Removes and returns the item at the front of the Deque. 
     * if no such item exists, return null
     */
    
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<Item> current = head.next;
        Node<Item> first = current.next;
        head.next = first;
        first.prev = head;
        size--;
        return current.item;
    }
    /* 
     * Removes and returns the item at the back of the Deque. 
     * if no such item exists, return null
     */
    
    public Item removelast() {
        if (size == 0) {
            return null;
        }
        Node<Item> current = tail.prev;
        Node<Item> last = current.prev;
        tail.prev = last;
        last.next = tail;
        return current.item;
    }
    
    /*
     * Gets the item at the given index, where 0 is the front, 
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     */
    public Item get(int index) {
        Node<Item> current = head.next;
        while (index != 0) {
            current = current.next;
            index--;
        }
        return current.item;
    }
    
    // Same as get method, but uses recursion
    public Item getRecursive(int index) {
        if (index == 0) {
            return head.next.item;
        }
        Node<Item> current = head.next;
        return gRhelper(index, current);
    }
    
    private Item gRhelper(int i, Node<Item> r) {
        if (i == 0) {
            return r.item;
        }
        r = r.next;
        i--;
        return gRhelper(i, r);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

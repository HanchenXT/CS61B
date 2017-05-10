// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Iterator;
import java.util.NoSuchElementException;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> implements Iterable <T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        this.capacity = capacity;
        this.rb = (T[]) new Object[this.capacity];
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
    }
    
    public int fillCount() {
        return this.fillCount;
    }
    
    @Override
    public int capacity() {
        return this.capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (fillCount == capacity) {
            throw new RuntimeException("Ring buffer overflow");
        }
        if (isEmpty()) {
            first = capacity/2 - 1;
            last = capacity/2 - 1;
        } 
        rb[last] = x;
        if (last == capacity - 1) {
            last = 0;
        } else {
            last ++;
        }
        fillCount ++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update 
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T r[] = (T[]) new Object[1]; 
        System.arraycopy(rb, first, r, 0, 1);
        if (first == capacity - 1) {
            first = 0;
        } else {
            first ++;
        }
        fillCount --;
        return r[0];
    }
    


    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }
    
    // get method is just for test purpose
    public T get(int index) {
        return rb[index];
    }
    
    // TODO: When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator() {
        return new helper();
    }
    
    // help return the Iterator 
    private class helper implements Iterator<T> {
        private int pos;
        
        private helper() {
            pos = 0;
        }
        
        public boolean hasNext() {
            return (pos < fillCount);
        }
        
        public T next() {
            T currentelement = rb[pos];
            pos++;
            return currentelement;
        }
    }
    
}

package synthesizer;
import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

import static org.junit.Assert.*;


/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<Integer>(7);
        
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.dequeue();
        arb.dequeue();
        for (int i = 4; i < 10; i++) {
            arb.enqueue(i);
        }
        assertEquals(7, arb.fillCount());
        int [] sol = {6, 7, 8, 9, 3, 4, 5};
        for (int j = 0; j < arb.capacity(); j++) {
        int k = arb.get(j);
            assertEquals(k, sol[j]);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
  
    @Test
    public void testSize() {
        
        int add = StdRandom.uniform(50, 100);
        int remove = StdRandom.uniform(49);
        OperationSequence fs = new OperationSequence();
        //StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        //ArrayDeque<Integer> stu = new ArrayDeque<>();
        LinkedListDeque<Integer> stu = new LinkedListDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        for (int i = 0; i < add; i++) {
            int num = StdRandom.uniform(100);
            stu.addFirst(num);
            sol.addFirst(num);
            DequeOperation dequeOp1 = new DequeOperation("addFirst", num);
            fs.addOperation(dequeOp1);
        }
        
        for (int i = 0; i <remove; i++) {
            
            stu.removeFirst();
            sol.removeFirst();
            DequeOperation dequeOp2 = new DequeOperation("removeFirst");
            fs.addOperation(dequeOp2);
        }
        assertEquals(fs.toString(), sol.size(), stu.size());
    }
    
    @Test
    public void testaddFirst() {
        
        int add = 100;
        OperationSequence fs = new OperationSequence();
        //StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        //ArrayDeque<Integer> stu = new ArrayDeque<>();
        LinkedListDeque<Integer> stu = new LinkedListDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        for (int i = 0; i < add; i++) {
            int num = StdRandom.uniform(100);
            stu.addFirst(num);
            sol.addFirst(num);
            DequeOperation dequeOp1 = new DequeOperation("addFirst", num);
            fs.addOperation(dequeOp1);
            assertEquals(fs.toString(), sol.getFirst(),stu.get(0));
        }
        
    }
    
    @Test
    public void testaddLast() {
        
        int add = 100;
        OperationSequence fs = new OperationSequence();
        //StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        //ArrayDeque<Integer> stu = new ArrayDeque<>();
        LinkedListDeque<Integer> stu = new LinkedListDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        for (int i = 0; i < add; i++) {
            int num = StdRandom.uniform(100);
            stu.addLast(num);
            sol.addLast(num);
            DequeOperation dequeOp1 = new DequeOperation("addLast", num);
            fs.addOperation(dequeOp1);
            assertEquals(fs.toString(), sol.get(sol.size()-1),stu.get(stu.size()-1));
        }
        
    }
    
    @Test
    public void testremoveFirst() {
        
        int add = 100;
        int remove = 100;
        OperationSequence fs = new OperationSequence();
        //StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        //ArrayDeque<Integer> stu = new ArrayDeque<>();
        LinkedListDeque<Integer> stu = new LinkedListDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        for (int i = 0; i < add; i++) {
            int num = StdRandom.uniform(100);
            stu.addFirst(num);
            sol.addFirst(num);
        }
        for (int j = 0; j < remove; j++) {
            int st = stu.removeFirst();
            int so = sol.removeFirst();
            DequeOperation dequeOp1 = new DequeOperation("removeFirst");
            fs.addOperation(dequeOp1);
            assertEquals(fs.toString(), so, st);
        }
        
    }
    
    @Test
    public void testremoveLast() {
        
        int add = 100;
        int remove = 100;
        OperationSequence fs = new OperationSequence();
        //StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        //ArrayDeque<Integer> stu = new ArrayDeque<>();
        LinkedListDeque<Integer> stu = new LinkedListDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        for (int i = 0; i < add; i++) {
            int num = StdRandom.uniform(100);
            stu.addLast(num);
            sol.addLast(num);
        }
        for (int j = 0; j < remove; j++) {
            int st = stu.removeLast();
            int so = sol.removeLast();
            DequeOperation dequeOp1 = new DequeOperation("removeLast");
            fs.addOperation(dequeOp1);
            assertEquals(fs.toString(), so, st);
        }
        
    }
    public static void main(String[] args) {
        
        jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);

    }

}

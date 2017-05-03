import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    
    @Test
    public void testaddFirst() {
        
        int num1 = StdRandom.uniform(100);
        int num2 = StdRandom.uniform(100);
        
        OperationSequence fs = new OperationSequence();
        DequeOperation dequeOp1 = new DequeOperation("addFirst", num1);
        DequeOperation dequeOp2 = new DequeOperation("addLast", num2);
        DequeOperation dequeOp3 = new DequeOperation("removeFirst");
        DequeOperation dequeOp4 = new DequeOperation("removeLast");


        fs.addOperation(dequeOp1);
        fs.addOperation(dequeOp2);
        fs.addOperation(dequeOp3);
        fs.addOperation(dequeOp4);

        System.out.println(fs.toString());

        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();

        stu.addFirst(num1);
        sol.addFirst(num1);
        assertEquals(fs.toString(), sol, stu);
    }
    
    @Test
    public void testaddLast() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        int num = StdRandom.uniform(100);
        stu.addLast(num);
        sol.addLast(num);
        assertEquals(sol, stu);
    }
    
    @Test
    public void testremoveFirst() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        int num1 = StdRandom.uniform(100);
        int num2 = StdRandom.uniform(100);
        stu.addFirst(num1);
        sol.addFirst(num1);
        stu.addLast(num2);
        sol.addLast(num2);
        stu.removeFirst();
        sol.removeFirst();
        assertEquals(sol, stu);
    }
    
    @Test
    public void testremoveLast() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        int num1 = StdRandom.uniform(100);
        int num2 = StdRandom.uniform(100);
        stu.addFirst(num1);
        sol.addFirst(num1);
        stu.addLast(num2);
        sol.addLast(num2);
        stu.removeLast();
        sol.removeLast();
        assertEquals(sol, stu);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

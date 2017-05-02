import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDeque1B {
    
    @Test
    public void testaddFirst() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<Integer>();
        int num = StdRandom.uniform(100);
        stu.addFirst(num);
        sol.addFirst(num);
        assertEquals(sol, stu);
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

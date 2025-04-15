import java.util.ArrayDeque;
public class App {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        stack.addFirst(9);
        stack.addFirst(6);
        stack.addFirst(4);
        stack.addFirst(2);
        stack.addFirst(5);
        stack.addFirst(1);
        stack.addFirst(3);
        queue.addLast(9);
        queue.addLast(6);
        queue.addLast(4);
        queue.addLast(2);
        queue.addLast(5);
        queue.addLast(1);
        queue.addLast(3);
        System.out.println("Stack Contents:");
        for(int i = stack.size(); i>0; i--){
            System.out.println(stack.removeFirst());
        }
        System.out.println("\n");
        System.out.println("Queue Contents:");
        for(int i = queue.size(); i>0; i--){
            System.out.println(queue.removeFirst());
        }

    }
}

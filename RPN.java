import java.util.Stack;
import java.util.Scanner;

public class MyClass {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        
        Scanner in = new Scanner(System.in);
        String input;

        while(in.hasNext()){
            input = in.nextLine();

            if (input.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);
            } else if (input.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if (input.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if (input.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(input));
            }
        }

        System.out.println(stack.pop());
    }
}

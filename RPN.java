package compiladores;

import java.util.Stack;
import java.util.Scanner;
import compiladores.Token;
import compiladores.TokenType;

public class RPN {
    public static void main(String args[]) {
        Stack<Token> stack = new Stack<Token>();
        
        Scanner in = new Scanner(System.in);
        String input;

        Token token = null;
        while(in.hasNext()){
            input = in.nextLine();
            if (input.equals("+")) {
                token = new Token(TokenType.PLUS, input);
                Token a = stack.pop();
                Token b = stack.pop();
                stack.push(new Token(TokenType.NUM, "" + (Integer.valueOf(b.lexeme) + Integer.valueOf(a.lexeme))));
            } else if (input.equals("-")) {
                token = new Token(TokenType.MINUS, input);
                Token a = stack.pop();
                Token b = stack.pop();
                stack.push(new Token(TokenType.NUM, "" + (Integer.valueOf(b.lexeme) - Integer.valueOf(a.lexeme))));
            } else if (input.equals("*")) {
                token = new Token(TokenType.STAR, input);
                Token a = stack.pop();
                Token b = stack.pop();
                stack.push(new Token(TokenType.NUM, "" + (Integer.valueOf(b.lexeme) * Integer.valueOf(a.lexeme))));
            } else if (input.equals("/")) {
                token = new Token(TokenType.SLASH, input);
                Token a = stack.pop();
                Token b = stack.pop();
                stack.push(new Token(TokenType.NUM, "" + (Integer.valueOf(b.lexeme) / Integer.valueOf(a.lexeme))));
            } else {
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    token = new Token(TokenType.NUM, input);
                    stack.push(token);
                } else {
                    System.out.println("Error: Unexpected character: " + input);
                }
            }
            System.out.println(token.toString());
        }

        System.out.println(stack.pop());
        token = new Token(TokenType.EOF, "");
        System.out.println(token.toString());
    }
}

import java.util.*;

class 올바른_괄호_12909 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if(stack.isEmpty()) {
                        answer = false;
                        break;
                    } else if(stack.peek() == '(') {
                        stack.pop();
                    } else {
                        answer = false;
                        break;
                    }
                    break;
            }
        }
        if(stack.size() != 0) {
            answer = false;
        }
        return answer;
    }
}
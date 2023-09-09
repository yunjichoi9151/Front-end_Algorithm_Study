import java.util.Stack;

public class 짝지어_제거하기_12973 {
class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        stack.push(arr[idx++]);
        while(idx < arr.length) {
            if(!stack.isEmpty() && stack.peek() == arr[idx]) {
                stack.pop();
                idx++;
            }
            else stack.push(arr[idx++]);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
}

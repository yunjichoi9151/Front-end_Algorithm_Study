import java.util.*;

class Solution {
    public String solution(String input_string) {
        String answer = "";
        
        ArrayList<Character> answers = new ArrayList<>();
        
        int[] alphabet = new int[26];
        
        Arrays.fill(alphabet, -1);
        
        for(int i=0; i<input_string.length(); i++){
            char ch = input_string.charAt(i);
            
            if(alphabet[ch-'a'] == -1) alphabet[ch-'a'] = i;
            else {
                if(alphabet[ch-'a'] == i-1) alphabet[ch-'a'] = i;
                else {
                    if(!answers.contains(ch)) answers.add(ch);
                }
            }
        }
        
        Collections.sort(answers);
        
        for(char c : answers) {
            answer += c;
        }
        
        if(answer.equals("")) answer = "N";
        
        return answer;
    }
}
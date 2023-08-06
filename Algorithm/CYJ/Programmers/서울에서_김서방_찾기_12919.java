package Programmers;

public class 서울에서_김서방_찾기_12919 {
    public String solution(String[] seoul) {
        for(int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }
        return "";
    }
}

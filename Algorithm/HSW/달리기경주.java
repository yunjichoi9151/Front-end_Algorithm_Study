import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        HashMap<String, Integer> playerMap =  new HashMap<>();
        
        for(int i=0; i<players.length; i++) {
            playerMap.putIfAbsent(players[i], i);
        }
        
        
        for(int i=0; i<callings.length; i++) {
            String callName = callings[i]; //호명한 선수의 이름
            
            for(int j=1; j<players.length; j++) {
                if(playerMap.containsKey(callName)) {
                    int idx = playerMap.get(callName);
                    String temp = players[idx-1];
                    players[idx-1] = callName;
                    players[idx] = temp;
                    playerMap.put(callName, idx-1);
                    playerMap.put(temp, idx);
                    break;
                }
            }
        }
        
        return players;
    }
}
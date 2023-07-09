function solution(my_string, alp) {
    var answer = '';
    
    for(let i = 0; i<my_string.length; i++){
        if(my_string.charAt(i) === alp) answer += my_string.charAt(i).toUpperCase();
        else answer += my_string.charAt(i);
    }
    
    return answer;
}
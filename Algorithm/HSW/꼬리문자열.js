function solution(str_list, ex) {
    var answer = '';
    
    for(let i of str_list) {
        if(i.indexOf(ex) != -1) continue;
        else answer += i;
    }
    
    return answer;
}
function solution(my_string) {
    var answer = [];
    
    let temp = my_string.split(' ');
    
    for(let i=0; i<temp.length; i++){
        if(temp[i] == '') continue;
        else answer.push(temp[i]);
    }
    
    
    return answer;
}
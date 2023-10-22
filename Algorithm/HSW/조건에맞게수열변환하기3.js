function solution(arr, k) {
    var answer = [];
    
    for(let i of arr) {
        if(k % 2 == 1) {
            i *= k;
        } else {
            i += k;
        } 
        answer.push(i);
    }
    
    return answer;
}
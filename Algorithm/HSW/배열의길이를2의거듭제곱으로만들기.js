function solution(arr) {
    var answer = [];
    
    let len = arr.length;
    
    let cnt = 0;
    while(len > 1) {
        len /= 2;
        cnt++;
    } 
    
    let a = Math.pow(2, cnt);
    answer = arr;
    while(answer.length < a) {
        answer.push(0);
    }
    
    return answer;
}
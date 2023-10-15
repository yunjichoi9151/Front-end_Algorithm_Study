function solution(order) {
    var answer = 0;
    
    for(let i of order) {
        if(i.includes('americano')) {
            answer += 4500;
        } else if(i.includes('cafelatte')) {
            answer += 5000;
        } else {
            answer += 4500;
        }
    }
    
    return answer;
}
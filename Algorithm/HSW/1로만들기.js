function solution(num_list) {
    var answer = 0;
    
    for(let i of num_list) {
        while(i > 1) {
            if(i % 2 === 0) {
                i /= 2;
                answer++;
            } else {
                i--;
                i /= 2;
                answer++;
            }
        }
    }
    
    return answer;
}
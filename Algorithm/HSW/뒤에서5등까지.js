function solution(num_list) {
    var answer = [];
    let new_list = [];
    new_list = num_list.sort((a, b) => a-b);
    
    for(let i=0; i<5; i++){
        answer.push(new_list[i]);
    }
    
    return answer;
}
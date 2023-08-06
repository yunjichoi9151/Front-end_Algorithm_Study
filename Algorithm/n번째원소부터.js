function solution(num_list, n) {
    var answer = [];
    
    answer = num_list.splice(n-1, num_list.length);
    
    return answer;
}
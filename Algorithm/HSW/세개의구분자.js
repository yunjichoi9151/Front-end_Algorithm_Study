function solution(myStr) {
    var answer = [];
    
    answer = myStr.split(/a|b|c/).filter((word) => word.length > 0);

    return answer.length === 0 ? ["EMPTY"] : answer;
}
function solution(myString) {
    var answer = '';
    
    myString = myString.toLowerCase();
    answer = myString.replace(/a/gi, 'A');
    
    
    return answer;
}
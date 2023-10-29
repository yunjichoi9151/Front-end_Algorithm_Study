function solution(arr, intervals) {
    var answer = [];
    
    for(let i=0; i<intervals.length; i++) {
        let a = intervals[i][0];
        let b = intervals[i][1];
        
        answer = answer.concat(arr.slice(a, b+1));
    }
    
    return answer;
}
function solution(myString) {
    var answer = [];
    
    let a =  myString.split("x");
    
    for(let i=0; i<a.length; i++) {
        answer.push(a[i].length);
    }
    
    return answer;
}
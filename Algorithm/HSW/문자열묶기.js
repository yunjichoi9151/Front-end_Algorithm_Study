function solution(strArr) {
    var answer = 0;
    
    let len = new Array(31);
    
    for(let i=0; i<=30; i++) {
        len[i] = 0;
    }
    
    for(let i=0; i<strArr.length; i++) {
        len[strArr[i].length]++;
    }
    
    let max = -1;
    for(let i=1; i<=30; i++) {
        if(max < len[i]) max = len[i]; 
    }
    
    return max;
}
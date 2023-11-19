function solution(brown, yellow) {
    var answer = [];
    
    let hor = 0; //가로 길이
    let ver = 0; //세로 길이
    
    let total = brown + yellow;
    
    for(let i=1; i<=~~Math.sqrt(total); i++) {
        if(total % i !== 0) continue;
        ver = i;
        hor = total / i;
        
        if((ver-2) * (hor-2) == yellow) [answer[0], answer[1]] = [hor, ver];
    }
    
    
    return answer;
}
function solution(n,a,b)
{
    var answer = 1;

    while(n > 1) {
        if(a < b && b - a === 1 && b % 2 === 0) return answer;
        else if(b < a && a - b === 1 && a % 2 === 0) return answer;
        
        a = Math.ceil(a / 2);
        b = Math.ceil(b / 2);
        n /= 2;
        answer++;   
    }    
    
    return answer;
}
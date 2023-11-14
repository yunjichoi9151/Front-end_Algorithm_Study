function solution(n, m, section) {
    let answer = 0;
    
    const wall = new Array(n+1);
    
    for(let i=0; i<n+1; i++) {
        wall[i] = 0;
    }
    
    for(let i=0; i<section.length; i++) {
        if(wall[section[i]] == 0) {
            answer++;
            for(let j=section[i]; j<section[i] + m; j++) wall[j]++;
        }
    }
    
    return answer;
}
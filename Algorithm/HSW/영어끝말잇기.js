function solution(n, words) {
    var answer = [];
    
    let used = []; 

    //끝말잇기가 성립되는지 먼저 확인
    for(let i=0; i<words.length; i++) {
        if(used.length === 0) {
            used.push(words[i]);
            continue;
        }
        let last = used[used.length-1];
        if(last[last.length-1] !== words[i][0] || used.includes(words[i])) {
            return [i % n + 1, ~~(i / n) + 1];
        } else used.push(words[i]);
    }

    return [0, 0];
}
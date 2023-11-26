function solution(queue1, queue2) {
    var answer = -1;
    
    const queue = [...queue1, ...queue2];
    
    let sum1 = queue1.reduce((ret, e) => ret += e);
    let sum2 = queue2.reduce((ret, e) => ret += e);
    
    let lp = 0;
    let rp = queue1.length;
    
    let cnt = 0;
    
    while(lp <= rp && sum1 !== sum2) {
        //queue1에서 dequeue, queue2에 enqueue
        //즉 lp++
        if(sum1 > sum2) {
            const node = queue[lp++];
            sum1 -= node;
            sum2 += node;
            cnt++;
            if(lp >= queue.length) lp = 0;
        } else {
            const node = queue[rp++];
            sum2 -= node;
            sum1 += node;
            cnt++;
            if(rp >= queue.length) rp = 0;
        }
    }
    
    if(sum1 === sum2) answer = cnt;
    
    return answer;
}
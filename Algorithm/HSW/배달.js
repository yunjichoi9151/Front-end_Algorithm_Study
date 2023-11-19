function dijkstra(graph, K) {
    const dist = Array(graph.length).fill(Infinity);
    const queue = [{ to: 1, dist: 0 }];
    
    dist[1] = 0;
    
    while(queue.length) {
        const { to } = queue.pop();
        graph[to].forEach((next) => {
            const acc = dist[to] + next.dist;
            if(dist[next.to] > acc) {
                dist[next.to] = acc;
                queue.push(next);
            }
        })
    }

    return dist.filter(dist => dist <= K).length;
}

function solution(N, road, K) {
    var answer = 0;

    const graph = Array.from({ length: N + 1 }, () => []);
    
    for(let data of road) {
        const st = data[0];
        const ed = data[1];
        const dist = data[2];
        
        graph[st].push({ to: ed, dist: dist });
        graph[ed].push({ to: st, dist: dist });
    }
    
    answer = dijkstra(graph, K);

    return answer;
}
function solution(arr, queries) {
    for(let i = 0; i<queries.length; i++) {
        let query = queries[i];
        
        for(let j = query[0]; j <= query[1]; j++) {
            if(j % query[2] === 0) arr[j]++;
        }
    
    }
    
    return arr;
}
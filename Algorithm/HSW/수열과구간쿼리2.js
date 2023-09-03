function solution(arr, queries) {
    let ans = [];
    
    for(let i = 0; i<queries.length; i++) {
        let min = 1000001;
        let query = queries[i];
        
        for(let j = query[0]; j <= query[1]; j++) {
            if(arr[j] > query[2] && arr[j] < min) min = arr[j];    
        }
        
        if(min === 1000001) min = -1;
        ans.push(min);    
    }
    
    return ans;
}
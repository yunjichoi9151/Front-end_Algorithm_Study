function solution(arr, queries) {
    for(let i = 0; i<queries.length; i++) {
        let temp;
        let query = queries[i];
        temp = arr[query[0]];
        arr[query[0]] = arr[query[1]];
        arr[query[1]] = temp;
    }
    
    return arr;
}
function solution(arr) {
    const a = arr.length;
    const b = arr[0].length;
    
    for(let i=0; i<a; i++) {
        for(let j=0; j<b; j++){
            if(arr[i][j] === arr[j][i]) continue;
            else return 0;
        }
    }
    
    return 1;
}
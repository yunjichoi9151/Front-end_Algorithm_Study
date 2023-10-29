function solution(arr) {
    let i = 0;
    let stk = [];
    
    while(i < arr.length) {
        if(stk.length == 0){
            stk.push(arr[i]);
            i++;
        } else if(stk[stk.length-1] == arr[i]) {
            stk.pop();
            i++;
        } else {
            stk.push(arr[i]);
            i++;
        }
    }
    
    if(stk.length == 0) stk.push(-1);
    
    return stk;
}
function solution(arr) {
    var answer = 0;
    let x = 0;
    while(true) {
        let arr2 = [];
        x++;
        let flag = false;
        for(let i of arr) {
            if(i >= 50 && i%2 === 0) {
                arr2.push(i/2);
                flag = true;
            } else if(i < 50 && i%2 === 1) {
                arr2.push(i*2+1);
                flag = true;
            }
        }
        arr = arr2;
        if(!flag) break;
    }

    
    return x-1
}
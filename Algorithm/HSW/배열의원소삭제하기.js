function solution(arr, delete_list) {
    var answer = [];
    
    for(let i of arr){
        let flag = false;
        for(let j of delete_list) {
            if(i === j) {
                flag = true;
                break;
            }
        }
        if(flag) continue;
        else answer.push(i);
    }
    
    return answer;
}
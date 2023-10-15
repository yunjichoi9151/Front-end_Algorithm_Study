function solution(num_list) {
    
    for(let i in num_list){
        if(num_list[i] < 0) return Number.parseInt(i);
    }
    
    return -1;
}
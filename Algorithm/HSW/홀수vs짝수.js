function solution(num_list) {
    let odd_sum = 0;
    let even_sum = 0;
    
    for(let i=0; i<num_list.length; i++){
        if(i % 2 == 0) even_sum += num_list[i];
        else odd_sum += num_list[i];
    }
    
    
    return even_sum > odd_sum ? even_sum : odd_sum;
}

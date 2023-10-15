function solution(arr1, arr2) {

    if(arr1.length > arr2.length) return 1;
    else if(arr1.length < arr2.length) return -1;
    else {
        let total1 = 0;
        let total2 = 0;
        for(let i of arr1) total1 += i;
        for(let i of arr2) total2 += i;
        
        if(total1 > total2) return 1;
        else if(total1 < total2) return -1;
        else return 0;
    }

}
function solution(myString) {
    var answer = [];
    
    
    let arr1 = myString.split('x');
    
    let arr2 = [];
    for(let i in arr1) {
        if(arr1[i] === "") {
            continue;
        } else {
            arr2.push(arr1[i]);
        }
    }
    
    answer = arr2.sort();
    
    return answer;
}
function solution(myString, pat) {
    var answer = 0;
    
    myString = myString.replaceAll('A', 'C');
    myString = myString.replaceAll('B', 'A');
    myString = myString.replaceAll('C', 'B');
    
    
    if(myString.includes(pat)) return 1;
    else return 0;
}
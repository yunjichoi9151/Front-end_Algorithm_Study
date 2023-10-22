function solution(binomial) {
    var answer = 0;
    
    let bi_string = binomial.split(" ");
    
    if(bi_string[1] == "+") {
        return eval(parseInt(bi_string[0]) + parseInt(bi_string[2]));
    } else if(bi_string[1] == "-") {
        return eval(parseInt(bi_string[0]) - parseInt(bi_string[2]));
    } else {
        return eval(parseInt(bi_string[0]) * parseInt(bi_string[2]));
    }
}
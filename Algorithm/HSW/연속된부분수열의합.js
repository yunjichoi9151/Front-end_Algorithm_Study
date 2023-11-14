function solution(sequence, k) {
    let answer = [0, 1000000];
    

    let [start, end] = [0, 0];
    
    let partSum = sequence[0]; //부분수열의 합

    while(end < sequence.length) {
        if(partSum == k) {
            //부분수열 합이 k가 되는 경우 길이가 짧은 수열 찾기
            //길이는 end - start 값으로 비교
            if(end - start < answer[1] - answer[0]) {
                answer[0] = start;
                answer[1] = end;
            }           
            partSum += sequence[++end];
        }
        
        else if(partSum > k) {
            partSum -= sequence[start++];
        }
        else {
            partSum += sequence[++end];
        }

    }


    return answer;
}
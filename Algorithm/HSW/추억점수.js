function solution(name, yearning, photo) {
    var answer = [];
    
    const map = new Map([]);
    
    for(let i=0; i<name.length; i++) {
        map.set(name[i], yearning[i]);
    }
    
    for(let i=0; i<photo.length; i++) {
        let point = 0;
        for(let j=0; j<photo[i].length; j++) {
            if(map.has(photo[i][j])) point += parseInt(map.get(photo[i][j]));
        }
        
        answer.push(point);
    }
    
    
    return answer;
}
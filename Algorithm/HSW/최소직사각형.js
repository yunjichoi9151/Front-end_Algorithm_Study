function solution(sizes) {
    var answer = 0;
    
    const resized = sizes.map(([w, h]) => w < h ? [h, w] : [w, h])
    
    let maxW = 0;
    let maxH = 0;
    
    resized.forEach(([w, h]) => {
        maxW = Math.max(w, maxW);
        maxH = Math.max(h, maxH);
    })
    
    return maxW * maxH;
}
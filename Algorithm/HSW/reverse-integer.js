/**
 * @param {number} x
 * @return {number}
 */
var reverse = function(x) {
    if(x < 0) {
        x *= -1;
        const answer = String(x).split("").reverse().join("") * -1;
        if(answer < -1 * Math.pow(2, 31) || answer >= Math.pow(2, 31)) return 0;
        return answer;
    }

    const answer = String(x).split("").reverse().join("")
    if(answer < -1 * Math.pow(2, 31) || answer >= Math.pow(2, 31)) return 0;
    return answer;
};
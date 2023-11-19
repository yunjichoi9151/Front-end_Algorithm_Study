function solution(skill, skill_trees) {
    let answer = 0;
    
    for(let skill_tree of skill_trees) {
        const ret = skill_tree.split("").filter(e => skill.includes(e)).join("");
        if(skill.includes(ret) && skill.startsWith(ret)) answer++;
    }

    
    return answer;
}
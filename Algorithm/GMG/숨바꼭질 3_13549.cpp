#include <iostream>
#include <queue>
using namespace std;
#define fastio() ios::sync_with_stdio(false); cin.tie(NULL)

queue<int> q;
bool visited[100001];

int main() {
    fastio();
    
    int pow2[21] = {1};
    for (int i = 1; i < 21; i++) pow2[i] = pow2[i - 1] * 2;
    
    int n, k, ppp, cnt, pppp;
    cin >> n >> k;
    visited[n] = true;
    q.push(n);
    q.push(0);
    
    while (!q.empty()) {
        ppp = q.front(); q.pop();
        cnt = q.front(); q.pop();
        if (ppp == k) { cout << cnt;  return 0; }
        
        if (ppp < 100000 && !visited[ppp + 1]) 
        { visited[ppp + 1] = true; q.push(ppp + 1); q.push(cnt + 1); }
        if (ppp > 0 && !visited[ppp - 1]) 
        { visited[ppp - 1] = true; q.push(ppp - 1); q.push(cnt + 1); }
        
        if (ppp != 0) {
        for (int i = 1; ppp * pow2[i] < 100001; i++) {
            pppp = ppp * pow2[i];
            visited[pppp] = true;
            if (pppp == k) { cout << cnt;  return 0; }

            if (pppp < 100000 && !visited[pppp + 1]) { 
                visited[pppp + 1] = true; 
                q.push(pppp + 1); 
                q.push(cnt + 1); 
            }
            if (pppp > 0 && !visited[pppp - 1]) { 
                visited[pppp - 1] = true; 
                q.push(pppp - 1); 
                q.push(cnt + 1); 
            }
        }}
    }
    return 0;
}
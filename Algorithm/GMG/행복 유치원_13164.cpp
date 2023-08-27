#include <iostream>
#include <algorithm>
using namespace std;
int diff[300000];
int main() {
    int n, k, prev, now, ans;
    cin >> n >> k >> prev;
    ans = 0;
    
    diff[0] = 0;
    for (int i = 0; i < n - 1; i++) {
        cin >> now;
        diff[i] = now - prev;
        prev = now;
    }
    
    sort (diff, diff + n - 1);
    for (int i = 0; i < n - k; i++) ans += diff[i];
    cout << ans;
    return 0;
}
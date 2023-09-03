#include <iostream>
#include <queue>
using namespace std;
#define pii pair<int, int>

priority_queue<pii> pq;
void input();
void solve();

int main()
{
    input();
    solve();
    return 0;
}

void input() {
    int n, d, t;
    cin >> n;
    while (n--) {
        cin >> d >> t;
        pq.push({t, d});
    }
}

void solve() {
    int tt, dd, ans;
    ans = pq.top().first - pq.top().second; pq.pop();
    while(!pq.empty()) {
        tt = pq.top().first;
        dd = pq.top().second;
        ans = ans - dd < tt - dd ? ans - dd : tt - dd;
        pq.pop();
    }
    cout << ans;
}
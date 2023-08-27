#include <iostream>
using namespace std;

int n, m, ans;
int arr[101];
int in[200000][2];

void input();
void process();
void solve();

int main() {
    ans = 0;
    input();
    process();
    solve();
    cout << ans;
    return 0;
}

void input() {
    cin >> n >> m;
    n *= 24;
    for (int i = 0; i < m; i++) cin >> in[i][0];
    for (int i = 0; i < m; i++) cin >> in[i][1];
}

void process() {
    arr[0] = 0;
    int remain, unit;
    for (int i = 0; i < m; i++) {
        ans += in[i][0];
        remain = 100 - in[i][0];
        unit = in[i][1];
        arr[unit] += remain / unit;
        arr[remain % unit]++;
    }
}

void solve() {
    int idx = 100;
    while (n && idx)
    {
        if (n > arr[idx]) {
            ans += arr[idx] * idx;
            n -= arr[idx];
        }
        else {
            ans += n * idx;
            n = 0;
        }
        idx--;
    }
}
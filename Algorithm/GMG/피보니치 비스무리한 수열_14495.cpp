#include <iostream>
using namespace std;
long long arr[1001][1001];

void init();
void solve();

int main() {
    init();
    solve();
    
    int n, m;
    cin >> n >> m;
    cout << arr[n][m];
    return 0;
}

void init() {
    for (int i = 1; i < 1001; i++) arr[i][1] = arr[1][i] = 1;
    return;
}

void solve() {
    for (int i = 2; i < 1001; i++) {
        for (int j = 2; j < 1001; j++) {
            arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i][j - 1];
            arr[i][j] %= 1000000007;
        }
    }
    return;
}
#define MAX 1500001
#include <iostream>
using namespace std;

int n;
int arr[MAX][2] = {0};
int dp[MAX] = {0};

void input();
void solve();

int main() {
    input();
    solve();
    return 0;
}

void input()
{
    cin >> n;
    for (int i = 0; i < n; i++) cin >> arr[i][0] >> arr[i][1];
}

void solve()
{
    int finale, outcome;
    for (int i = n - 1; i > -1; i--)
    {
        finale = arr[i][0] + i;
        outcome = arr[i][1];
        if (finale <= n && outcome + dp[finale] > dp[i + 1]) dp[i] = outcome + dp[finale];
        else dp[i] = dp[i + 1];
    }
    cout << dp[0];
}